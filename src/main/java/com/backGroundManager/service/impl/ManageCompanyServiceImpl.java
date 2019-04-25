package com.backGroundManager.service.impl;

import com.backGroundManager.dao.ManageCompanyDao;
import com.backGroundManager.dto.CnameDto;
import com.backGroundManager.dto.CompanyDetailsDto;
import com.backGroundManager.dto.CompanyInfoDto;
import com.backGroundManager.dto.ShowDetailsDto;
import com.backGroundManager.service.ManageCompanyService;
import com.backGroundManager.vo.CompanyidAndReasonVo;
import com.backGroundManager.vo.CompanyidAndStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageCompanyServiceImpl implements ManageCompanyService {

    @Autowired
    ManageCompanyDao manageCompanyDao;

    public List<CompanyInfoDto> getCheckCompany(int status) {
        return manageCompanyDao.getCheckCompany(status);
    }

    public List<CompanyDetailsDto> getCompanyById(int pfmid) {
        return manageCompanyDao.getCompanyById(pfmid);
    }


    public List<CnameDto> getCname() {
        return manageCompanyDao.getCname();
    }

    public List<ShowDetailsDto> filtrateCompany(CompanyidAndStatusVo companyidAndStatusVo) {
        return manageCompanyDao.filtrateCompany(companyidAndStatusVo);
    }

    public int alterCompanyById(CompanyidAndStatusVo companyidAndStatusVo) {
        return manageCompanyDao.alterCompanyById(companyidAndStatusVo);
    }

    public int rejectCompanyById(CompanyidAndReasonVo companyidAndReasonVo) {
        return manageCompanyDao.rejectCompanyById(companyidAndReasonVo);
    }


}
