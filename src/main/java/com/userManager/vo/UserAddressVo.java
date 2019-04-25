package com.userManager.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class UserAddressVo {
    int uaid;
    int userid;
    String uaname;
    String uaphone;
    String uaddress;
    int isDefault;
}
