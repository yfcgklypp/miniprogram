package com.pinyu.miniprogram.mysql.service;

import com.pinyu.miniprogram.mysql.entity.BaseEntity;

public interface BaseService<T extends BaseEntity>
        extends InsertService<T>,
        UpdateService<T>,
        DeleteService<T>,
        SelectService<T> {

//    @Override
//    public int deleteByExample(Object example) {
//        return 0;
//    }
//
//    @Override
//    public List selectByExample(Object example) {
//        return null;
//    }
//
//    @Override
//    public int selectCountByExample(Object example) {
//        return 0;
//    }
//
//    @Override
//    public Object selectOneByExample(Object example) {
//        return null;
//    }
//
//    @Override
//    public int updateByExample(Object record, Object example) {
//        return 0;
//    }
//
//    @Override
//    public int updateByExampleSelective(Object record, Object example) {
//        return 0;
//    }
//
//    @Override
//    public List selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
//        return null;
//    }
//
//    @Override
//    public List selectByRowBounds(Object record, RowBounds rowBounds) {
//        return null;
//    }
}
