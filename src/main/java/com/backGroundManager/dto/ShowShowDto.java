package com.backGroundManager.dto;

public class ShowShowDto {

    String showdate;
    String begin;
    String end;
    String vname;
    String saddress;
    int showid;
    int status;

    @Override
    public String toString() {
        return "ShowShowDto{" +
                "showdate='" + showdate + '\'' +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", vname='" + vname + '\'' +
                ", saddress='" + saddress + '\'' +
                ", showid=" + showid +
                ", status=" + status +
                '}';
    }

    public String getShowdate() {
        return showdate;
    }

    public void setShowdate(String showdate) {
        this.showdate = showdate;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }
}
