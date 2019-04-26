package com.orderManager.service;

import com.orderManager.dto.OrderDto;

import java.util.List;

public interface AlipayService {
    public String getwayPay(OrderDto orderDto);
}