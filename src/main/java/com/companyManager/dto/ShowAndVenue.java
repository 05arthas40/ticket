package com.companyManager.dto;

import com.companyManager.pojo.ShowVenue;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class ShowAndVenue {
    int showId;
    int performanceId;
    String showTime;
    String begin;
    String end;
    String vname;
    String address;
    List<ShowVenue> venues;

}
