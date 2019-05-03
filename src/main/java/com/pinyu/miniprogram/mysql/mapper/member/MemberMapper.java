package com.pinyu.miniprogram.mysql.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;
import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;
import com.pinyu.miniprogram.mysql.mappers.BaseMapper;

import tk.mybatis.mapper.common.Mapper;

public interface MemberMapper extends BaseMapper<MemberEntity>{

	List<MemberEntity> findAll();

	boolean add(MemberEntity memberEntity);

	MemberEntity findById(Long id);

	MemberEntity findByMemberName(@Param("memberName")String memberName);

}
