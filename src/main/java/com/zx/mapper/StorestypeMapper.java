package com.zx.mapper;

import com.zx.model.Storestype;
import com.zx.model.StorestypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StorestypeMapper{
    int countByExample(StorestypeExample example);

    int deleteByExample(StorestypeExample example);

    int deleteByPrimaryKey(Integer stypeid);

    int insert(Storestype record);

    int insertSelective(Storestype record);

    List<Storestype> selectByExample(StorestypeExample example);

    Storestype selectByPrimaryKey(Integer stypeid);

    int updateByExampleSelective(@Param("record") Storestype record, @Param("example") StorestypeExample example);

    int updateByExample(@Param("record") Storestype record, @Param("example") StorestypeExample example);

    int updateByPrimaryKeySelective(Storestype storestype);

    int updateByPrimaryKey(Storestype storestype);

    List<Storestype> findAll(String keyWord)throws Exception;   //复杂查询
}