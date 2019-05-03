package com.pinyu.miniprogram.global.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.pinyu.miniprogram.utils.Token;
import com.pinyu.miniprogram.utils.result.JsonMsg;

/** 
* @author ypp
* 创建时间：2018年10月15日 下午4:06:50 
* @Description: TODO(全局异常处理) 
*/
@ControllerAdvice
public class GlobalControllerAdvice implements ResponseBodyAdvice<Object>{
	
	protected static Logger log=LogManager.getLogger(GlobalControllerAdvice.class);

	/**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}
    
    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
//        model.addAttribute("author", "Magical Sam");
    }

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public String errorHandler(Exception ex) {
    	Throwable cause = ex.getCause();
    	if(cause instanceof AuthTokenException){
    		return Token.Error(cause.getMessage());
    	}
    	String sOut = ex.getClass().getName()+"\r\n";
    	StackTraceElement[] trace = ex.getStackTrace();
    	for (StackTraceElement s : trace) {
    		sOut += "\tat " + s + "\r\n";
    	}
        log.error(sOut);
        ex.printStackTrace();
        return JsonMsg.Error("服务器异常,请联系管理员");
    }

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter arg1, MediaType arg2,
			Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest arg4, ServerHttpResponse arg5) {
		//可以在此处进行返回数据全局处理，body就是返回数据，还没有经过@ResponseBody处理
		return body;
	}

	@Override
	public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
		return true;// 只有返回true才会继续执行
	}
}
