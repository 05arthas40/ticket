package com.userManager.controller;

import com.userManager.dto.UserAddressDto;
import com.userManager.dto.UserInfoDto;
import com.userManager.pojo.UserInfo;
import com.userManager.service.UserInfoService;
import com.userManager.util.CodeUtil;
//import com.userManager.util.MailUtil;
import com.userManager.vo.UserAddressVo;
import com.userManager.vo.UserEmailVo;
import com.userManager.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class userInfoController {
    @Autowired
    UserInfoService userInfoService;
    //回显用户所有的基本资料
    @ResponseBody
    @RequestMapping(value = "getAllUserInfo",method = RequestMethod.POST)
    public Object getAllUserInfo(@RequestParam int userid){
        System.out.println(userid);
        UserInfoDto allUserInfo = userInfoService.getAllUserInfo(userid);
        return allUserInfo;
    }
    @ResponseBody
    @RequestMapping(value = "getUserAddress",method = RequestMethod.POST)
    public Object getUserAddress(@RequestBody UserAddressVo userAddressVo){

        List<UserAddressDto> userAddress = userInfoService.getUserAddress(userAddressVo);
        return userAddress;
    }

    @RequestMapping(value = "updateUserBaseInfo",method = RequestMethod.POST)
    //springmvc表单提交要和@RequestParam一一对应
    public Object updateUserBaseInfo(@RequestParam(value = "userid") String userid,@RequestParam(value = "gender") String gender,@RequestParam(value = "nickname") String nickname){
        System.out.println("进入更新用户基本信息");
        System.out.println(userid+gender+nickname);
        UserInfoVo userInfoVo = new UserInfoVo();
        userInfoVo.setUserid(Integer.parseInt(userid));
        userInfoVo.setGender(Integer.parseInt(gender));
        userInfoVo.setNickname(nickname);
        int i = userInfoService.updateUserBaseInfo(userInfoVo);
        if(i>0){
            return "myinfo";
        }
        return false;
    }
    //更新地址事务
    @ResponseBody
    @RequestMapping(value = "updateUserAddress",method = RequestMethod.POST)
    public Object updateUserAddress(@RequestBody UserAddressVo userAddressVo){
        System.out.println(userAddressVo);
        int i = userInfoService.updateUserAddressTransaction(userAddressVo);
        if(i>0){
            return true;
        }
        return false;
    }
    @ResponseBody
    @RequestMapping(value = "addUserAddress",method = RequestMethod.POST)
    public Object addUserAddress(@RequestBody UserAddressVo userAddressVo){
        System.out.println( userAddressVo);
        int i = userInfoService.addUserAddress(userAddressVo);
        return i;
    }
    @ResponseBody
    @RequestMapping(value = "delAddress",method = RequestMethod.POST)
    public int delAddress(@RequestParam int uaid){
        System.out.println(uaid);
        int i = userInfoService.delAddress(uaid);
        return i;
    }
    //修改密码(暂时用不上)
    @ResponseBody
    @RequestMapping(value = "updatePassword",method = RequestMethod.POST)
    public Object updatePassword(@RequestBody UserInfo userInfo){
        boolean flag= userInfoService.updatePassword(userInfo);
        return flag;
    }
    @ResponseBody
    @RequestMapping(value = "updateHeadImg",method = RequestMethod.POST)
    public Object ImgUpload(@RequestParam("fileImg") CommonsMultipartFile multipartFile, HttpServletRequest request){
        System.out.println("进入文件上传接口");
        Map<String, Object> result = new HashMap<String, Object>();
        // 获取上传的原始文件名
        String fileName = multipartFile.getOriginalFilename();
        // 设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath("/upload");
        System.out.println(filePath);
        // 获取文件后缀
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());

        // 判断并创建上传用的文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        // 重新设置文件名为 UUID，以确保唯一
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        System.out.println(file.getAbsolutePath());
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            // 写入文件
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回 JSON 数据，这里只带入了文件名
        result.put("fileName", file.getName());
        System.out.println(result);
        return result;
    }
    @ResponseBody
    @RequestMapping(value = "bindMail",method = RequestMethod.POST)
    //绑定邮箱
    public Object bindMail(@RequestBody UserEmailVo userEmailVo,HttpServletRequest request){
        System.out.println(userEmailVo);
        boolean b=false;
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        System.out.println(checkCode);
        if (checkCode.equals(userEmailVo.getCheckCode())) {
            b=this.userInfoService.saveEmail(userEmailVo);
            System.out.println("是否保存："+b);
            if(b==false){
                return "不可以用旧邮箱";
            }
            return b;
        }
        return b;
    }

//    @ResponseBody
//    @RequestMapping(value = "sendMail",method = RequestMethod.POST)
//    //发送邮箱验证码验证邮箱
//    public Object sendMail(@RequestBody UserEmailVo userEmailVo, HttpServletRequest request){
//        System.out.println(userEmailVo);
//        String email = userEmailVo.getEmail();
//        String randomCode = CodeUtil.getRandomCode();
//        boolean flag=true;
//        if(!email.matches("^\\w+@(\\w+\\.)+\\w+$")){
//            System.out.println("请输入正确邮箱格式");
//            flag=false;
//            return flag;
//        }
//        if(flag){
//            //发送邮件
//            new Thread(new MailUtil(email,randomCode)).start();
//        }
//        request.getSession().setAttribute("checkCode",randomCode);
//        return flag;
//    }
}
