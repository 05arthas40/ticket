package com.companyManager.controller;

import com.companyManager.dto.PerformanceApplication;
import com.companyManager.dto.ShowAndVenue;
import com.companyManager.dto.ShowApplication;
import com.companyManager.dto.VenueDto;
import com.companyManager.pojo.Performance;
import com.companyManager.pojo.ShowVenue;
import com.companyManager.service.IPerformanceService;
import com.companyManager.service.impl.PerformanceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@RestController
public class PerformanceController {

    @Autowired
    IPerformanceService performanceService;

    /**
     * 获取公司旗下的所有演出
     * @param companyId
     * @return
     */
    @RequestMapping(value = "getAllPerformance",method = RequestMethod.POST)
    public List<PerformanceApplication> getAllPerformance(@RequestParam int companyId) {
        List<PerformanceApplication> list= performanceService.getAllPerforman(companyId);
        System.out.println(list);
        return list;
    }

    /**
     * 获取演出的详细信息
     * @param performanceId
     * @return
     */
    @RequestMapping(value = "getPerformanceByPerformanceId",method = RequestMethod.POST)
    public List<Performance> getPerformanceById(@RequestParam int performanceId){
        return performanceService.getPerformanceById(performanceId);
    }

    //得到演出下的所有演唱会
    @RequestMapping(value = "getAllShowInfoByPerformanceId",method = RequestMethod.POST)
    public List<ShowApplication> getAllShowInfo(@RequestParam int performanceId) {
        return performanceService.getAllShowInfo(performanceId);
    }

    /*查看演唱会场地信息*/
    @RequestMapping(value = "getVenueByShowId",method = RequestMethod.POST)
    public List<VenueDto> getVenueByShowId(int showId) {
        return performanceService.getVenueByShowId(showId);
    }

    //富文本图片上传
    static String UPLOAD_PATH = "/static/upload/";
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload1(MultipartFile editorFile, HttpServletRequest request) {

        Map<String, Object> result = new HashMap<String, Object>();

        // 获取文件后缀
        String fileName = editorFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        InetAddress ia = null;
        try {
            //得到项目ip地址
            ia = ia.getLocalHost();
        } catch (UnknownHostException e) {
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
            editorFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
        //打印服务端路径
        /*System.out.println(serverPath);*/
        // 返回给 wangEditor 的数据格式
        result.put("errno", 0);
        result.put("data", new String[]{serverPath + file.getName()});
        return result;
    }

    //新增演唱会时显示所属演出
    @RequestMapping(value = "getPerformanceName",method = RequestMethod.POST )
    public String getPerformanceName(@RequestParam int performanceId) {
        return performanceService.getPerformanceName(performanceId);
    }

    //新增演唱会申请（添加事务）
    @RequestMapping(value = "addShowAndVenue",method = RequestMethod.POST)
    public String addShowAndVenue(@RequestBody ShowAndVenue showAndVenue) {
        Boolean flag = false;
        //得到返回值
        int result1 = performanceService.addshowinfo(showAndVenue);
        List<ShowVenue> venues = showAndVenue.getVenues();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("showId",showAndVenue.getShowId());
        map.put("venues",showAndVenue.getVenues());

        int result2 = performanceService.addVenueinfos(map);

        if (result1 >0 && result2 > 0) {
            flag = true;
        }else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag.toString();
    }

    @RequestMapping(value = "addPerformance",method = RequestMethod.POST)
    public String addperformance(HttpServletRequest request,@RequestParam(value = "posterImg",required = false) MultipartFile uploadFile) {
        Boolean flag = false;
        Map<String, Object> map = new HashMap<String, Object>();

        // 获取文件后缀
        String fileName = uploadFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);

        InetAddress ia = null;
        try {
            //得到项目ip地址
            ia = ia.getLocalHost();
        } catch (UnknownHostException e) {
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
            uploadFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);

        //得到前端传递的数据
        int cid = Integer.parseInt(request.getParameter("cid"));
        String showTitle = request.getParameter("showTitle");
        String performer = request.getParameter("performer");
        String img = serverPath + file.getName();
        String decription = request.getParameter("decription");


        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-entity.xml");
        Performance performance = ac.getBean(Performance.class);
        performance.setShowTitle(showTitle);
        performance.setPerfromerName(performer);
        performance.setPicturePath(img);
        performance.setDecription(decription);
        performance.setPerfromType("show");

        int result1 = performanceService.addPerformance(performance);
        Map<String,Integer> map1 = new HashMap<String, Integer>();
        map1.put("cid",cid);
        map1.put("pid",performance.getPerformanceId());

        int result2 = performanceService.addCompanyShow(map1);

        if (result1 > 0 && result2 > 0) {
            flag = true;
        }
        return flag.toString();
    }
}
