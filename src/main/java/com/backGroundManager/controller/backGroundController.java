package com.backGroundManager.controller;

import com.backGroundManager.pojo.user;
import com.backGroundManager.service.backGroundService;
import com.backGroundManager.vo.userVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class backGroundController {

    @Autowired
    backGroundService backGroundService;

//    条件查询
    @RequestMapping(value = "showUserInfo",method = RequestMethod.POST)
    public Object listUserInfo(@RequestBody(required = false) userVo userVo){
        if (userVo.getPage() == null){
            userVo.setPage(1);
        }
        if (userVo.getStart() == null){
            userVo.setStart(1);
        }
        PageHelper.startPage(userVo.getPage(),3);
        List<user> userList = backGroundService.listUserInfo(userVo);
        PageInfo<user> userPageInfo = new PageInfo<user>(userList);
        System.out.println(userPageInfo);
        return userPageInfo;
    }
//    修改信息
    @RequestMapping(value = "updateUser")
    public Object updateUserById(@RequestBody user user) {
        System.out.println(user);
        if(user.getUserid() == 0){
            return false+"";
        }
        boolean flag = this.backGroundService.updateUserById(user);
        return flag;
    }
//    删除用户(status置0)
    @RequestMapping(value = "deleteUser",method = RequestMethod.POST)
    public Object deleteUserById(@RequestBody user user) {
        System.out.println(user);
        if(user.getUserid() == 0){
            return false+"";
        }
        boolean flag = this.backGroundService.deleteUserById(user);
        return flag;
    }



}
