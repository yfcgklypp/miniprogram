package com.pinyu.miniprogram.mysql.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author ypp 创建时间：2018年12月27日 下午1:29:03
 * @Description: TODO(用一句话描述该文件做什么)
 */
public interface BaseMapper<T extends BaseEntity> extends Mapper<T>, MySqlMapper<T> {

	/**
	 * * 单表分页查询 * * @param object * @param offset * @param limit * @return 
	 * slect * from table limit 4 offset 9 和select * from table limit 9,4 同理
	 */
	@SelectProvider(type = BaseMapperProvider.class, method = "dynamicSQL")
	List selectPage(@Param("entity") T t, @Param("index") int index,@Param("pageSize") int pageSize);
}
