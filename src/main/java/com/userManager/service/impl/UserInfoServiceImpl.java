package com.userManager.service.impl;


import com.userManager.dto.UserAddressDto;
import com.userManager.dto.UserInfoDto;
import com.userManager.dao.UserMapper;
import com.userManager.pojo.UserInfo;
import com.userManager.service.UserInfoService;
import com.userManager.vo.UserAddressVo;
import com.userManager.vo.UserEmailVo;
import com.userManager.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
   UserMapper userMapper;
    public UserInfoDto getAllUserInfo(int userid) {
        UserInfoDto allUserInfo = userMapper.getAllUserInfo(userid);
        return allUserInfo;
    }

    public List<UserAddressDto> getUserAddress(UserAddressVo userAddressVo) {
        List<UserAddressDto> userAddress = userMapper.getUserAddress(userAddressVo);
        return userAddress;
    }

    public int updateUserBaseInfo(UserInfoVo userInfoVo) {
        int i = userMapper.updateUserInfo(userInfoVo);
        return i;
    }
    //更新地址
    @Transactional
    public int updateUserAddressTransaction(UserAddressVo userAddressVo) {
        int uaid = userAddressVo.getUaid();
        System.out.println(uaid);
        //更新地址
        int i= userMapper.updateUserAddress(userAddressVo);
        System.out.println("默认地址修改影响行数:"+i);
       //查询所有默认地址(最多两个，最少0个)
        List<Integer> uaids = userMapper.getIsDefault(userAddressVo);
        System.out.println(uaids);
           if(uaids.size()>1){
               for (Integer integer : uaids) {
                   //把另外默认地址修改为不默认
                   if(integer!=uaid){
                       int i1 = userMapper.updateOtherIsDefaultAsNot(integer);
                       System.out.println("其它默认地址修改影响行数:"+i1);
                   }
               }
           }
        return i;
    }

    public boolean updatePassword(UserInfo userInfo){
        int i = userMapper.updatePassword(userInfo);
        System.out.println(i);
        if(i>0){
            return true;
        }
        return false;
    }
    public boolean saveEmail(UserEmailVo userEmailVo){
        int i = userMapper.saveEmail(userEmailVo);
        //如果数据库中已经存在该email则i=0
        if(i>0){
            return true;
        }
        return false;
    }

    public int addUserAddress(UserAddressVo userAddressVo) {
        int i = userMapper.addUserAddress(userAddressVo);
        return i;
    }
    public int delAddress(@RequestParam int uaid){
        int i = userMapper.delAddress(uaid);
        return i;
    }
}
