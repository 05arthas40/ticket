package com.backGroundManager.dto;

public class CompanyInfoDto {

    int cid;
    String cname;
    int status;

    @Override
    public String toString() {
        return "CompanyInfoDto{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", status=" + status +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
