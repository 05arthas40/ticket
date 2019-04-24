package com.LoginAndRegister.note;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/***
 *
 * @author chen
 * 验证码工具类
 *
 */

/**
 * 这里明显存在bug，code应该存放在Redis中，不应该存在静态区。这样容易发生问题。
 */
public class CodeUtils{
	private static String code;
	public static String getCode() {
		return code;
	}
	public static void setCode(String code) {
		CodeUtils.code = code;
	}
	//生成6位验证码(中英文混合)
	public static String EnAndNum_code(){
		String sources = "0123456789qwertyuiopasdfghjklzxcvbnm";
		//随机数（伪随机）
		Random rand = new Random();
		//只创建一个对象，线程安全，适合对字符串的修改，速度比string快
		StringBuffer code = new StringBuffer();
		//取6位数的英文和数字组合的验证码
		for (int i = 0; i < 6; i++) {
			//append：字符串拼接    charAt:字符串索引
			code.append(sources.charAt(rand.nextInt(27)));
		}
		return code.toString();
	}
	//6位数字验证码
	public static String Num_code(){
		//Math.random()的范围：0.0-1.0（不包括1.0）
		code = String.valueOf((int)((Math.random()*9+1)*100000));
		return code;
	}
}
