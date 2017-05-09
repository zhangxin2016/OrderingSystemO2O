package com.zx.service;

import com.zx.model.Storestype;
import com.zx.model.StorestypeExample;

import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/3/27.
 */
public interface StorestypeService {

    /**
     * 分页查询
     * @param currentPage 当前页
     * @param lineSize  每页显示的数据量
     * @param keyWord   查询关键词
     * @return 分页信息PageInfo和数据集合java.util.List<Student>
     * @throws Exception 异常直接抛出,交给控制层处理
     */
    Map<String,Object> findAll(Integer currentPage, Integer lineSize, String keyWord)throws Exception ;
    //添加店铺类型
    int insert(Storestype storestype);
    //删除店铺类型
    int deleteByPrimaryKey(Integer stypeid);
    //修改店铺类型
    int updateByPrimaryKey(Storestype storestype);
    //根据ID获取需要修改的店铺类别
    Storestype selectByPrimaryKey(Integer id);
    List<Storestype> findAllStorestype();
}
