package com.userManager.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class UserEmailVo {
    String checkCode;
    String email;
    int userid;
}
