package com.pinyu.miniprogram.utils.code;

import java.util.UUID;

/**
 * @author ypp 创建时间：2018年10月10日 下午3:01:30
 * @Description: TODO(编号生成工具类)
 */
public class CodeGenUtils {

	public static final String LAND_LORD_BILL = "L";//房东账单编号
	public static final String TENANT_BILL = "T";//租客账单编号

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };

	public static String generateLandLordOrderUuid(String code) {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return (System.currentTimeMillis()+LAND_LORD_BILL+code+shortBuffer.toString()).toUpperCase();
	}
	public static String generateTenantOrderUuid(String code) {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return (System.currentTimeMillis()+TENANT_BILL+code+shortBuffer.toString()).toUpperCase();
	}
	public static String generateUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return (System.currentTimeMillis()+shortBuffer.toString()).toUpperCase();
	}
}
