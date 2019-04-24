package com.orderManager.controller;

import com.alibaba.fastjson.JSONObject;
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
//import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
import com.orderManager.dto.OrderAllDto;
import com.orderManager.dto.UserAdressDto;
import com.orderManager.service.OrderService;
import com.orderManager.vo.OrderAllVo;
import com.orderManager.vo.OrderDetailVo;
import com.orderManager.vo.OrderVo;
import com.orderManager.vo.SeeOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService service;


    @RequestMapping(value = "getAddresses", method = RequestMethod.GET)
    public Object getAddresses(int userid) {
        return service.getAddresses(userid);
    }


    @RequestMapping(value = "getAddressByUaid", method = RequestMethod.POST)
    public Object getAddressByUaid(int uaid) {
        System.out.println(uaid);
        System.out.println(service.getAddressByUaid(uaid));
        return service.getAddressByUaid(uaid);
    }


    @RequestMapping(value = "delAddresses", method = RequestMethod.GET)
    public boolean delAddresses(int uaid) {
        return service.delAddresses(uaid);
    }

    @RequestMapping(value = "addAddress", method = RequestMethod.POST)
    public Object addAddress(@RequestBody UserAdressDto dto) {
        System.out.println(dto);
        return service.addAddress(dto);
    }

    @RequestMapping(value = "editAddress", method = RequestMethod.POST)
    public Object editAddress(@RequestBody UserAdressDto dto) {
        System.out.println(dto);
        System.out.println(service.editAddress(dto));
        return service.editAddress(dto);
    }

    @RequestMapping(value = "submitOrder", method = RequestMethod.POST)
    public boolean submitOrder(@RequestBody OrderAllVo vo) {
        System.out.println(vo);
        OrderDetailVo detailVo = service.getOrderDetailVo(vo);
        OrderVo orderVo = service.getOrderVo(vo);
        int orderid = 0;
        boolean flag = false;
        try {
            orderid = service.getOrderIdAfterAdd(orderVo);
            if (orderid > 0) {
                try {
                    detailVo.setOrderid(orderid);
                    flag = service.submitOrder(detailVo, vo);
                } catch (Exception e) {
                    service.delOrder(detailVo.getOrderid());
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flag;
    }

    @RequestMapping(value = "seeOrders", method = RequestMethod.GET)
    public Object seeOrders(SeeOrders orders) {
        System.out.println(orders);
        List<OrderAllDto> order=service.seeOrders(orders);
        System.out.println(order);
        return order;
    }

}
