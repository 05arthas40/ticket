package com.orderManager.dto;

public class FlowsDto {
    private int fid;
    private int orderid;
    private String creattime;
    private String paytime;
    private String paytitle;
    private String tradestatus;
    private String trade_no;

    @Override
    public String toString() {
        return "FlowsDto{" +
                "fid=" + fid +
                ", orderid=" + orderid +
                ", creattime='" + creattime + '\'' +
                ", paytime='" + paytime + '\'' +
                ", paytitle='" + paytitle + '\'' +
                ", tradestatus='" + tradestatus + '\'' +
                ", trade_no='" + trade_no + '\'' +
                '}';
    }


    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getPaytitle() {
        return paytitle;
    }

    public void setPaytitle(String paytitle) {
        this.paytitle = paytitle;
    }

    public String getTradestatus() {
        return tradestatus;
    }

    public void setTradestatus(String tradestatus) {
        this.tradestatus = tradestatus;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }
}
