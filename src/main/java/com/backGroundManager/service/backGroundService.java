package com.backGroundManager.service;

import com.backGroundManager.pojo.user;
import com.backGroundManager.vo.userVo;

import java.util.List;

public interface backGroundService {

    public boolean updateUserById(user user);

    public boolean deleteUserById(user user);

    List<user> listUserInfo(userVo userVo);

    List<user> listUserInfo(user user);
}
