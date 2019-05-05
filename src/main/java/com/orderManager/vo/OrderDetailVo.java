package com.orderManager.vo;

public class OrderDetailVo {
    private int odid;
    private int orderid;
    private int svid;
    private int ticketcount;
    private String shoturl;

    public String getShoturl() {
        return shoturl;
    }

    public void setShoturl(String shoturl) {
        this.shoturl = shoturl;
    }

    @Override
    public String toString() {
        return "OrderDetailVo{" +
                "odid=" + odid +
                ", orderid=" + orderid +
                ", svid=" + svid +
                ", ticketcount=" + ticketcount +
                '}';
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
}
