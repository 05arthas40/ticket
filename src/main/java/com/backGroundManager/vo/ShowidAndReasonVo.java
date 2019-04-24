package com.backGroundManager.vo;

public class ShowidAndReasonVo {

    int showid;
    String reason;


    @Override
    public String toString() {
        return "ShowidAndReasonVo{" +
                "showid=" + showid +
                ", reason='" + reason + '\'' +
                '}';
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
