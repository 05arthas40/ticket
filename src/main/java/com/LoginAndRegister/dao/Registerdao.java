package com.LoginAndRegister.dao;

import com.LoginAndRegister.vo.RegisterInfo;
import com.LoginAndRegister.vo.RegisterMarchant;

public interface Registerdao {
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
