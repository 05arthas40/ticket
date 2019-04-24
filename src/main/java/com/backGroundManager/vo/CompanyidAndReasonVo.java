package com.backGroundManager.vo;

public class CompanyidAndReasonVo {

    int cid;
    String reason;

    @Override
    public String toString() {
        return "CompanyidAndReasonVo{" +
                "cid=" + cid +
                ", reason='" + reason + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
