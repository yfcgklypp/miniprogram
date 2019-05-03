package com.pinyu.miniprogram.config.redis;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * @author ypp 创建时间：2018年12月11日 上午10:03:52
 * @Description: TODO(用一句话描述该文件做什么)
 */
public class RedisPropertiesUtils {

	private static Properties redisProperties;

	static {
		try {
			ClassPathResource classPathResource = new ClassPathResource("redis.properties");
			redisProperties = PropertiesLoaderUtils.loadProperties(classPathResource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getHostName() {
		return redisProperties.getProperty("redis.hostName");
	}

	public static int getPort() {
		return Integer.valueOf(redisProperties.getProperty("redis.port"));
	}

	public static String getPassword() {
		return redisProperties.getProperty("redis.password");
	}

	public static int getTimeout() {
		return Integer.valueOf(redisProperties.getProperty("redis.timeout"));
	}

	public static int getMaxIdle() {
		return Integer.valueOf(redisProperties.getProperty("redis.maxIdle"));
	}

	public static int getMinIdle() {
		return Integer.valueOf(redisProperties.getProperty("redis.minIdle"));
	}

	public static String getMaxActive() {
		return redisProperties.getProperty("redis.maxActive");
	}

	public static int getMaxTotal() {
		return Integer.valueOf(redisProperties.getProperty("redis.maxTotal"));
	}

	public static long getMaxWaitMillis() {
		return Long.valueOf(redisProperties.getProperty("redis.maxWaitMillis")).longValue();
	}

	public static long getMinEvictableIdleTimeMillis() {
		return Long.valueOf(redisProperties.getProperty("redis.minEvictableIdleTimeMillis")).longValue();
	}

	public static int getNumTestsPerEvictionRun() {
		return Integer.valueOf(redisProperties.getProperty("redis.numTestsPerEvictionRun"));
	}

	public static long getTimeBetweenEvictionRunsMillis() {
		return Long.valueOf(redisProperties.getProperty("redis.timeBetweenEvictionRunsMillis")).longValue();
	}

	public static boolean getTestOnBorrow() {
		return new Boolean(redisProperties.getProperty("redis.testOnBorrow"));
	}

	public static boolean getTestWhileIdle() {
		return new Boolean(redisProperties.getProperty("redis.testWhileIdle"));
	}

	public static String getClusterNodes() {
		return redisProperties.getProperty("redis.cluster.nodes");
	}

	public static String getClusterMaxRedirects() {
		return redisProperties.getProperty("redis.cluster.max-redirects");
	}

	public static String getSentinelHost1() {
		return redisProperties.getProperty("redis.sentinel.host1");
	}

	public static String getSentinelPort1() {
		return redisProperties.getProperty("redis.sentinel.port1");
	}

	public static String getSentinelHost2() {
		return redisProperties.getProperty("redis.sentinel.host2");
	}

	public static String getSentinelPort2() {
		return redisProperties.getProperty("redis.sentinel.port2");
	}
}
