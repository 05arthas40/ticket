package com.backGroundManager.dto;

public class CompanyDetailsDto {

    String cname;
    String caddress;
    String cphone;
    String cdetails;
    int status;


    @Override
    public String toString() {
        return "CompanyDetailsDto{" +
                "cname='" + cname + '\'' +
                ", caddress='" + caddress + '\'' +
                ", cphone='" + cphone + '\'' +
                ", cdetails='" + cdetails + '\'' +
                ", status=" + status +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCdetails() {
        return cdetails;
    }

    public void setCdetails(String cdetails) {
        this.cdetails = cdetails;
    }
}
