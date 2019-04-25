package com.userManager.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class UserInfo {
    int userid;
    String nickname;
    String password;
    String phone;
    String name;
    String email;
    String idc;
    int gender;
    int status;
}
