package com.zx.mapper;

import com.zx.model.Foodtype;
import com.zx.model.FoodtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodtypeMapper {
    int countByExample(FoodtypeExample example);

    int deleteByExample(FoodtypeExample example);

    int deleteByPrimaryKey(Integer ftid);

    int insert(Foodtype record);

    int insertSelective(Foodtype record);

    List<Foodtype> selectByExample(FoodtypeExample example);

    Foodtype selectByPrimaryKey(Integer ftid);

    int updateByExampleSelective(@Param("record") Foodtype record, @Param("example") FoodtypeExample example);

    int updateByExample(@Param("record") Foodtype record, @Param("example") FoodtypeExample example);

    int updateByPrimaryKeySelective(Foodtype record);

    int updateByPrimaryKey(Foodtype record);
}