package com.pinyu.miniprogram.mysql.service.member.impl;

import java.util.List;

import javax.jms.Destination;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;
import com.pinyu.miniprogram.mysql.mapper.member.MemberMapper;
import com.pinyu.miniprogram.mysql.service.BaseServiceImpl;
import com.pinyu.miniprogram.mysql.service.member.MemberService;
import com.pinyu.miniprogram.web.page.Page;

/**
 * @author ypp 创建时间：2018年12月27日 上午10:11:11
 * @Description: TODO(用一句话描述该文件做什么)
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
@CacheConfig(cacheNames = "member")
public class MemberServiceImpl extends BaseServiceImpl<MemberEntity> implements MemberService {

	@Autowired
	private MemberMapper mapper;
	@Autowired
	private JmsMessagingTemplate jmsTemplate;
	@Autowired
	private Queue queue;

	@Override
	public MemberEntity findById(Long id) {
		return super.selectById(id);
	}

	@Override
	public Page<MemberEntity> selectPage(Page<MemberEntity> page) {
		return super.selectPage(page);
	}

	@Override
	public void sendMsg(Destination destination, String msg) {
		jmsTemplate.convertAndSend(destination, msg);
	}

	@Override
	public void sendMessage(String msg) {
		jmsTemplate.convertAndSend(this.queue, msg);
	}

	@Override
	public List<MemberEntity> selectAll() {
		return super.selectAll();
	}

}
