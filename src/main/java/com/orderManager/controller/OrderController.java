package com.orderManager.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransOrderQueryRequest;
import com.alipay.api.response.AlipayFundTransOrderQueryResponse;
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

        return service.editAddress(dto);
    }

    @RequestMapping(value = "submitOrder", method = RequestMethod.POST)
    public int submitOrder(@RequestBody OrderAllVo vo) {
        System.out.println(vo);
        int orderid = 0;
        try {
            orderid = service.submitOrder(vo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orderid;
    }

    @RequestMapping(value = "seeOrders", method = RequestMethod.GET)
    public Object seeOrders(SeeOrders orders) {
        System.out.println(orders);
        List<OrderAllDto> order = service.seeOrders(orders);
        System.out.println(order);
        return order;
    }

}
