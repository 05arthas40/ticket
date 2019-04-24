package com.LoginAndRegister.loginMap;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UserloginMap{
    /**
     * 这里还可以使用doublecheck方式保证多线程下map的单例的
     */
    private static  Map<String,String> loginMap=new ConcurrentHashMap<>();


    public static Map<String,String> getLoginMap(){
        return loginMap;
    }
    /**
     * 添加
     */
    public static void add(String key,String value){
        loginMap.put(key,value);
    }
    /**
     * 移除
     */
    public static void romvelogininfo(String value){
        Set<Map.Entry<String, String>> entrySet = loginMap.entrySet();
        entrySet.forEach((s)->{
            if(value.equals(s.getValue())){
                loginMap.remove(s.getKey());
                return;
            }
        });
    }
    /**
     * 判断用户是否在map中，即是否登录
     */
    public static boolean islogin(String loginid,String sessionid){
      return  (loginMap.containsKey(loginid)&&sessionid.equals(loginMap.get(loginid)));
    }
}
