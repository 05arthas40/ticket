package com.userManager.util;

import java.util.Random;
import java.util.UUID;

public class CodeUtil {
    public static String getRandomCode() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        str += str.toLowerCase();
        str += "1234567890";
        // 将String字符串转换成字符型数组
        StringBuilder sb = new StringBuilder(5);
        // StringBuilder在多线程并发操作时会出现线程不安全，但性能最高
        for (int i = 0; i < 5; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return sb.toString();
    }
    public static String getUUidCode(){
        //获得六位验证码（包括小写字母和数字，不包括大写字母）
//        String result = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 6);
        UUID uuid = UUID.randomUUID();
        String string1 = uuid.toString();
        String string2 = string1.replaceAll("-", "");
        String string3 = string2.substring(0, 6);
        System.out.println("验证码为：" + uuid);//77be56a9-b516-4739-8f04-61a11a2e25d4
        System.out.println("验证码为：" + string1);//77be56a9-b516-4739-8f04-61a11a2e25d4
        System.out.println("验证码为：" + string2);//77be56a9b51647398f0461a11a2e25d4
        System.out.println("验证码为：" + string3);//77be56
     return string1;
    }
    public static void main(String[] args) {
        /*String randomCode =CodeUtil .getRandomCode();
        System.out.println(randomCode);*/
        String UUidCode = CodeUtil.getUUidCode();
        System.out.println(UUidCode);
    }
}
