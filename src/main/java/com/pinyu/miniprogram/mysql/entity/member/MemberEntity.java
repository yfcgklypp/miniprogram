package com.pinyu.miniprogram.mysql.entity.member;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data // getter、setter
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
@Table(name = "member")
public class MemberEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2601234073734313278L;
	@Column(name = "member_name")
	private String memberName;// 会员登录用户名

	@Column(name = "nick_name")
	private String nickName;// 昵称

	@Column(name = "tel")
	private String tel;// 电话

	@Column(name = "pwd")
	private String pwd;// 密码

	@Column(name = "head_img")
	private String headImg;// 头像图片

	@Column(name = "signature")
	private String signature;// 个性签名

	@Column(name = "status")
	private Integer status;// 状态 1禁用 2启用
	
	@Transient
	private String token;//token身份验证
}
