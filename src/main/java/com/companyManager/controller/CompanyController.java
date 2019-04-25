package com.companyManager.controller;

import com.companyManager.dto.CompanyDto;
import com.companyManager.pojo.Company;
import com.companyManager.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    //获取公司基础信息（公司名称，公司地址
    @RequestMapping(value = "getCompanyBaseInfoById", method = RequestMethod.POST)
    public CompanyDto getCompanyInfoById(HttpSession session, HttpServletResponse response) {
        //从session中获取商家信息
        Company company = (Company) session.getAttribute("marchantLogin");
        //得到商家id设置cookie
        Integer id = company.getId();
        Cookie cookie = new Cookie("companyId",id.toString());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);

        return companyService.getCompanyInfoById(id);
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

