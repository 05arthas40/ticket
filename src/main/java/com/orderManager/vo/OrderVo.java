package com.orderManager.vo;

public class OrderVo {
    private int orderid;
    private int userid;
    private int cid;
    private String ordertime;
    private String expfee;
    private double discount=1.00;
    private String  totalprice;
    private String uaname;
    private String uaphone;
    private String  uaddress;
    private int status;

    @Override
    public String toString() {
        return "OrderVo{" +
                "orderid=" + orderid +
                ", userid=" + userid +
                ", cid=" + cid +
                ", ordertime='" + ordertime + '\'' +
                ", expfee='" + expfee + '\'' +
                ", discount=" + discount +
                ", totalprice='" + totalprice + '\'' +
                ", uaname='" + uaname + '\'' +
                ", uaphone='" + uaphone + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", status=" + status +
                '}';
    }

    public String getUaname() {
        return uaname;
    }

    public void setUaname(String uaname) {
        this.uaname = uaname;
    }

    public String getUaphone() {
        return uaphone;
    }

    public void setUaphone(String uaphone) {
        this.uaphone = uaphone;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }


    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getExpfee() {
        return expfee;
    }

    public void setExpfee(String expfee) {
        this.expfee = expfee;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
