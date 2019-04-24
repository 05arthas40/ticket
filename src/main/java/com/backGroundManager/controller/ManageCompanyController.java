package com.backGroundManager.controller;

import com.backGroundManager.service.impl.ManageCompanyServiceImpl;
import com.backGroundManager.vo.CompanyidAndReasonVo;
import com.backGroundManager.vo.CompanyidAndStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManageCompanyController {

    @Autowired
    ManageCompanyServiceImpl manageCompanyService;

    @RequestMapping(value = "getCheckCompany",method = RequestMethod.POST)
    public Object getCheckCompany(@RequestParam int status){
        return manageCompanyService.getCheckCompany(status);

    }

    @RequestMapping(value = "getCompanyById",method = RequestMethod.POST)
    public Object getCompanyById(@RequestParam int pfmid){
        return manageCompanyService.getCompanyById(pfmid);
    }

    @RequestMapping(value = "alterCompanyById",method = RequestMethod.POST)
    public int alterCompanyById(@RequestBody CompanyidAndStatusVo companyidAndStatusVo){
        return manageCompanyService.alterCompanyById(companyidAndStatusVo);
    }

    @RequestMapping(value = "rejectCompanyById",method = RequestMethod.POST)
    public int rejectCompanyById(@RequestBody CompanyidAndReasonVo companyidAndReasonVo){
        return manageCompanyService.rejectCompanyById(companyidAndReasonVo);
    }
}
