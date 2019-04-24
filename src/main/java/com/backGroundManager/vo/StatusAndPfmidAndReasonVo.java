package com.backGroundManager.vo;

public class StatusAndPfmidAndReasonVo {

    int pfmid;
    int status;
    String reason;

    @Override
    public String toString() {
        return "StatusAndPfmidAndReasonVo{" +
                "pfmid=" + pfmid +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                '}';
    }

    public int getPfmid() {
        return pfmid;
    }

    public void setPfmid(int pfmid) {
        this.pfmid = pfmid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
