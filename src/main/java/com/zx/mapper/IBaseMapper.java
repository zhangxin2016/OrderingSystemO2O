package com.zx.mapper;

import java.io.Serializable;

/**
 * Created by Xin on 2017/4/6.
 */
public interface IBaseMapper<T,E> extends Serializable {

    Integer doCreate(E entity)throws Exception;       //增加

    Integer doUpdate(E entity)throws Exception;       //修改

    Integer doRemove(T id)throws Exception;      //根据ID删除

    E findById(T id)throws Exception;           //根据ID查找
}
