package com.LoginAndRegister.entity;

import com.LoginAndRegister.vo.LoginInfo;

/**
 * @author chenzhengfu
 * 数据校验中心需要的数据
 */
public class UserCheckTokenInfo {
    //用户名和密码
    private  LoginInfo loginInfo;
    //url
    private String url;
    //令牌
    private String token;

    public LoginInfo getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserCheckTokenInfo{");
        sb.append("loginInfo=").append(loginInfo);
        sb.append(", url='").append(url).append('\'');
        sb.append(", token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
