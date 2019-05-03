package com.pinyu.miniprogram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJms
@EnableTransactionManagement
// @SpringBootApplication(exclude={
// DataSourceAutoConfiguration.class,
//// HibernateJpaAutoConfiguration.class, //（如果使用Hibernate时，需要加）
// DataSourceTransactionManagerAutoConfiguration.class
// })
@SpringBootApplication
@ServletComponentScan // 使用servlet
@MapperScan("com.pinyu.miniprogram.mysql.mapper")
@EnableCaching//开启本地缓存
public class Application {

	public static void main(String[] args) {
		System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(Application.class, args);
	}

}
