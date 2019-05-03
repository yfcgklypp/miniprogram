package com.pinyu.miniprogram.mysql.service.member;

import java.util.List;

import javax.jms.Destination;

import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;
import com.pinyu.miniprogram.mysql.service.BaseService;

/** 
* @author ypp
* 创建时间：2018年12月27日 上午10:10:14 
* @Description: TODO(用一句话描述该文件做什么) 
*/
public interface MemberService extends BaseService<MemberEntity>{
	
	List<MemberEntity> selectAll();

	MemberEntity findById(Long id);

	void sendMsg(Destination destination, String msg);

	void sendMessage(final String msg);
}
