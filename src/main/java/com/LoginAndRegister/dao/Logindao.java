package com.LoginAndRegister.dao;

import com.LoginAndRegister.dto.Marchantinfodto;
import com.LoginAndRegister.dto.Userdto;
import com.LoginAndRegister.vo.LoginInfo;
import com.LoginAndRegister.vo.LoginMarchant;
import com.LoginAndRegister.vo.RegisterInfo;
import com.LoginAndRegister.vo.updatepwd;

/**
 * @author chenzhengufu
 * 登录dao
 */
public interface Logindao {
    /**
     * 检查用户名是否存在
     * @param regist_account 注册用户名
     * @return
     */
    public Userdto checkUsername(String regist_account);

    /**
     * 登录验证
     * @param loginInfo 用户名和密码
     * @return
     */
    public Userdto loginCheck(LoginInfo loginInfo);

    /**
     * 修改密码
     */
    public boolean updatepwd(updatepwd up);

    /**
     * 检查手机是否被注册过
     */
    public Userdto checkphone(String phone);

    /**
     * 商家登录验证
     * @param loginMarchant
     * @return
     */
    public Marchantinfodto loginCheckMarchant(LoginMarchant loginMarchant);

}
