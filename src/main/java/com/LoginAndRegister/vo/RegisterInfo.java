package com.LoginAndRegister.vo;

import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@ToString
public class RegisterInfo{
    @NotBlank(message = "必填")
    @Length(min = 8,max = 11,message = "用户名不符合长度")
    private String regist_account;

    @NotBlank(message = "必填")
    @Length(min = 6,max = 16,message = "密码不符合长度")
    private String regist_password2;

    @NotBlank(message = "必填")
    @Length(min = 11,max = 11,message = "手机号码不符合长度")
    private String regist_phone;

    @NotBlank(message = "必填")
    @Length(min = 6,max = 6,message = "验证码不符合长度")
    private String regist_vcode;

    public String getRegist_account() {
        return regist_account;
    }

    public void setRegist_account(String regist_account) {
        this.regist_account = regist_account;
    }

    public String getRegist_password2() {
        return regist_password2;
    }

    public void setRegist_password2(String regist_password2) {
        this.regist_password2 = regist_password2;
    }

    public String getRegist_phone() {
        return regist_phone;
    }

    public void setRegist_phone(String regist_phone) {
        this.regist_phone = regist_phone;
    }

    public String getRegist_vcode() {
        return regist_vcode;
    }

    public void setRegist_vcode(String regist_vcode) {
        this.regist_vcode = regist_vcode;
    }
}
