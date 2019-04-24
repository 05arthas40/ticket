package com.LoginAndRegister.Interceptor;

import com.LoginAndRegister.dto.Marchantinfodto;
import com.LoginAndRegister.dto.Userdto;
import com.LoginAndRegister.entity.UserCheckTokenInfo;
import com.LoginAndRegister.entity.Userinfo;
import com.LoginAndRegister.loginMap.UserloginMap;
import com.LoginAndRegister.utils.HttpClient;
import com.LoginAndRegister.vo.LoginInfo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.lang.reflect.InvocationHandler;
import java.net.UnknownHostException;
import java.util.List;

/**
 * @author admin
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
       //设置响应编码格式，防止中文乱码
        httpServletResponse.setContentType("text/html;utf-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        //获取请求路径
        String requestURI = httpServletRequest.getRequestURI();
        System.out.println(requestURI);
        //获取完整的路径http://localhost:8080/ticket
//        String path=httpServletRequest.getContextPath();
//        String basePath = httpServletRequest.getScheme()+"://"+httpServletRequest.getServerName()+":"+httpServletRequest.getServerPort()+path;
//        System.out.println(basePath);
        //如果是登录注册页面就放行
        if(requestURI.endsWith("login.html")||requestURI.equals("loginCheck")||requestURI.endsWith("updatepassword.html")||requestURI.endsWith("Register_merchant.html")||requestURI.endsWith("wangEditor.html")||requestURI.endsWith("MarchantLogin.html")){
            return true;
        }else{
            //如果不是访问登录注册页面，则判断是否以及登录过，即是否有session
            HttpSession session = httpServletRequest.getSession();
            LoginInfo user =(LoginInfo) session.getAttribute("userinfo");
            //商家登录
            Marchantinfodto marchantlogin = (Marchantinfodto)session.getAttribute("marchantlogin");
            if(marchantlogin!=null){ return true; }
            //如果用户登录信息为null，则跳转到用户登录页
            if(user==null){
                httpServletResponse.getWriter().write("<script>alert('您还没有登录，请登录');location.href='login.html';</script>");
                return false;
            }
            System.out.println("map:"+UserloginMap.getLoginMap());
            //如果用户已经登录的情况下
            if(user!=null){
                //判断同一账号是否多次登录，如果是则强制一方下线。
                /**
                 * 用一个map集合装用户登录信息，用户名是唯一的，而sessionid是可变的
                 * 再根据map如果key相同，则value覆盖，所以使用userid作为key,sessionid作为value
                 * 如果在map中根据key找不到value，那么证明sessionid改变了，即重复登录了
                 * 那么有一边就要强制下线
                 */
            if(!UserloginMap.islogin(user.getLogin_number(),session.getId())){
                //强制用户下线
                httpServletResponse.getWriter().write("<script>alert('你的账户在别处登录，如果不是本人，请及时修改密码');location.href='login.html';</script>");
                //如果存在cookie，则清空cookie
                Cookie[] cookies = httpServletRequest.getCookies();
                if(cookies!=null){
                    for (Cookie cookie : cookies){
                        if(cookie.getName().equals("login_number")){
                            cookie.setMaxAge(0);
                            httpServletResponse.addCookie(cookie);
                        }
                        if(cookie.getName().equals("login_password")){
                            cookie.setMaxAge(0);
                            httpServletResponse.addCookie(cookie);
                        }
                    }
                }
                return false;
            }
            }
           return true;
        }
    }
     @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
     @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
