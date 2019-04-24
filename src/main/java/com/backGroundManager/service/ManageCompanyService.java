package com.backGroundManager.service;

import com.backGroundManager.dto.CompanyDetailsDto;
import com.backGroundManager.dto.CompanyInfoDto;
import com.backGroundManager.vo.CompanyidAndReasonVo;
import com.backGroundManager.vo.CompanyidAndStatusVo;

import java.util.List;

public interface ManageCompanyService {

    public List<CompanyInfoDto> getCheckCompany(int status);
    public List<CompanyDetailsDto> getCompanyById(int pfmid);

    public int alterCompanyById(CompanyidAndStatusVo companyidAndStatusVo);
    public int rejectCompanyById(CompanyidAndReasonVo companyidAndReasonVo);
}
