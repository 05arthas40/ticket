package com.companyManager.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class CompanyDto {
    int id;
    String name;
    String address;
    String details;
}
