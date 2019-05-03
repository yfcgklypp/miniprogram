package com.pinyu.miniprogram.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.WebUtils;

import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;

/**
 * ypp
 */
public class SessionUtils {

	public static final String MEMBER_SESSION = "CURRENTWXMEMBER";// 登录用户

	/**
	 * 获取系统登录用户
	 */
	public static final MemberEntity getMember(HttpServletRequest request) {
		return (MemberEntity) WebUtils.getSessionAttribute(request, SessionUtils.MEMBER_SESSION);
	}

	/**
	 * 设置系统登录用户
	 */
	public static final void setMember(HttpServletRequest request, MemberEntity member) {
		WebUtils.setSessionAttribute(request, SessionUtils.MEMBER_SESSION, member);
	}


}
