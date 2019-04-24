package com.orderManager.service;



import com.orderManager.dto.OrderAllDto;
import com.orderManager.dto.UserAdressDto;
import com.orderManager.vo.OrderAllVo;
import com.orderManager.vo.OrderDetailVo;
import com.orderManager.vo.OrderVo;
import com.orderManager.vo.SeeOrders;

import java.util.List;

public interface OrderService {
    List<UserAdressDto> getAddresses(int userid);

    int editAddress(UserAdressDto dto);

    int addAddress(UserAdressDto dto);

    UserAdressDto getAddressByUaid(int uaid);

    boolean delAddresses(int uaid);

    OrderDetailVo getOrderDetailVo(OrderAllVo vo);

    OrderVo getOrderVo(OrderAllVo vo);

    boolean submitOrder(OrderDetailVo detailVo, OrderAllVo vo);

    int getOrderIdAfterAdd(OrderVo orderVo);

    void delOrder(int orderid);

    List<OrderAllDto> seeOrders(SeeOrders orders);
}
