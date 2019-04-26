package com.showManager.dto;

public class ShowHomeDto {
    private Integer showid;
    private String showdate;
    private String begin;
    private String vname;
    private String showprice;
    private String showtitle;
    private String ppicture;
    private String ptype;

    public Integer getShowid() {
        return showid;
    }

    public void setShowid(Integer showid) {
        this.showid = showid;
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

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getShowprice() {
        return showprice;
    }

    public void setShowprice(String showprice) {
        this.showprice = showprice;
    }

    public String getShowtitle() {
        return showtitle;
    }

    public void setShowtitle(String showtitle) {
        this.showtitle = showtitle;
    }

    public String getPpicture() {
        return ppicture;
    }

    public void setPpicture(String ppicture) {
        this.ppicture = ppicture;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    @Override
    public String toString() {
        return "ShowHomeDto{" +
                "showid=" + showid +
                ", showdate='" + showdate + '\'' +
                ", begin='" + begin + '\'' +
                ", vname='" + vname + '\'' +
                ", showprice=" + showprice +
                ", showtitle='" + showtitle + '\'' +
                ", ppicture='" + ppicture + '\'' +
                ", ptype='" + ptype + '\'' +
                '}';
    }
}
