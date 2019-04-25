package com.userManager.service;

import com.userManager.dto.UserAddressDto;
import com.userManager.dto.UserInfoDto;
import com.userManager.pojo.UserInfo;
import com.userManager.vo.UserAddressVo;
import com.userManager.vo.UserEmailVo;
import com.userManager.vo.UserInfoVo;


import java.util.List;

public interface UserInfoService {
    public UserInfoDto getAllUserInfo(int userid);
    public List<UserAddressDto> getUserAddress(UserAddressVo userAddressVo);
    public int updateUserBaseInfo(UserInfoVo userInfoVo);
    public int updateUserAddressTransaction(UserAddressVo userAddressVo);
    public boolean updatePassword(UserInfo userInfo);
    public boolean saveEmail(UserEmailVo userEmailVo);
    public int addUserAddress(UserAddressVo userAddressVo);
    public int delAddress(int uaid);
}
