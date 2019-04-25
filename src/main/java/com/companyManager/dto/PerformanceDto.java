package com.companyManager.dto;

import lombok.Data;
import lombok.ToString;

@ToString
public class PerformanceDto {
    String showTitle;
    String perfromerName;
    String decription;
    String picturePath;
    String perfromType;

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
}
