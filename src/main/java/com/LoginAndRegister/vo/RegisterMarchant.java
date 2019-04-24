package com.LoginAndRegister.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;


@ToString
public class RegisterMarchant implements Serializable {
    @NotBlank(message = "必填")
    private String regist_account;
    @NotBlank(message = "必填")
    private String regist_password1;
    @NotBlank(message = "必填")
    private String regist_address;
    @NotBlank(message = "手机号必填")
    private String regist_phone;
    @NotBlank(message = "必填")
    private String filterHtml;
    public String getRegist_phone() {
        return regist_phone;
    }

    public void setRegist_phone(String regist_phone) {
        this.regist_phone = regist_phone;
    }
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

    public String getRegist_address() {
        return regist_address;
    }

    public void setRegist_address(String regist_address) {
        this.regist_address = regist_address;
    }

    public String getFilterHtml() {
        return filterHtml;
    }

    public void setFilterHtml(String filterHtml) {
        this.filterHtml = filterHtml;
    }
}
