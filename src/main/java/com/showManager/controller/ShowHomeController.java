package com.showManager.controller;

import com.showManager.dto.ShowHomeDto;
import com.showManager.pojo.UserInfo;
import com.showManager.service.ShowHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ShowHomeController {
    @Autowired
    ShowHomeService showHomeService;

    @RequestMapping(value = "getTypeList",method = RequestMethod.POST)
    public List<ShowHomeDto> TypeList(){
        return showHomeService.getTypeListByDate();
    }

    @RequestMapping(value = "getNickname",method = RequestMethod.POST)
    public Object UserInfo(@RequestBody @Valid HttpSession session){
        UserInfo userinfo = (UserInfo) session.getAttribute("user");
        if (userinfo.getNickname()==null){
            userinfo.setNickname(userinfo.getUsername());
        }
        if (userinfo.getIcon()==null){
            userinfo.setIcon("1.jpg");
        }
        return userinfo;
    }
}
