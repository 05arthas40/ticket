package com.companyManager.pojo;

import lombok.Data;
import lombok.ToString;

@ToString
public class Performance {
    int performanceId;
    String showTitle;
    String perfromerName;
    String decription;
    String picturePath;
    String perfromType;
    int pstatus;

    public int getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getPerfromerName() {
        return perfromerName;
    }

    public void setPerfromerName(String perfromerName) {
        this.perfromerName = perfromerName;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getPerfromType() {
        return perfromType;
    }

    public void setPerfromType(String perfromType) {
        this.perfromType = perfromType;
    }

    public int getPstatus() {
        return pstatus;
    }

    public void setPstatus(int pstatus) {
        this.pstatus = pstatus;
    }
}
