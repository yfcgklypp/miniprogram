package com.pinyu.miniprogram.utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.pinyu.miniprogram.config.redis.RedisUtils;
import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;
import com.pinyu.miniprogram.utils.date.DateUtils;
import com.pinyu.miniprogram.utils.result.Code;
import com.pinyu.miniprogram.utils.result.JsonMsg;
import com.pinyu.miniprogram.utils.rsa.RSAUtils;

@Component
public class Token {
	
	private final static String TOKEN_ERROR = "error";

	public final static Integer TOKEN_ERROR_CODE = -1;
	
	public static final String TOKEN_VALIDA_NULL="token为空";
    public static final String TOKEN_VALIDA_ERROR="token验证错误";
    public static final String TOKEN_VALIDA_FAIL="token验证失败";

	public static String Error(String msg) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", TOKEN_ERROR_CODE);
		map.put("msg", msg);
		return JSONObject.toJSONStringWithDateFormat(map, DateUtils.YYYY_MM_DD_HH_MM_SS,
				SerializerFeature.WriteMapNullValue);
	}
	
	public static final String MEMBER_TOKEN = "MEMBER_TOKEN";

	@Autowired
	private RedisUtils redisUtils;

	// 生成token前的格式为token:id:时间:六位随机数
	public String generateToken(Long id) throws Exception{
        StringBuilder tokenBuilder = new StringBuilder();
        //生成未加密的token:
        tokenBuilder.append("token:")
        					.append(id).append(":")
        					.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+":")
        					.append(new Random().nextInt((999999 - 111111 + 1)) + 111111);
        //RSA加密的用户id，私钥加密，公钥解密，用于登录之后解析id再次进行加密
        String token=(RSAUtils.privateEncrypt(tokenBuilder.toString(), RSAUtils.getPrivateKey(RSAUtils.privateKey)));
        System.out.println("token=>" + token.toString());
        return token.toString();
    }

	public String saveToken(MemberEntity member) throws Exception {
		String token = generateToken(member.getId());
		redisUtils.zsetAdd(MEMBER_TOKEN, token, Double.valueOf(System.currentTimeMillis()));// 设置zset用于线程根据分数定时清理不活跃用户
		redisUtils.set(token, member, 60 * 60 * 24 * 30L);// 存储相关用户信息(权限等信息)
		redisUtils.set(String.valueOf(member.getId()), token);// 用于重新登录，但之前token还存在的情况,通过id获取相应的token来进行之前的token清理
		return token;
	}

	public void delToken(MemberEntity member) {
		Object object = redisUtils.get(String.valueOf(member.getId()));
		if (object != null) {
			String token = (String) object;
			redisUtils.del(token);// 移除token以及相对应的权限信息
			redisUtils.del(String.valueOf(member.getId()));// 移除token
			redisUtils.remove(MEMBER_TOKEN, token);// 移除zset排行的token，避免一个用户重复排行
		}
	}
}
