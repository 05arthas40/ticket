package com.LoginAndRegister.controller;

import com.LoginAndRegister.XssFilter.JsoupUtils;
import com.LoginAndRegister.dto.Marchantinfodto;
import com.LoginAndRegister.dto.Userdto;
import com.LoginAndRegister.entity.UserCheckTokenInfo;
import com.LoginAndRegister.loginMap.UserloginMap;
import com.LoginAndRegister.note.CodeUtils;
import com.LoginAndRegister.service.LoginService;
import com.LoginAndRegister.service.RegisgerService;
import com.LoginAndRegister.utils.HttpClient;
import com.LoginAndRegister.vo.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

/**
 * bug1:用户在一端登录，一端改密码，登录的一方仍然可以操作
 * 原因：判断用户是否登录的是session，而密码修改了，并不影响session。
 * 已解决：当修改密码成功后修改sessionid,从而使sessionid失效。
 * bug2：对于@requestBody 过滤出错。
 * 小问题：get请求中文乱码 （使用自定义filter解决）
 * @author chenzhengfu
 * 登录注册信息页
 */
@RestController
public class LoginAndRegisterController {
    @Autowired
    RegisgerService regisgerService;
    @Autowired
    LoginService loginService;

    private Userdto userdto;

    public Userdto getUserdto() {
        return userdto;
    }

    public void setUserdto(Userdto userdto) {
        this.userdto = userdto;
    }

