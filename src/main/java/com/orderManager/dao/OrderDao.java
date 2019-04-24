package com.orderManager.dao;


import com.orderManager.dto.OrderAllDto;
import com.orderManager.dto.UserAdressDto;
import com.orderManager.vo.OrderDetailVo;
import com.orderManager.vo.OrderVo;
import com.orderManager.vo.SeeOrders;
import com.orderManager.vo.ShortCutVo;

import java.util.List;

public interface OrderDao {
    List<UserAdressDto> getAddresses(int userid);
    int setUnDefault(int userid);

    int editAddress(UserAdressDto dto);

    int addAddress(UserAdressDto dto);

    UserAdressDto getAddressByUaid(int uaid);

    int delAddresses(int uaid);

    int addOrder(OrderVo orderVo);

    int getOrderid();

    void delOrder(int orderid);

    int addShortCut(ShortCutVo shortCutVo);

    int addOrderDetail(OrderDetailVo detailVo);

    List<OrderAllDto> seeOrders(SeeOrders orders);

}
