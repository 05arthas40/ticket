package com.companyManager.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 演唱会申请
 * 演唱会详情时间地点场地信息
 */
@Data
public class ShowApplication {
    int showid;
    String showdate;
    String begin;
    String end;
    String vname;
    String saddress;
    int status;
}
