package com.userManager.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class UserAddress {
    int uaid;
    String uaname;
    String uaphone;
    String uaddress;
    int isDefault;
}
