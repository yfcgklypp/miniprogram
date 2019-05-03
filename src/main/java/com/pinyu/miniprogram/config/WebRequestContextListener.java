package com.pinyu.miniprogram.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author ypp 创建时间：2018年10月17日 上午10:23:56
 * @Description: TODO(用一句话描述该文件做什么)
 */
@WebListener
public class WebRequestContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
