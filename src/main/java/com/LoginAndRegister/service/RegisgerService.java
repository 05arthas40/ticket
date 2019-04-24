package com.LoginAndRegister.service;

import com.LoginAndRegister.vo.RegisterInfo;
import com.LoginAndRegister.vo.RegisterMarchant;

/**
 * @author chenzhengfu
 * 注册接口
 */
public interface RegisgerService {
    /**
     * 获取验证码
     * @return 执行成功返回字符串 success
     */
    public String  getcode(String regist_phone);

    /**
     * 注册信息存储
     * @return
     */
    public boolean register(RegisterInfo registerInfo);

    /**
     * 商家注册
     */
    public boolean RegisterMarchant(RegisterMarchant registerMarchant);
}
