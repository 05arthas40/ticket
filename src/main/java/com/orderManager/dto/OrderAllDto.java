package com.orderManager.dto;

public class OrderAllDto {
    private int odid;
    private int orderid;
    private int svid;
    private int userid;
    private int cid;
    private int ticketcount;
    private String price;
    private String singleprice;
    private String ordertime;
    private String expfee;
    private double discount=1.00;
    private String  totalprice;
    private int status;
    private String uaname;
    private String uaphone;
    private String  uaddress;

    public String getSingleprice() {
        return singleprice;
    }

    public void setSingleprice(String singleprice) {
        this.singleprice = singleprice;
    }

    @Override
    public String toString() {
        return "OrderAllVo{" +
                "odid=" + odid +
                ", orderid=" + orderid +
                ", svid=" + svid +
                ", ticketcount=" + ticketcount +
                ", price='" + price + '\'' +
                ", singleprice='" + singleprice + '\'' +
                ", userid=" + userid +
                ", cid=" + cid +
                ", ordertime='" + ordertime + '\'' +
                ", expfee='" + expfee + '\'' +
                ", discount=" + discount +
                ", totalprice='" + totalprice + '\'' +
                ", status=" + status +
                ", uaname='" + uaname + '\'' +
                ", uaphone='" + uaphone + '\'' +
                ", uaddress='" + uaddress + '\'' +
                '}';
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
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

    public int getOdid() {
        return odid;
    }

    public void setOdid(int odid) {
        this.odid = odid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getSvid() {
        return svid;
    }

    public void setSvid(int svid) {
        this.svid = svid;
    }

    public int getTicketcount() {
        return ticketcount;
    }

    public void setTicketcount(int ticketcount) {
        this.ticketcount = ticketcount;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
