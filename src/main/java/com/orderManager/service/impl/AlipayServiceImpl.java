package com.orderManager.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;

import com.alipay.api.response.AlipayTradePagePayResponse;
import com.orderManager.configrations.AlipayProperties;
import com.orderManager.dto.OrderDto;
import com.orderManager.service.AlipayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class AlipayServiceImpl implements AlipayService {

    @Resource
    private AlipayClient alipayClient;

    @Resource
    private AlipayProperties aliPayProperties;


    public String getwayPay(OrderDto orderDto) {
        String totalprice = orderDto.getTotalprice();
        String productCode = "FAST_INSTANT_TRADE_PAY";
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(UUID.randomUUID().toString());
        model.setSubject("项目测试");
        model.setTotalAmount(totalprice);
        model.setBody("项目测试，共"+totalprice+"元");
        model.setProductCode(productCode);

        AlipayTradePagePayRequest pagePayRequest = new AlipayTradePagePayRequest();
        pagePayRequest.setReturnUrl(aliPayProperties.getReturnUrl()+"?orderid="+orderDto.getOrderid());
        pagePayRequest.setNotifyUrl(aliPayProperties.getNotifyUrl()+"?orderid="+orderDto.getOrderid());
        pagePayRequest.setBizModel(model);

        // 调用SDK生成表单, 并直接将完整的表单html输出到页面
        String retStr = null;
        try {
            AlipayTradePagePayResponse response = alipayClient.pageExecute(pagePayRequest);
            System.out.println("response:"+response);
            retStr = response.getBody();
            System.out.println("retStr:"+retStr);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return retStr;
    }
}