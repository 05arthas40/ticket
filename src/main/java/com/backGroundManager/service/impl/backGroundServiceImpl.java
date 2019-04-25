package com.backGroundManager.service.impl;

import com.backGroundManager.dao.backGroundDao;
import com.backGroundManager.pojo.user;
import com.backGroundManager.service.backGroundService;
import com.backGroundManager.vo.userVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class backGroundServiceImpl implements backGroundService {

    @Autowired
    backGroundDao backGroundDao;

    public boolean updateUserById(user user) {
        boolean flag = false;
        if (this.backGroundDao.updateUserById(user) > 0) {
            flag = true;
        }
        return flag;
    }

    public boolean deleteUserById(user user) {
        boolean flag = false;
        if (this.backGroundDao.deleteUserById(user) > 0) {
            flag = true;
        }
        return flag;
    }

    public List<user> listUserInfo(userVo userVo) {
        return this.backGroundDao.listUserInfo(userVo);
    }

    @Override
    public List<user> listUserInfo(user user) {
        return this.backGroundDao.listUserInfo(user);
    }
}
