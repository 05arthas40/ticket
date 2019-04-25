package com.userManager.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class UserInfoVo {
    int userid;
    String nickname;
    int gender;
    String newPassword;
}
