package com.LoginAndRegister.service.impl;

import com.LoginAndRegister.dao.Logindao;
import com.LoginAndRegister.dto.Marchantinfodto;
import com.LoginAndRegister.dto.Userdto;
import com.LoginAndRegister.service.LoginService;
import com.LoginAndRegister.utils.MD5Utils;
import com.LoginAndRegister.vo.LoginInfo;
import com.LoginAndRegister.vo.LoginMarchant;
import com.LoginAndRegister.vo.RegisterInfo;
import com.LoginAndRegister.vo.updatepwd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenzhengfu
 * 登录接口实现类
 */
@Service
public class LoginServiceImpl implements LoginService {
   @Autowired
   Logindao logindao;
    public boolean checkUsername(String regist_account) {
        if(logindao.checkUsername(regist_account)==null){
            return true;
        }
        return false;
    }

    public Userdto loginCheck(LoginInfo loginInfo) {
        //将原来密码进行加密，方便数据比对
        loginInfo.setLogin_password(MD5Utils.encodePassword(loginInfo.getLogin_password()));
        return logindao.loginCheck(loginInfo);
    }
    public Marchantinfodto loginCheckMarchant(LoginMarchant loginMarchant){
        loginMarchant.setRegist_password1(MD5Utils.encodePassword(loginMarchant.getRegist_password1()));
        return logindao.loginCheckMarchant(loginMarchant);
    }

    public boolean updatepwd(updatepwd up){
        up.setRegist_password2(MD5Utils.encodePassword(up.getRegist_password2()));
        return  logindao.updatepwd(up);
    }
    public Userdto checkphone(String phone) {
        return logindao.checkphone(phone);
    }
}
