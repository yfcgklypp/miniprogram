package com.pinyu.miniprogram.global.ann;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义切面注解
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodLog {

	/**
	 * 该注解作用于方法上时需要备注信息
	 */
	int value() default 0;

	String remark() default "";

	String operType() default "";
}