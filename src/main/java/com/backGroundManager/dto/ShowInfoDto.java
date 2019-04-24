package com.backGroundManager.dto;

public class ShowInfoDto {

    String showtitle;
    String cname;
    String pname;
    String ptype;
    String ppicture;
    String pdecription;
    int zhuangtai;

    @Override
    public String toString() {
        return "ShowInfoDto{" +
                "showtitle='" + showtitle + '\'' +
                ", cname='" + cname + '\'' +
                ", pname='" + pname + '\'' +
                ", ptype='" + ptype + '\'' +
                ", ppicture='" + ppicture + '\'' +
                ", pdecription='" + pdecription + '\'' +
                ", zhuangtai=" + zhuangtai +
                '}';
    }

    public String getPpicture() {
        return ppicture;
    }

    public void setPpicture(String ppicture) {
        this.ppicture = ppicture;
    }

    public int getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(int zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    public String getShowtitle() {
        return showtitle;
    }

    public void setShowtitle(String showtitle) {
        this.showtitle = showtitle;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdecription() {
        return pdecription;
    }

    public void setPdecription(String pdecription) {
        this.pdecription = pdecription;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
