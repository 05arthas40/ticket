package com.companyManager.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 演出申请
 * 演出粗略信息
 */
@ToString
public class PerformanceApplication {
    int performanceId;
    String showTitle;
    String perfromerName;
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

    public int getPstatus() {
        return pstatus;
    }

    public void setPstatus(int pstatus) {
        this.pstatus = pstatus;
    }
}
