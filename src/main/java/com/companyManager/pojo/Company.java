package com.companyManager.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Company {
    int Id;
    String name;
    String password;
    String address;
    String details;
    String phone;
    byte islock;
    byte status;
}
