package com.showManager.controller;

import com.LoginAndRegister.dto.Userdto;
import com.showManager.dto.ShowHomeDto;
import com.showManager.pojo.UserInfo;
import com.showManager.service.ShowHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public Object UserInfo(HttpSession session){
        Userdto userinfo = (Userdto) session.getAttribute("user");

        System.out.println(session.getAttributeNames());
        if (userinfo.getNickname()==null){
            userinfo.setNickname(userinfo.getUsername());
        }
        if (userinfo.getIcon()==null){
            userinfo.setIcon("1.jpg");
        }
        System.out.println(userinfo.toString());
        return userinfo;
    }
    @RequestMapping(value = "ToLogout",method = RequestMethod.POST)
    public Boolean toLogout(HttpSession session, HttpServletResponse response){
        Cookie userid = new Cookie("userid", null);
        Cookie islogin = new Cookie("islogin", null);
        userid.setMaxAge(0);
        userid.setPath("/");
        islogin.setMaxAge(0);
        islogin.setPath("/");
        response.addCookie(userid);
        response.addCookie(islogin);
        session.removeAttribute("user");
        return true;
    }
}
