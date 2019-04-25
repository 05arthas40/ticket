package com.companyManager.dto;

import com.companyManager.pojo.ShowVenue;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@ToString
public class ShowAndVenue {
    int showId;
    int performanceId;
    String showTime;
    String begin;
    String end;
    String vname;
    String address;
    List<ShowVenue> venues;

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(int performanceId) {
        this.performanceId = performanceId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
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

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ShowVenue> getVenues() {
        return venues;
    }

    public void setVenues(List<ShowVenue> venues) {
        this.venues = venues;
    }
}
