package com.pinyu.miniprogram.utils.code;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class UUIDUtils {

	Logger logger = LogManager.getLogger(UUIDUtils.class);
	
	public UUIDUtils() {
	}

	/**
	 * 获得一个UUID
	 * 
	 * @return String UUID
	 */
	public static String getUUID() {
		String s = UUID.randomUUID().toString();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}
	
	/**
	 * 获得一个UUID-全大写
	 * 
	 * @return String UUID
	 */
	public static String getUpperCaseUUID() {
		String s = UUID.randomUUID().toString().toUpperCase();
		// 去掉“-”符号
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
	}

	/**
	 * 获得指定数目的UUID
	 * 
	 * @param number
	 *            int 需要获得的UUID数量
	 * @return String[] UUID数组
	 */
	public static String[] getUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID();
		}
		return ss;
	}
	public static String[] getUpperCaseUUID(int number) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUpperCaseUUID();
		}
		return ss;
	}

	public static void main(String[] args) {
		String[] ss = getUpperCaseUUID(10);
		for (int i = 0; i < ss.length; i++) {
			System.out.println(ss[i]);
		}
	}
}
