package com.pinyu.miniprogram.web.controller.member;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pinyu.miniprogram.config.redis.RedisUtils;
import com.pinyu.miniprogram.global.ann.RequireToken;
import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;
import com.pinyu.miniprogram.mysql.service.member.MemberService;
import com.pinyu.miniprogram.utils.MD5Utils;
import com.pinyu.miniprogram.utils.Token;
import com.pinyu.miniprogram.utils.result.JsonMsg;
import com.pinyu.miniprogram.web.controller.BaseController;
import com.pinyu.miniprogram.web.page.Page;

/**
 * @author ypp 创建时间：2018年12月27日 上午10:00:39
 * @Description: TODO(用一句话描述该文件做什么)
 */
@RestController
@RequestMapping("/member")
public class MemberController extends BaseController<MemberEntity> {

	private Logger logger = LogManager.getLogger(MemberController.class);
	@Autowired
	private MemberService service;
	@Autowired
	private RedisUtils redisUtils;
	@Autowired
	private Token token;

	@RequestMapping("/info-{id}")
	public String idInfo(@PathVariable("id") Long id) {
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setId(6L);
		memberEntity.setNickName("哇哈哈矿泉水");
		redisUtils.set("aa", memberEntity);
		return JsonMsg.OK();
	}

	@RequestMapping("/login")
	public String login(@RequestBody Map<String, String> logMap) throws Exception {
		String memberName = logMap.get("memberName");
		String pwd = logMap.get("pwd");
		MemberEntity m = new MemberEntity();
		m.setMemberName(memberName);
		pwd = MD5Utils.convertMD5(MD5Utils.md5(pwd));
		m.setPwd(pwd);
		List<MemberEntity> list = service.select(m);
		if (list != null && list.size() > 0) {
			MemberEntity member = list.get(0);
			token.delToken(member);//清除之前redis有的token信息
			String memberToken = token.saveToken(member);//重新生成token
			return JsonMsg.OK(memberToken);
		} else {
			return JsonMsg.OK("用户名或密码错误");
		}
	}

	@RequestMapping("/add")
	@RequireToken
	public String add() {
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setNickName("哇哈哈矿泉水");
		memberEntity.setCreateDate(new Date());
		memberEntity.setHeadImg("E/dasdaskjdnakj");
		memberEntity.setMemberName("ypp");
		memberEntity.setStatus(1);
		memberEntity.setSignature("无个性,不签名!");
		memberEntity.setDeleteState(1);
		try {
			memberEntity.setPwd(MD5Utils.convertMD5(MD5Utils.md5("123456")));
		} catch (Exception e) {
			logger.error("密码加密失败");
			e.printStackTrace();
		}
		service.insert(memberEntity);
		return JsonMsg.OK();
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") Long id,@RequestParam("nickName") String nickName) {
		MemberEntity member = service.findById(id);
		member.setNickName(nickName);
		service.updateByIdSelective(member);
		try {
			token.delToken(member);//清除之前redis有的token信息
			token.saveToken(member);//重新生成token并缓存新的member信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		return JsonMsg.OK();
	}

	@RequestMapping("/findById-{id}")
	@RequireToken
	public String findById(@PathVariable("id") Long id) {
		return JsonMsg.OK(service.findById(id));
	}

	@RequestMapping("/cach-{id}")
	public String cach(@PathVariable("id") Integer id) {
		return JsonMsg.OK(redisUtils.get("adcd"));
	}

	@RequestMapping("/all")
	public String all() {
		return JsonMsg.OK(service.selectAll());
	}

	@RequestMapping("/selectPage/{page}/{pageSize}")
	public String selectPage(@PathVariable("page") int page, @PathVariable("pageSize") int pageSize) {
		Page<MemberEntity> p = new Page<MemberEntity>();
		if (p.getEntity() == null) {
			p.setEntity(new MemberEntity());
		}
		p.setPageSize(pageSize);
		p.setCurrentPage(page);
		return JsonMsg.OK(service.selectPage(p));
	}

	// @RequestMapping("/msg")
	// public String msg(@RequestBody MemberEntity memberEntity){
	//// Destination destination = new ActiveMQQueue("queue01");
	// service.sendMessage(memberEntity.getNickName());
	// return JsonMsg.OK();
	// }

}
