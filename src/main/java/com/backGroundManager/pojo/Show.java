package com.backGroundManager.pojo;

public class Show {


    int pfmid;
    String showtitle;
    String pname;
    String pdecription;
    String ppicture;
    String ptype;
    int status;

    @Override
    public String toString() {
        return "Show{" +
                "pfmid=" + pfmid +
                ", showtitle='" + showtitle + '\'' +
                ", pname='" + pname + '\'' +
                ", pdecription='" + pdecription + '\'' +
                ", ppicture='" + ppicture + '\'' +
                ", ptype='" + ptype + '\'' +
                ", status=" + status +
                '}';
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
