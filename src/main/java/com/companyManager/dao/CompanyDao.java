package com.companyManager.dao;

import com.companyManager.dto.CompanyDto;

import java.util.Map;

public interface CompanyDao {
    public CompanyDto getCompanyInfoById(int id);

    public int toModiyCompanyBaseInfo(CompanyDto companyDto);

    public int toModiyCompanyPrivateInfo(Map<String,Object> map);

}
