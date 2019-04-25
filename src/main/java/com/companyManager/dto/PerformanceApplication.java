package com.companyManager.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 演出申请
 * 演出粗略信息
 */
@Data
public class PerformanceApplication {
    int performanceId;
    String showTitle;
    String perfromerName;
    int pstatus;


}
