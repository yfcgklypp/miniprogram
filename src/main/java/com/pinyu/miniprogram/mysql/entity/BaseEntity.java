package com.pinyu.miniprogram.mysql.entity;

import java.util.Date;

import javax.persistence.Column;

import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ypp 创建时间：2018年12月25日 下午1:32:28
 * @Description: TODO(用一句话描述该文件做什么)
 */
@Data // getter、setter
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
public class BaseEntity extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8575696766261326260L;

	@Column(name="creat_id")
	private Integer creatId;

	@Column(name="create_date")
	private Date createDate;

	@Column(name="delete_state")
	private Integer deleteState;// 删除状态 1正常 2已删除

}
