package com.LoginAndRegister.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	/**
	 * 使用md5的算法进行加密
	 */
	private static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("没有md5这个算法！");
		}
		// 16进制数字
		String md5code = new BigInteger(1, secretBytes).toString(16);
		StringBuffer sb=new StringBuffer(md5code);
		// 如果生成数字未满32位，需要前面补0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			sb =sb.insert(0,"0");
		}
		return sb.toString();
	}
	/**
	 * 对md5进行加盐处理，降低被暴力破解的可能性
	 * 这里使用的是对自己加盐的方法，也可以加时间戳的方式。
	 */
  public static String encodePassword(String password){
		String newPwd="";
		for (int i=0;i<5;i++){
			newPwd=md5(password+newPwd);
		}
		return newPwd;
  }
}
