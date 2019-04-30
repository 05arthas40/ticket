package com.orderManager.dto;

import java.util.Date;

public class ShowDetails {
    String ppicture;
    String cityname;
    String showtitle;
    String showdate;
    String begin;
    String end;
    String saddress;
    String vname;
    Integer svid;
    String showprice;
    Integer seatCount;
    String pname;
    String pdecription;
    Integer cid;

    public ShowDetails(String ppicture, String cityname, String showtitle, String showdate, String begin, String end, String saddress, String vname, Integer svid, String showprice, Integer seatCount, String pname, String pdecription, Integer cid) {
        this.ppicture = ppicture;
        this.cityname = cityname;
        this.showtitle = showtitle;
        this.showdate = showdate;
        this.begin = begin;
        this.end = end;
        this.saddress = saddress;
        this.vname = vname;
        this.svid = svid;
        this.showprice = showprice;
        this.seatCount = seatCount;
        this.pname = pname;
        this.pdecription = pdecription;
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ShowDetails() {
    }



    public String getPpicture() {
        return ppicture;
    }

    public void setPpicture(String ppicture) {
        this.ppicture = ppicture;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getShowtitle() {
        return showtitle;
    }

    public void setShowtitle(String showtitle) {
        this.showtitle = showtitle;
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

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public Integer getSvid() {
        return svid;
    }

    public void setSvid(Integer svid) {
        this.svid = svid;
    }

    public String getShowprice() {
        return showprice;
    }

    public void setShowprice(String showprice) {
        this.showprice = showprice;
    }

    public String getPdecription() {
        return pdecription;
    }

    public void setPdecription(String pdecription) {
        this.pdecription = pdecription;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCdecription() {
        return pdecription;
    }

    public void setCdecription(String pdecription) {
        this.pdecription = pdecription;
    }

    @Override
    public String toString() {
        return "ShowDetails{" +
                "ppicture='" + ppicture + '\'' +
                ", cityname='" + cityname + '\'' +
                ", showtitle='" + showtitle + '\'' +
                ", showdate='" + showdate + '\'' +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", saddress='" + saddress + '\'' +
                ", vname='" + vname + '\'' +
                ", svid=" + svid +
                ", showprice=" + showprice +
                ", seatCount=" + seatCount +
                ", pname='" + pname + '\'' +
                ", pdecription='" + pdecription + '\'' +
                ", cid=" + cid +
                '}';
    }
}
