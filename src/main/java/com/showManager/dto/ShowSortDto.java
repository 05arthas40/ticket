package com.showManager.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowSortDto {
    int showid;
    String  showdate;
    String begin;
    String vname;
    String cityname;
    Double showprice;
    String showtitle;
    String pname;
    String ppicture;
    String ptype;

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public String getShowdate() {
        return showdate;
    }

    public void setShowdate(Date showdate) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        this.showdate = ft.format(showdate);
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

    public Double getShowprice() {
        return showprice;
    }

    public void setShowprice(Double showprice) {
        this.showprice = showprice;
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

    public void setShowdate(String showdate) {
        this.showdate = showdate;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Override
    public String toString() {
        return "ShowInfoVo{" +
                "showid=" + showid +
                ", showdate='" + showdate + '\'' +
                ", begin='" + begin + '\'' +
                ", vname='" + vname + '\'' +
                ", cityname='" + cityname + '\'' +
                ", showprice=" + showprice +
                ", showtitle='" + showtitle + '\'' +
                ", pname='" + pname + '\'' +
                ", ppicture='" + ppicture + '\'' +
                ", ptype='" + ptype + '\'' +
                '}';
    }
}
