package com.LoginAndRegister.vo;

import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
@ToString
public class LoginMarchant{
    @NotBlank(message = "必填")
    private String regist_account;
    @NotBlank(message = "必填")
    private String regist_password1;

    public String getRegist_account() {
        return regist_account;
    }

    public void setRegist_account(String regist_account) {
        this.regist_account = regist_account;
    }

    public String getRegist_password1() {
        return regist_password1;
    }

    public void setRegist_password1(String regist_password1) {
        this.regist_password1 = regist_password1;
    }
}
