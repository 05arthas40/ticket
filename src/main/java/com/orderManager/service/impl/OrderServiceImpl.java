package com.orderManager.service.impl;


import com.orderManager.dao.OrderDao;

import com.orderManager.dto.FlowsDto;
import com.orderManager.dto.OrderAllDto;
import com.orderManager.dto.OrderDto;
import com.orderManager.dto.UserAdressDto;
import com.orderManager.service.OrderService;
import com.orderManager.vo.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao dao;
    private ScheduledExecutorService service = Executors
            .newSingleThreadScheduledExecutor();
    public List<UserAdressDto> getAddresses(int userid) {
        return dao.getAddresses(userid);
    }

    public int editAddress(UserAdressDto dto) {
        if (dto.getIsDefault() == 1) {
            int i = dao.setUnDefault(dto.getUserid());
        }
        return dao.editAddress(dto);
    }

    public int addAddress(UserAdressDto dto) {
        if (dto.getIsDefault() == 1) {
            dao.setUnDefault(dto.getUserid());
        }
        return dao.addAddress(dto);
    }

    public UserAdressDto getAddressByUaid(int uaid) {
        return dao.getAddressByUaid(uaid);
    }

    public boolean delAddresses(int uaid) {
        return dao.delAddresses(uaid) == 1 ? true : false;
    }

    public OrderDetailVo getOrderDetailVo(OrderAllVo vo) {
        OrderDetailVo detailVo = new OrderDetailVo();
        detailVo.setTicketcount(vo.getTicketcount());
        detailVo.setSvid(vo.getSvid());
        return detailVo;
    }

    public OrderVo getOrderVo(OrderAllVo vo) {
        OrderVo orderVo = new OrderVo();
        orderVo.setCid(vo.getCid());
        orderVo.setDiscount(vo.getDiscount());
        orderVo.setExpfee(vo.getExpfee());
        orderVo.setStatus(vo.getStatus());
        orderVo.setOrdertime(vo.getOrdertime());
        orderVo.setTotalprice(vo.getTotalprice());
        orderVo.setUserid(vo.getUserid());
        orderVo.setUaddress(vo.getUaddress());
        orderVo.setUaname(vo.getUaname());
        orderVo.setUaphone(vo.getUaphone());
        return orderVo;
    }

    @Transactional
    public int submitOrder(OrderAllVo vo, String path, String hostpath) {

        OrderDetailVo detailVo = getOrderDetailVo(vo);
        OrderVo orderVo = getOrderVo(vo);

        dao.reduceCount(detailVo.getTicketcount(),detailVo.getSvid());
        int orderrow = dao.addOrder(orderVo);
        Runnable runnable = new Runnable() {
            public void run() {
                int i = dao.timeOutCancelOrder(orderVo.getOrderid());
                if (i > 0)
                    dao.addCount(detailVo.getTicketcount(), detailVo.getSvid());
            }
        };

// 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 60 * 1000, 10, TimeUnit.MILLISECONDS);
        int detail = 0;
        int orderid = 0;
        if (orderrow > 0) {
            String url = getSnapShotUrl(detailVo.getSvid(), detailVo.getTicketcount(), path, hostpath);
            orderid = dao.getOrderid(orderVo.getOrdertime(), orderVo.getUaphone());
            detailVo.setOrderid(orderid);
            detailVo.setShoturl(url);
            detail = dao.addOrderDetail(detailVo);
            if (detail == 0)
                throw new RuntimeException("数据异常");
        } else
            throw new RuntimeException("数据异常");
        return orderid;
    }

    public String getSnapShotUrl(int svid, int ticketcount, String path, String hostpath) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/ticket_test_war_exploded/geturl?svid=" + svid + "&count=" + ticketcount);
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String entitystr = null;
        File file = null;
        try {
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            if (entity != null) {
                entitystr = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            }
            System.out.println(entitystr);
            File file1 = new File(path);
            if (!file1.exists())
                file1.mkdirs();
            file = new File(file1, UUID.randomUUID() + ".html");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
            bw.write(entitystr);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return  hostpath+"/"+file.getName();
    }


    public List<OrderAllDto> seeOrders(SeeOrders orders) {
        return dao.seeOrders(orders);
    }

    public OrderDto getOrderByOrderId(int orderid) {
        List<OrderDto> orders = dao.getOrderByOrderId(orderid);
        return orders.get(0);
    }

    public int getFlowByTrade_no(String trade_no) {
        return dao.getFlowByTrade_no(trade_no);
    }

    public Object getFlowByOrderid(int orderid) {
        return dao.getFlowByOrderid(orderid);
    }

    public int addFlow(FlowsVo flowsVo) {
        return dao.addFlow(flowsVo);
    }

    public int updateFlow(FlowsVo flowsVo) {
        return dao.updateFlow(flowsVo);
    }

    public List<FlowsDto> getFlows() {
        return dao.getFlows();
    }

    public int setSuccess(int orderid) {
        return dao.setSuccess(orderid);
    }

}
