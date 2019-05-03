package com.pinyu.miniprogram.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* @author ypp
* 创建时间：2018年12月26日 下午5:23:04 
* @Description: TODO(用一句话描述该文件做什么) 
*/
@Controller
@RequestMapping("/")
public class IndexController{

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
