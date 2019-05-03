package com.pinyu.miniprogram.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;
import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;
import com.pinyu.miniprogram.utils.SessionUtils;

/**
 * @author ypp 创建时间：2018年12月26日 下午5:24:13
 * @Description: TODO(用一句话描述该文件做什么)
 */
public abstract class BaseController<T extends BaseEntity> {
	
	protected static final Level OPERATING = Level.forName("OPERATING", 50);

	/**
	 * 要跳转的页面
	 */
	protected ModelAndView go(String path) {
		return new ModelAndView(path);
	}

	/**
	 * 获取登录用户信息
	 * 
	 * @return
	 */
	public MemberEntity getMember(HttpServletRequest request) {
		return SessionUtils.getMember(request);
	}


	/**
	 * 获取国际化信息
	 * 
	 * @param key
	 * @return
	 */
	public String getI18nMsg(HttpServletRequest request, String key) throws Exception {
		// 从后台代码获取国际化信息
		String value = new RequestContext(request).getMessage(key);
		return value != null ? value : "";
	}

	/**
	 * 请求方式判断
	 * 
	 * @param request
	 * @return
	 */
	public boolean isAjaxRequest(HttpServletRequest request) {
		if (!(request.getHeader("accept").indexOf("application/json") > -1
				|| (request.getHeader("X-Requested-With") != null
						&& request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)
				|| "XMLHttpRequest".equalsIgnoreCase(request.getParameter("X_REQUESTED_WITH")))) {
			return false;
		}
		return true;
	}

	/**
	 * 设置 cookie
	 * 
	 * @param cookieName
	 * @param value
	 * @param age
	 */
	protected void setCookie(HttpServletResponse response, String cookieName, String value, int age) {
		Cookie cookie = new Cookie(cookieName, value);
		cookie.setMaxAge(age);
		// cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}

	/**
	 * 方法名称: getUUID<br>
	 * 描述：获得唯一标识(目前用于验证表单提交唯一性)<br>
	 * 作者: <br>
	 * 修改日期：2014年10月13日上午3:15:24<br>
	 */
	protected String getUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 获取请求完整路径
	 * 
	 * @param request
	 * @return
	 */
	public String getUrl(HttpServletRequest request) {
		String url = request.getRequestURI();
		String params = "";
		if (request.getQueryString() != null) {
			params = request.getQueryString().toString();
		}
		if (!"".equals(params)) {
			url = url + "?" + params;
		}
		return url;
	}

	/**
	 * 把浏览器参数转化放到Map集合中
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected Map<String, Object> getParam(HttpServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String method = request.getMethod();
		Enumeration<?> keys = request.getParameterNames();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			if (key != null) {
				if (key instanceof String) {
					String value = request.getParameter(key.toString());
					if ("GET".equals(method)) {// 前台encodeURIComponent('我们');转码后到后台还是ISO-8859-1，所以还需要转码
						try {
							value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					paramMap.put(key.toString(), value);
				}
			}
		}
		return paramMap;
	}

	/**
	 * 获取集合数据里面的id
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	protected List<Long> getIds(List<T> list) {
		List<Long> ids = new ArrayList<Long>();
		if (list != null && list.size() > 0) {
			for (T t : list) {
				ids.add(t.getId());
			}
		}
		return ids;
	}
}
