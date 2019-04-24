package com.orderManager.service.impl;


import com.orderManager.dao.OrderDao;

import com.orderManager.dto.OrderAllDto;
import com.orderManager.dto.UserAdressDto;
import com.orderManager.service.OrderService;
import com.orderManager.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
            dao.setUnDefault(dto.getUserid());
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
        detailVo.setOdid(vo.getOdid());
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
    public boolean submitOrder(OrderDetailVo detailVo, OrderAllVo vo) {
        ShortCutVo shortCutVo = getShortCutVo(detailVo, vo);
        int cut = 0;
        int detail = dao.addOrderDetail(detailVo);
        if (detail > 0)
            cut = dao.addShortCut(shortCutVo);
        if (detail > 0 && cut > 0)
            return true;
        else if (detail>0&&!(cut > 0))
            throw new RuntimeException();
        else
            return false;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public int getOrderIdAfterAdd(OrderVo orderVo) {
        int i = dao.addOrder(orderVo);
        int orderid = 0;
        if (i > 0) {
            orderid = dao.getOrderid();
        }
        return orderid;
    }

    public void delOrder(int orderid) {
        dao.delOrder(orderid);
    }

    public List<OrderAllDto> seeOrders(SeeOrders orders) {
        return dao.seeOrders(orders);
    }

    private ShortCutVo getShortCutVo(OrderDetailVo detailVo, OrderAllVo vo) {
        ShortCutVo shortCutVo = new ShortCutVo();
        shortCutVo.setTicketcount(detailVo.getTicketcount());
        shortCutVo.setPrice(vo.getPrice());
        shortCutVo.setSingleprice(vo.getSingleprice());
        shortCutVo.setSvid(detailVo.getSvid());
        shortCutVo.setOrderid(detailVo.getOrderid());
        return shortCutVo;
    }
}
