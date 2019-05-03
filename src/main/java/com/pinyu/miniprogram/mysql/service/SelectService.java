package com.pinyu.miniprogram.mysql.service;

import java.util.List;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;
import com.pinyu.miniprogram.mysql.entity.member.MemberEntity;
import com.pinyu.miniprogram.web.page.Page;

 public interface SelectService<T extends BaseEntity> {

     List<T> selectAll();

    /**
     * 通过id查找
     * @param id
     * @return
     */
     T selectById(Long id);

    /**
     * 根据主键字段查询总数，方法参数必须包含完整的主键属性，查询条件使用等号,查询是否存在该id的记录
     * @param id
     * @return
     */
     boolean existsById(Long id);


    /**
     * 查询条数==》根据实体中的属性查询总数，查询条件使用等号
     * @param t
     * @return
     */
     int selectCount(T t);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param t
     * @return
     */
     List<T> select(T t);

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param t
     * @return
     */
     T selectOne(T t);

     /**
      * 按照实体属性分组（非id等唯一性属性）
      * @param t
      * @return
      */
    List<T> selectGroupBy(T t);
    
    /**
     * 分页
     * @param page
     * @return
     */
    Page<T> selectPage(Page<T> page);
}
