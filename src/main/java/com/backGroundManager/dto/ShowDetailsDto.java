package com.backGroundManager.dto;

public class ShowDetailsDto {

    int pfmid;
    String showtitle;
    String ptype;
    int status;
    String cname;

    public int getPfmid() {
        return pfmid;
    }

    public void setPfmid(int pfmid) {
        this.pfmid = pfmid;
    }

    public String getShowtitle() {
        return showtitle;
    }

    public void setShowtitle(String showtitle) {
        this.showtitle = showtitle;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "ShowDetailsDto{" +
                "pfmid=" + pfmid +
                ", showtitle='" + showtitle + '\'' +
                ", ptype='" + ptype + '\'' +
                ", status=" + status +
                ", cname='" + cname + '\'' +
                '}';
    }
}
