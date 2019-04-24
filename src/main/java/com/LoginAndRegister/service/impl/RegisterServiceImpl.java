package com.LoginAndRegister.service.impl;

import com.LoginAndRegister.dao.Registerdao;
import com.LoginAndRegister.note.IndustrySMS;
import com.LoginAndRegister.service.RegisgerService;
import com.LoginAndRegister.utils.MD5Utils;
import com.LoginAndRegister.vo.RegisterInfo;
import com.LoginAndRegister.vo.RegisterMarchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenzhengfu
 * 注册实现类
 */
@Service
public class RegisterServiceImpl implements RegisgerService {
    @Autowired
    Registerdao registerdao;
    public String getcode(String regist_phone) {
        //请求第三方短信接口
        IndustrySMS.execute(regist_phone);
        return "success";
    }

    public boolean register(RegisterInfo registerInfo) {
        //加密处理
        registerInfo.setRegist_password2(MD5Utils.encodePassword(registerInfo.getRegist_password2()));
        return  registerdao.register(registerInfo);
    }

    public boolean RegisterMarchant(RegisterMarchant registerMarchant) {
        //加密处理
        registerMarchant.setRegist_password1(MD5Utils.encodePassword(registerMarchant.getRegist_password1()));
        return registerdao.RegisterMarchant(registerMarchant);
    }
}
