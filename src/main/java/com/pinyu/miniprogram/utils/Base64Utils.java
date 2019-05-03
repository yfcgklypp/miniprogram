package com.pinyu.miniprogram.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author ypp
 */
public class Base64Utils {

	private static BASE64Encoder encoder = new BASE64Encoder();// 加密
	private static BASE64Decoder decoder = new BASE64Decoder();// 解密

	/**
	 * 加密文件
	 * 
	 * @param f
	 * @param path
	 */
	private static String encryptFile(File f, String path) {
		InputStream in = null;
		OutputStream out = null;
		String key = "";
		try {
			f = new File(path);
			in = new FileInputStream(f);
			out = new ByteArrayOutputStream();
			// System.out.println(f.getAbsolutePath());
			// System.out.println(f.length());
			encoder.encodeBuffer(in, out);
			key = out.toString();
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * 解密
	 * 
	 * @param f
	 * @param path
	 */
	private static String decryptFile(File f, String path) {
		InputStream in = null;
		OutputStream out = null;
		String key = "";
		try {
			f = new File(path);
			in = new FileInputStream(f);
			out = new ByteArrayOutputStream();
			decoder.decodeBuffer(in, out);
			key = out.toString();
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * 加密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(String inputStr) {
		String value = "";
		try {
			byte[] key = inputStr.getBytes();
			value = encoder.encodeBuffer(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	/**
	 * 解密
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decryptBASE64(String outputStr) {
		String value = "";
		try {
			byte[] key = decoder.decodeBuffer(outputStr);
			value = new String(key);
		} catch (Exception e) {
		}
		return value;
	}
}
