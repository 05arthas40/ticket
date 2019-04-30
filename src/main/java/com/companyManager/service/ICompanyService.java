package com.companyManager.service;

import com.companyManager.dto.CompanyDto;

import java.util.Map;

public interface ICompanyService {
    public CompanyDto getCompanyInfoById(int id);

    public boolean toModiyCompanyBaseInfo(CompanyDto companyDto);

    public boolean toModiyCompanyPrivateInfo(Map<String,Object> map);
}
