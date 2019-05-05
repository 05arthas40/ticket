package com.orderManager.vo;

public class ShortCutVo {
    private int scid;
    private int svid;
    private int orderid;
    private int ticketcount;
    private String singleprice;
    private String price;

    public int getTicketcount() {
        return ticketcount;
    }

    public void setTicketcount(int ticketcount) {
        this.ticketcount = ticketcount;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }


    public void setPrice(String price) {
        this.price = price;
    }

    public int getSvid() {
        return svid;
    }

    public void setSvid(int svid) {
        this.svid = svid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "ShortCutVo{" +
                "scid=" + scid +
                ", svid=" + svid +
                ", orderid=" + orderid +
                ", ticketcount=" + ticketcount +
                ", singleprice='" + singleprice + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getSingleprice() {
        return singleprice;
    }

    public void setSingleprice(String singleprice) {
        this.singleprice = singleprice;
    }

    public String getPrice() {
        return price;
    }
}


