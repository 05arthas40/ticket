package com.backGroundManager.vo;

public class StatusAndPfmidVo {
    int number;
    int pfmid;

    @Override
    public String toString() {
        return "StatusAndPfmidVo{" +
                "number=" + number +
                ", pfmid=" + pfmid +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPfmid() {
        return pfmid;
    }

    public void setPfmid(int pfmid) {
        this.pfmid = pfmid;
    }
}
