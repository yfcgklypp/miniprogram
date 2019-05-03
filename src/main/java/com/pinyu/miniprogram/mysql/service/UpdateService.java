package com.pinyu.miniprogram.mysql.service;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;

public interface UpdateService<T extends BaseEntity> {
    /**
     * 根据主键更新实体全部字段，null值会被更新,不会使用数据库默认值
     * @param t
     * @return
     */
    public int updateById(T t);

    /**
     * 根据主键更新属性不为null的值
     * @param t
     * @return
     */
    public int updateByIdSelective(T t);

}
