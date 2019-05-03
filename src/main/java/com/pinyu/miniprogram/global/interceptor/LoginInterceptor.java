package com.pinyu.miniprogram.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.pinyu.miniprogram.global.GlobalConstants;
import com.pinyu.miniprogram.global.GlobalConstants.PermissionRelease;

/**
 * @author ypp
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	Logger log = LogManager.getLogger(LoginInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object args) throws Exception {
		return true;
		// 获取访问URL
		/**
		String basePath = request.getContextPath();
		String pathURI = request.getRequestURI();
		String path = pathURI.substring(basePath.length());
		if (!doLoginInterceptor(path)) {// 是否进行登陆拦截
			return true;
		}
		SysUserEntity loginUser = SessionUtils.getLoginUser(request);
		if (loginUser == null) {
			String requestType = request.getHeader("X-Requested-With");
			if (requestType != null && requestType.equals("XMLHttpRequest")) {
				response.setHeader("sessionstatus", "timeout");
				response.getWriter().print("LoginTimeout");
				return false;
			} else {
				log.info("尚未登录，跳转到登录界面");
				if(StringUtils.isBlank(basePath)){
					basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+basePath+"/";
				}
				response.sendRedirect(basePath);
			}
			return false;
		} else {
			request.getSession().setMaxInactiveInterval(60 * 60);
//			return true;
			//左侧菜单、修改密码、退出和无权限提示页面已登录情况所有放行
			PermissionRelease[] prs = GlobalConstants.PermissionRelease.values();
			for (PermissionRelease permissionRelease : prs) {
				if(path.equals(permissionRelease.getUrl())&&permissionRelease.getType()==1){
					return true;
				}
			}
			log.info("没有权限");
			response.sendRedirect(basePath + GlobalConstants.PermissionRelease.INDEX_NOTAUTHENTICATION.getUrl());
			return false;
		}
		*/
	}
	

	/**
	 * 是否进行登陆过滤
	 * 
	 * @param path
	 * @param basePath
	 * @return
	 */
	private boolean doLoginInterceptor(String path) {
		PermissionRelease[] prs = GlobalConstants.PermissionRelease.values();
		for (PermissionRelease permissionRelease : prs) {
			if(path.equals(permissionRelease.getUrl())&&permissionRelease.getType()==0){
				return false;
			}
		}
		return true;
	}

}
