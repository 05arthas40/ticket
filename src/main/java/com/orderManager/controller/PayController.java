package com.orderManager.controller;

import com.orderManager.dto.OrderDto;
import com.orderManager.service.AlipayService;
import com.orderManager.service.OrderService;
import com.orderManager.vo.FlowsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@RestController
public class PayController {
    @Resource
    AlipayService alipayService;

    @Autowired
    OrderService service;

    @RequestMapping("alipay")
    public void aLiPay(HttpServletRequest request) {
        String tradestatus = request.getParameter("trade_status");
        String trade_no = request.getParameter("trade_no");
        String order = request.getParameter("orderid");
        String creattime = request.getParameter("gmt_create");
        String paytime = request.getParameter("gmt_payment");
        String paytitle = request.getParameter("subject");
        int orderid = Integer.parseInt(order);
        FlowsVo flowsVo = new FlowsVo(orderid, creattime, paytime, paytitle, tradestatus, trade_no);
        int trade_num = service.getFlowByTrade_no(trade_no);
        Object order_num = service.getFlowByOrderid(orderid);//若不为0，即为orderid
        if (trade_num == 0) {
            if ("TRADE_SUCCESS".equals(tradestatus)) {
                if (order_num == null)
                    service.addFlow(flowsVo);
                else
                    service.updateFlow(flowsVo);

                service.setSuccess(orderid);
            }
        }
    }


    @RequestMapping(value = "/orderpay", method = RequestMethod.GET)
    public void orderPay(HttpServletResponse response, HttpServletRequest request) {
        String orderid = request.getParameter("orderid");
        OrderDto order = service.getOrderByOrderId(Integer.parseInt(orderid));
        try {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write(alipayService.getwayPay(order));
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