    /**
     * 登录验证中心
     * @param loginInfo 登录信息
     * @return 响应请求
     */
    @PostMapping(value = "loginCheck")
    public String loginCheck(@RequestBody @Valid LoginInfo loginInfo, BindingResult bindingResult, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        //格式校验
        List s = geterrorInfo(bindingResult);
        if(s!=null){return s.toString();}
        //用来设置自动登录，因为如果验证过后就会自动加密了
        String pwd=loginInfo.getLogin_password();
        //校验信息，如果成功则获取到令牌
        String logintoken = checkUserCenter(loginInfo, session);
        //令牌校验
        if(!"error".equals(logintoken)){
            JSONObject json = checkToken(logintoken, session);
            if("success".equals(json.get("code"))){
                System.out.println("令牌校验成功");
                //如果有勾选记住我
                if(loginInfo.getRember()!=null&"true".equals(loginInfo.getRember())){
                    Cookie login_number=new Cookie("login_number",loginInfo.getLogin_number());
                    //设置过期时间半小时
                    login_number.setMaxAge(30*60);
                    response.addCookie(login_number);
                    Cookie login_password=new Cookie("login_password",pwd);
                    //设置过期时间半小时
                    login_password.setMaxAge(30*60);
                    response.addCookie(login_password);
                }
                //创建局部会话
                session.setAttribute("userinfo",loginInfo);
                //将登录信息添加进map,方便后面判断是否重复登录
                UserloginMap.add(loginInfo.getLogin_number(),session.getId());
                Userdto userdto = getUserdto();
                session.setAttribute("user",userdto);
                Cookie cookie=new Cookie("userid",userdto.getUserid().toString());
                cookie.setMaxAge(1800);
                response.addCookie(cookie);
                return "success";
            }
        }
        return "error";
    }
    /**
     * 商家登录
     * @param loginMarchant
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "marchantLogin")
    public String marchantLogin(@RequestBody @Valid LoginMarchant loginMarchant, BindingResult bindingResult,HttpSession session){
        //格式校验
        List s = geterrorInfo(bindingResult);
        if(s!=null){return s.toString();}
        Marchantinfodto marchantinfodto = loginService.loginCheckMarchant(loginMarchant);
        if(marchantinfodto!=null){
            session.setAttribute("marchantlogin",marchantinfodto);
            return "success";
        }
        return "error";
    }
    /**
     * 密码修改
     */
    @PostMapping(value = "updatepwd")
    public String updatepwd(@RequestBody @Valid updatepwd up, BindingResult bindingResult, HttpSession session,HttpServletRequest request,HttpServletResponse response){
        //格式校验
        List s = geterrorInfo(bindingResult);
        if(s!=null){return s.toString();}
        //验证码是否匹配
        if(up.getRegist_vcode().equals(session.getAttribute("code"))&&up.getRegist_phone().equals(session.getAttribute("phone"))){
            //修改密码.
            if(loginService.updatepwd(up)){
                //思路：如果密码更改成功了，则更改map，用户名不变，session改变，那么登录的那一端就要强制下线了
                //具体实现：从session中获取用户登录信息，然后在设置一个一样的session，
                //再添加到map中，从而达到改变sessionid目的，
                // 此时登录的一方如果请求服务器，那么就会发现sessionid，从而达到强制下线的目的
                LoginInfo loginInfo = (LoginInfo) session.getAttribute("userinfo");
                session.setAttribute("userinfo",loginInfo);
                UserloginMap.add(loginInfo.getLogin_number(),session.getId());
                return "success";
            }
        }
        return "error";
    }
    /**
     * 注册
     * @param registerInfo 注册信息
     * @return 响应请求
     */
    @PostMapping(value = "register")
    public String register(@RequestBody @Valid RegisterInfo registerInfo, BindingResult bindingResult, HttpSession session){
        //获取校验错误信息
        List s = geterrorInfo(bindingResult);
        if(s!=null){return s.toString();}
        //输入验证码和手机号匹配
        if(registerInfo.getRegist_vcode().equals(session.getAttribute("code"))&&registerInfo.getRegist_phone().equals(session.getAttribute("phone"))){
            //检查手机号是否被注册过
            Userdto checkphone = loginService.checkphone(registerInfo.getRegist_phone());
            if(checkphone!=null){return "notregister";}
            //存储注册信息
            boolean register = regisgerService.register(registerInfo);
            if(register){
                return "success";
            }
        }
        return "error";
    }
    /**
     * 商家注册
     */
    @PostMapping(value = "RegisterMarchant")
    public String RegisterMarchant(@RequestBody @Valid RegisterMarchant registerMarchant, BindingResult bindingResult){
        //获取校验错误信息
        List s = geterrorInfo(bindingResult);
        if(s!=null){return s.toString();}
        String clean = JsoupUtils.clean(registerMarchant.toString());

        Object parse = JSONObject.parse("{"+clean+"}");
        System.out.println(parse);
        boolean isregist = regisgerService.RegisterMarchant(registerMarchant);
        if (isregist){
            return "success";
        }else{
            return "error";
        }
    }
    /**
     * 获取验证码
     * @return 响应请求
     */
    @GetMapping(value = "getcode")
    public String getcode(@RequestParam String regist_phone,HttpSession session){
        //获取手机验证码
        regisgerService.getcode(regist_phone);
        //将验证码和手机号码放入session中
        session.setAttribute("code", CodeUtils.getCode());
        session.setAttribute("phone",regist_phone);
        //设置保存时间(5分钟)
        session.setMaxInactiveInterval(60*5);
        return "ok";
    }
    /**
     * 查询数据库中是否有这个用户，如果没有则允许注册
     * @return 响应请求
     */
    @PostMapping(value = "checkUsername")
    public boolean checkUsername(@RequestParam String regist_account){
        System.out.println(regist_account);
        boolean checkusername = loginService.checkUsername(regist_account);
        return checkusername;
    }
    /**
     * 校验错误信息集合
     */
    public List<String> geterrorInfo(BindingResult result){
        List<String>list=new ArrayList<String>();
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                list.add(error.getDefaultMessage());
            }
            return list;
        }
        return null;
    }
    /**
     * 校验和发放令牌
     */
    public String checkUserCenter(LoginInfo loginInfo,HttpSession session){
        //数据中心校验
        Userdto userdto = loginService.loginCheck(loginInfo);
        setUserdto(userdto);
        //如果校验成功，则发送令牌
        if(userdto!=null&&userdto.toString()!=""){
            //创建全局会话
            session.setAttribute("login","true");
            //创建令牌并发送回去。
            String logintoken = gettoken();
            session.setAttribute("token",logintoken);
            return logintoken;
        }
        return "error";
    }
    /**
     * 令牌校验
     */
    public JSONObject checkToken(String token,HttpSession session){
        JSONObject jsonObject=new JSONObject();
        if(token!=null&&token.equals(session.getAttribute("token"))){
            jsonObject.put("code","success");
            jsonObject.put("msg","认证成功");
            return jsonObject;
        }else {
            jsonObject.put("code","failed");
            jsonObject.put("msg","认证失败");
            return jsonObject;
        }
    }
    /**
     * 生成令牌
     * @return
     */
    private String gettoken(){
        return UUID.randomUUID().toString();
    }
}
