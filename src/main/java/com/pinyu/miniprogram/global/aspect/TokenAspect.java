package com.pinyu.miniprogram.global.aspect;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pinyu.miniprogram.config.SpringBeanTool;
import com.pinyu.miniprogram.config.redis.RedisUtils;
import com.pinyu.miniprogram.global.exception.AuthTokenException;
import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;
import com.pinyu.miniprogram.utils.RequestUtils;
import com.pinyu.miniprogram.utils.Token;

@Aspect
@Component("tokenAspect")
public class TokenAspect {

	@Resource
	private MappingJackson2HttpMessageConverter converter;
	@Autowired
	private SpringBeanTool springBeanTool;
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private Token token;

	private static final Logger log = LoggerFactory.getLogger(TokenAspect.class);

	// 配置织入点
	@Pointcut("@annotation(com.pinyu.miniprogram.global.ann.RequireToken)")
	public void pointCut() {
	}

	/**
	 * 拦截token
	 * 
	 * @param joinPoint
	 * @param e
	 * @throws IOException
	 * @throws HttpMessageNotWritableException
	 */
	@Before(value = "pointCut()")
	public void doBefore(JoinPoint joinPoint) throws Exception {
		handleLog(joinPoint);
	}

	private void handleLog(JoinPoint joinPoint) throws Exception {
		HttpServletResponse response = springBeanTool.getResponse();
		HttpServletRequest request = springBeanTool.getRequest();
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);

		String requestToken = RequestUtils.getHeader(request, "token");
		if (StringUtils.isBlank(requestToken)) {
			// 可以使用以下方式返回json数据
			// converter.write(JsonMsg.Error(Code.TOKEN_VALIDA_NULL),MediaType.APPLICATION_JSON, outputMessage);
			// shutdownResponse(response);
			// 不要用，用了这个在controller@responseBody无效，输出流关闭了
			throw new AuthTokenException(Token.TOKEN_VALIDA_NULL);
		}
		Double score = redisUtils.score(Token.MEMBER_TOKEN, requestToken);
		if (score == null) {
			// 终止继续往下面走，另外全局异常捕获AuthTokenException并给前端code码和提示
			throw new AuthTokenException(Token.TOKEN_VALIDA_FAIL);
		}
		// 获取redis已有的member信息，不查数据库,重新生成token放入
		MemberEntity member = (MemberEntity) redisUtils.get(requestToken);
		// 移除之前的token（包含member信息、token排行信息）
		token.delToken(member);
		String saveToken = token.saveToken(member);
		response.setHeader("Access-Control-Expose-Headers",
				"Cache-Control,Content-Type,Expires,Pragma,Content-Language,Last-Modified,token");
		response.setHeader("token", saveToken); // 设置响应头
	}
	
	private void shutdownResponse(HttpServletResponse response) throws IOException {
		response.getOutputStream().close();
	}

}
