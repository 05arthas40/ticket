package com.companyManager.controller;

import com.companyManager.dto.CompanyDto;
import com.companyManager.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    //获取公司基础信息（公司名称，公司地址
    @RequestMapping(value = "getCompanyBaseInfoById", method = RequestMethod.POST)
    public CompanyDto getCompanyInfoById(@RequestParam int companyId) {
        return companyService.getCompanyInfoById(companyId);
    }

    //修改公司基础信息
    @RequestMapping(value = "toModiyCompanyBaseInfo", method = RequestMethod.POST)
    public String toModiyCompanyBaseInfo(@RequestBody(required = false) CompanyDto companyDto) {

        //
        System.out.println(companyDto);

        Boolean flag = false;
        flag = companyService.toModiyCompanyBaseInfo(companyDto);

        return flag.toString();
    }
}

