package com.LoginAndRegister.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Userinfo {
    private Integer userid;
    private String username;
    private String password;
    private String phone;
    private String  name;
    private String  email;
    private Character idc;
    boolean isLock;
    boolean status;
}
