package com.LoginAndRegister.service;

import com.LoginAndRegister.dto.Marchantinfodto;
import com.LoginAndRegister.dto.Userdto;
import com.LoginAndRegister.vo.LoginInfo;
import com.LoginAndRegister.vo.LoginMarchant;
import com.LoginAndRegister.vo.RegisterInfo;
import com.LoginAndRegister.vo.updatepwd;

/**
 * @author chenzhengfu
 * 处理登录信息
 */
public interface LoginService {
    /**
     * 验证用户名是否存在
     * @return 验证成功返回true
     */
    public boolean checkUsername(String regist_account);

    /**
     * 用户登录验证
     * @param
     * @return
     */
    public Userdto loginCheck(LoginInfo loginInfo);

    /**
     * 商家登录验证
     * @param
     * @return
     */
    public Marchantinfodto loginCheckMarchant(LoginMarchant loginMarchant);

    /**
     * 修改密码
     */
    public boolean updatepwd(updatepwd up);

    /**
     * 检查手机是否被注册过
     */
    public Userdto checkphone(String phone);
}
