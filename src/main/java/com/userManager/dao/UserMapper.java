package com.userManager.dao;

import com.userManager.dto.UserInfoDto;
import com.userManager.dto.UserAddressDto;
import com.userManager.pojo.UserInfo;
import com.userManager.vo.UserAddressVo;
import com.userManager.vo.UserEmailVo;
import com.userManager.vo.UserInfoVo;

import java.util.List;

public interface UserMapper {
    public UserInfoDto getAllUserInfo(int userid);
    public List<UserAddressDto> getUserAddress(UserAddressVo userAddressVo);
    public int updateUserInfo(UserInfoVo userInfoVo);
    //更新当前地址
    public int updateUserAddress(UserAddressVo userAddressVo);
    public List<Integer> getIsDefault(UserAddressVo userAddressVo);
    public int updateOtherIsDefaultAsNot(int uaid);
    //更新密码
    public int updatePassword(UserInfo userInfo);
    //保存用户email
    public int saveEmail(UserEmailVo userEmailVo);
    //添加新地址
    public int addUserAddress(UserAddressVo userAddressVo);
    //删除地址
    public int delAddress(int uaid);
}
