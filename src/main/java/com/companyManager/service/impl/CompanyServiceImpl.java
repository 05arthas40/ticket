package com.companyManager.service.impl;

import com.companyManager.dto.CompanyDto;
import com.companyManager.dao.CompanyDao;
import com.companyManager.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    CompanyDao companyDao;

    public CompanyDto getCompanyInfoById(int id) {
        return companyDao.getCompanyInfoById(id);
    }

    public boolean toModiyCompanyBaseInfo(CompanyDto companyDto) {
        if (companyDao.toModiyCompanyBaseInfo(companyDto) > 0){
            return true;
        }
        return false;
    }
}
