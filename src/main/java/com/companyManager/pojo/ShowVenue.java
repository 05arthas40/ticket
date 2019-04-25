package com.companyManager.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class ShowVenue {
    int showId;
    int seatType;
    int seatCount;
    int seatPrice;
}
