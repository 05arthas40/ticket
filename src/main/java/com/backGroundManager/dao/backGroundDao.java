package com.backGroundManager.dao;

import com.backGroundManager.pojo.user;
import com.backGroundManager.vo.userVo;

import java.util.List;

public interface backGroundDao {

    public int updateUserById(user user);

    public int deleteUserById(user user);

    public List<user> listUserInfo(userVo userVo);

    List<user> listUserInfo(user user);
}
