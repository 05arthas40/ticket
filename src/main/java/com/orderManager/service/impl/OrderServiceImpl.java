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
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao dao;

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
    public int submitOrder(OrderAllVo vo) {
        OrderDetailVo detailVo = getOrderDetailVo(vo);
        OrderVo orderVo = getOrderVo(vo);
        int orderrow = dao.addOrder(orderVo);
        int detail = 0;
        int orderid = 0;
        if (orderrow > 0) {
            String url = getSnapShotUrl(detailVo.getSvid(), detailVo.getTicketcount());
            orderid = dao.getOrderid(orderVo.getOrdertime(), orderVo.getUaphone());
            detailVo.setOrderid(orderid);
            detail = dao.addOrderDetail(detailVo);
            if (detail == 0)
                throw new RuntimeException("数据异常");
        } else
            throw new RuntimeException("数据异常");
        return orderid;
    }

    public String getSnapShotUrl(int svid, int ticketcount) {
        RequestConfig config = RequestConfig.custom()
                .setSocketTimeout(5000).setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000).build();
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(config).build();
        HttpGet httpGet = new HttpGet("http://10.3.135.52:8080/ticket/snapshot.html?svid=" + svid + "&count=" + ticketcount);
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String entitystr = null;
        try {
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            if (entity != null) {
                entitystr = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            }
            entitystr = entitystr.replaceAll("localhost:", "http://10.3.135.52:8080");
            System.out.println(entitystr);
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
        return "";
    }


    public List<OrderAllDto> seeOrders(SeeOrders orders) {
        return dao.seeOrders(orders);
    }

    public OrderDto getOrderByOrderId(int orderid) {

        return dao.getOrderByOrderId(orderid).get(0);
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
