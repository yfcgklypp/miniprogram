package com.pinyu.miniprogram.mysql.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author ypp 创建时间：2018年12月25日 下午1:32:18
 * @Description: TODO(用一句话描述该文件做什么)
 */
@Data // getter、setter
@AllArgsConstructor // 全参构造方法
@NoArgsConstructor // 无参构造方法
@Accessors(chain = true) // 链式编程写法
public class IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9089706482760436909L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@org.springframework.data.annotation.Id
	private Long id;

}
