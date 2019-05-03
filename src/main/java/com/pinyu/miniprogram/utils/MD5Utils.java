package com.pinyu.miniprogram.utils;

import org.apache.commons.codec.digest.DigestUtils;

import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;

/**
 * @author ypp
 */
public class MD5Utils {
	
	private static final String PWD_KEY=MemberEntity.class.getName();

	/**
	 * 加密解密算法 执行一次加密，两次解密
	 */
	public static String convertMD5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}

	/**
	 * MD5方法
	 * 
	 * @param text
	 *            明文
	 * @param key
	 *            密钥
	 * @return 密文
	 * @throws Exception
	 */
	public static String md5(String text, String key) {
		// 加密后的字符串
		String encodeStr = DigestUtils.md5Hex(text + key);
		System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
		return encodeStr;
	}
	
	public static String md5(String text){
		// 加密后的字符串
		String encodeStr = DigestUtils.md5Hex(text + PWD_KEY);
		System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
		return encodeStr;
	}

	/**
	 * MD5验证方法
	 * 
	 * @param text
	 *            明文
	 * @param key
	 *            密钥
	 * @param md5
	 *            密文
	 * @return true/false
	 * @throws Exception
	 */
	public static boolean verify(String text, String key, String md5) throws Exception {
		// 根据传入的密钥进行验证
		String md5Text = md5(text, key);
		if (md5Text.equalsIgnoreCase(md5)) {
			System.out.println("MD5验证通过");
			return true;
		}
		return false;
	}
}
