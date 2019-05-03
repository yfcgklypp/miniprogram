package com.pinyu.miniprogram.mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;
import com.pinyu.miniprogram.mysql.mappers.BaseMapper;
import com.pinyu.miniprogram.web.page.Page;

import tk.mybatis.mapper.entity.Example;

@Service
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	@Autowired
	private BaseMapper<T> baseMapper;

	@Override
	public List<T> selectAll() {
		return baseMapper.selectAll();
	}

	@Override
	public T selectById(Long id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	@Override
	public boolean existsById(Long id) {
		return baseMapper.existsWithPrimaryKey(id);
	}

	@Override
	public int selectCount(T t) {
		return baseMapper.selectCount(t);
	}

	@Override
	public List select(T t) {
		return baseMapper.select(t);
	}

	@Override
	public T selectOne(T t) {
		return baseMapper.selectOne(t);
	}

	@Override
	public int deleteById(Long id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int delete(T t) {
		return baseMapper.delete(t);
	}

	@Override
	public int insert(T t) {
		return baseMapper.insert(t);
	}

	@Override
	public int insertSelective(T t) {
		return baseMapper.insertSelective(t);
	}

	@Override
	public int updateById(T t) {
		return baseMapper.updateByPrimaryKey(t);
	}

	@Override
	public int updateByIdSelective(T t) {
		return baseMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public List<T> selectGroupBy(T t) {
		Example example = new Example(t.getClass());
		Example.Criteria criteria = example.createCriteria();
		return null;
	}

	@Override
	public Page<T> selectPage(Page<T> page) {
		int count = this.selectCount(page.getEntity());
		List<T> list = baseMapper.selectPage(page.getEntity(), page.getIndex(), page.getPageSize());
		return new Page<T>(list, count, page.getCurrentPage());
	}
}
