package com.userManager.dto;

import com.userManager.pojo.UserAddress;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter@Getter@ToString
public class UserAddressDto {

   List<UserAddress> userAddressList;
}
