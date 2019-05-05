package com.orderManager.service;


import com.orderManager.dto.FlowsDto;
import com.orderManager.dto.OrderAllDto;
import com.orderManager.dto.OrderDto;
import com.orderManager.dto.UserAdressDto;
import com.orderManager.vo.*;

import javax.management.ObjectName;
import java.util.List;

public interface OrderService {
    List<UserAdressDto> getAddresses(int userid);

    int editAddress(UserAdressDto dto);

    int addAddress(UserAdressDto dto);

    UserAdressDto getAddressByUaid(int uaid);

    boolean delAddresses(int uaid);

    int submitOrder(OrderAllVo vo, String path, String hostpath);

    List<OrderAllDto> seeOrders(SeeOrders orders);

    OrderDto getOrderByOrderId(int orderid);

    int getFlowByTrade_no(String trade_no);

    Object getFlowByOrderid(int orderid);

    int addFlow(FlowsVo flowsVo);

    int updateFlow(FlowsVo flowsVo);

    List<FlowsDto> getFlows();

    int setSuccess(int orderid);
    /*int reduceCount(int seatCount,int svid);*/

}
