package com.pinyu.miniprogram.global.exception;

/**
 * @author ypp 创建时间：2018年11月22日 上午10:51:20
 * @Description: TODO(用一句话描述该文件做什么)
 */
public class TimeoutException extends RuntimeException{

	public TimeoutException(String msg) {
		super(msg);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return super.toString();
	}
}
