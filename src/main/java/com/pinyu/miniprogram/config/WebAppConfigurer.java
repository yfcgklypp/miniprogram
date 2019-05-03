package com.pinyu.miniprogram.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pinyu.miniprogram.global.interceptor.LoginInterceptor;

/**
 * @author ypp 
 * 继承WebMvcConfigurerAdapter或实现WebMvcConfigurer无需对静态资源处理
 * WebMvcConfigurationSupport静态资源无效，需要额外配置，形式完全控制的MVC模式,非自动化配置
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*");
                //跨域允许时间
//                .maxAge(3600);
    }
	
//	@Bean
//    public HttpMessageConverter responseBodyConverter(){
//		//解决返回值中文乱码，除非返回值出现乱码情况，不然别设置，设置了以后@RequestBody绑定json参数会报错：Content type 'application/json;charset=UTF-8' not supported   需进一步处理
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        return converter;
//    }
//	
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(responseBodyConverter());
//	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 可添加多个，这里选择拦截所有请求地址
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
//	/**静态资源处理 继承WebMvcConfigurationSupport需要重写配置静态资源*/
//	@Override
//    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//	}
	/**复写spring 默认的jackjson改为fastjson，JsonMsg输入已更改，此配置不需要*/
//	@Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.DisableCircularReferenceDetect,
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteNullStringAsEmpty,
//                SerializerFeature.PrettyFormat
//        );
//        fastJsonConfig.setDateFormat(DateUtils.YYYY_MM_DD_HH_MM_SS);
//        List<MediaType> fastMediaType = new ArrayList<>();
//        fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
//
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaType);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastJsonHttpMessageConverter);
//    }
}
