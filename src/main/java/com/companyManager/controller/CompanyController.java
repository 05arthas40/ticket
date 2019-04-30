package com.companyManager.controller;

import com.LoginAndRegister.dto.Marchantinfodto;
import com.companyManager.dto.CompanyDto;
import com.companyManager.pojo.Company;
import com.companyManager.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
public class CompanyController {

    @Autowired
    ICompanyService companyService;

    //获取公司基础信息（公司名称，公司地址
    @RequestMapping(value = "getCompanyBaseInfoById", method = RequestMethod.POST)
    public CompanyDto getCompanyInfoById(HttpSession session, HttpServletResponse response) {
        //从session中获取商家信息
        Marchantinfodto company =(Marchantinfodto)session.getAttribute("marchantlogin");
//        得到商家id设置cookie
        Integer id = company.getCid();
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

    //公司资料文件更新
    @RequestMapping(value = "updateCompanyInfo",method = RequestMethod.POST)
    public String companyInfoUpdate(HttpServletRequest request, @RequestParam(value = "infoImgs",required = false) MultipartFile[] uploadFiles) {
        Boolean flag = false;
        String UPLOAD_PATH = "/static/upload/";
        //图片路径拼接存储
        StringBuilder pathStr = new StringBuilder();
        for (int i = 0 ; i < uploadFiles.length; i++) {
            // 获取文件后缀
            String fileName = uploadFiles[i].getOriginalFilename();
            String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

            // 文件存放路径
            String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

            InetAddress ia = null;
            try {
                //得到项目ip地址
                ia = ia.getLocalHost();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 判断路径是否存在，不存在则创建文件夹
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }

            // 将文件写入目标
            file = new File(filePath, UUID.randomUUID() + fileSuffix);
            try {
                uploadFiles[i].transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
            String infoImgPath = serverPath + file.getName();
            //拼接图片路径
            if ((i + 1) == uploadFiles.length) {
                pathStr.append(infoImgPath);//不止一张的最后一张图片，有且只有一张
            }else {
                pathStr.append(infoImgPath).append(";");//不止一张图片
            }
        }
        int companyId = Integer.parseInt(request.getParameter("companyId")) ;

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("companyId",companyId);
        map.put("details",String.valueOf(pathStr));

        flag = companyService.toModiyCompanyPrivateInfo(map);
        return flag.toString();
    }
}

