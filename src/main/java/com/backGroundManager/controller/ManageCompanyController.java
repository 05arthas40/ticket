package com.backGroundManager.controller;

import com.backGroundManager.dto.ShowDetailsDto;
import com.backGroundManager.service.impl.ManageCompanyServiceImpl;
import com.backGroundManager.vo.CompanyidAndReasonVo;
import com.backGroundManager.vo.CompanyidAndStatusVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManageCompanyController {

    @Autowired
    ManageCompanyServiceImpl manageCompanyService;

    @RequestMapping(value = "getCheckCompany",method = RequestMethod.POST)
    public Object getCheckCompany(@RequestParam int status){
        return manageCompanyService.getCheckCompany(status);

    }

    @RequestMapping(value = "filtrateCompany",method = RequestMethod.POST)
    public Object filtrateCompany(@RequestBody CompanyidAndStatusVo companyidAndStatusVo,Integer current){
        PageHelper.startPage(current,3);
        List<ShowDetailsDto> list  = manageCompanyService.filtrateCompany(companyidAndStatusVo);
        PageInfo<ShowDetailsDto> detailsDtoPageInfo = new PageInfo<ShowDetailsDto>(list);
        return detailsDtoPageInfo;
    }

    @RequestMapping(value = "getCname",method = RequestMethod.POST)
    public Object getCname(){
        return manageCompanyService.getCname();
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
