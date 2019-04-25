package com.companyManager.dto;

import lombok.Data;
import lombok.ToString;

@ToString
public class VenueDto {
    int seatType;
    int seatCount;
    int showprice;

    public int getSeatType() {
        return seatType;
    }

    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getShowprice() {
        return showprice;
    }

    public void setShowprice(int showprice) {
        this.showprice = showprice;
    }
}
