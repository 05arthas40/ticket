package com.userManager.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class UserInfoDto {
    int userid;
    String nickname;
    int gender;
    String phone;
    String name;
    String email;
    String idc;
}
