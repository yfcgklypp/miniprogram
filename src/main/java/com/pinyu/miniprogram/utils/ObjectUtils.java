package com.pinyu.miniprogram.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import org.apache.commons.lang3.StringUtils;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;
/**
 * @author ypp
 */
public class ObjectUtils {

	public static BaseEntity validatePropertyIsNull(BaseEntity entity){
		if(entity!=null){
			try {
				Class<? extends BaseEntity> clazz = entity.getClass();
				// 获取实体类的所有属性，返回Field数组
				Field[] declaredFields = clazz.getDeclaredFields();
				for (Field field : declaredFields) {
					Type genericType = field.getGenericType();
	//				// 如果类型是String
				    if (genericType.toString().equals("class java.lang.String")) {
	//				     // 拿到该属性的gettet方法
						Method getName = (Method) entity.getClass().getMethod("get" + getMethodName(field.getName()));
						String val = (String) getName.invoke(entity);// 调用getter方法获取属性值
						if (StringUtils.isBlank(val)) {
							Method setName = (Method) entity.getClass().getMethod("set" + getMethodName(field.getName()));
							setName.invoke(entity,"");
						}
				    }
				    if (genericType.toString().equals("class java.lang.Integer")) {
						Method getName = (Method) entity.getClass().getMethod("get" + getMethodName(field.getName()));
						String val = (String) getName.invoke(entity);// 调用getter方法获取属性值
						if (StringUtils.isBlank(val)) {
							Method setName = (Method) entity.getClass().getMethod("set" + getMethodName(field.getName()));
							setName.invoke(entity,null);
						}
				    }
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return entity;
	}

	// 把一个字符串的第一个字母大写、效率是最高的、
	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}
		
}
