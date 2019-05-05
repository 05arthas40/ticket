package com.orderManager.vo;

public class FlowsVo {
    private int fid;
    private int orderid;
    private String creattime;
    private String paytime;
    private String paytitle;
    private String tradestatus;
    private String trade_no;

    public FlowsVo(int fid, int orderid, String creattime, String paytime, String paytitle, String tradestatus, String trade_no) {
        this.fid = fid;
        this.orderid = orderid;
        this.creattime = creattime;
        this.paytime = paytime;
        this.paytitle = paytitle;
        this.tradestatus = tradestatus;
        this.trade_no = trade_no;
    }

    public FlowsVo(int orderid, String creattime, String paytime, String paytitle, String tradestatus, String trade_no) {
        this.orderid = orderid;
        this.creattime = creattime;
        this.paytime = paytime;
        this.paytitle = paytitle;
        this.tradestatus = tradestatus;
        this.trade_no = trade_no;
    }

    public FlowsVo() {
    }

    @Override
    public String toString() {
        return "FlowsVo{" +
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
