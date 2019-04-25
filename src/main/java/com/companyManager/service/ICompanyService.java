package com.companyManager.service;

import com.companyManager.dto.CompanyDto;

public interface ICompanyService {
    public CompanyDto getCompanyInfoById(int id);

    public boolean toModiyCompanyBaseInfo(CompanyDto companyDto);
}
