package com.orderManager.dao;


import com.orderManager.dto.FlowsDto;
import com.orderManager.dto.OrderAllDto;
import com.orderManager.dto.OrderDto;
import com.orderManager.dto.UserAdressDto;
import com.orderManager.vo.*;

import java.util.List;

public interface OrderDao {
    List<UserAdressDto> getAddresses(int userid);
    int setUnDefault(int userid);

    int editAddress(UserAdressDto dto);

    int addAddress(UserAdressDto dto);

    UserAdressDto getAddressByUaid(int uaid);

    int delAddresses(int uaid);

    int addOrder(OrderVo orderVo);

    int getOrderid(String ordertime, String uaphone);

    int addOrderDetail(OrderDetailVo detailVo);

    List<OrderAllDto> seeOrders(SeeOrders orders);

    List<OrderDto> getOrderByOrderId(int orderid);

    int getFlowByTrade_no(String trade_no);

    Object getFlowByOrderid(int orderid);

    int addFlow(FlowsVo flowsVo);

    int updateFlow(FlowsVo flowsVo);

    List<FlowsDto> getFlows();

    int setSuccess(int orderid);

    int addCount(int seatCount,int svid);
    int reduceCount(int seatCount,int svid);

    int timeOutCancelOrder(int orderid);
}
