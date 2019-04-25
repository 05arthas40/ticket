package com.companyManager.dao;

import com.companyManager.dto.CompanyDto;

public interface CompanyDao {
    public CompanyDto getCompanyInfoById(int id);

    public int toModiyCompanyBaseInfo(CompanyDto companyDto);


}
