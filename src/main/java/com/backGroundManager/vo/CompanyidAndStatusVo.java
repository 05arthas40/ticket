package com.backGroundManager.vo;

public class CompanyidAndStatusVo {

    int cid;
    int status;

    @Override
    public String toString() {
        return "CompanyidAndStatusVo{" +
                "cid=" + cid +
                ", status=" + status +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
