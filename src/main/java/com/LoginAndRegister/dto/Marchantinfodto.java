package com.LoginAndRegister.dto;

import lombok.ToString;

@ToString
public class Marchantinfodto{
    private Integer cid;
    private String cname;
    private String cpassword;
    private String caddress;
    private String cdetails;
    private boolean isLock;
    private boolean status;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCdetails() {
        return cdetails;
    }

    public void setCdetails(String cdetails) {
        this.cdetails = cdetails;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
