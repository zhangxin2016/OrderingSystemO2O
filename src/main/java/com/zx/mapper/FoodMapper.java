package com.zx.mapper;

import com.zx.model.Food;
import com.zx.model.FoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodMapper {
    int countByExample(FoodExample example);

    int deleteByExample(FoodExample example);

    int deleteByPrimaryKey(Integer fid);

    int insert(Food record);

    int insertSelective(Food record);

    List<Food> selectByExample(FoodExample example);

    Food findFoodById(Integer fid);

    int updateByExampleSelective(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByExample(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);

    List<Food> findAll(String keyWord)throws Exception ;   //复杂查询

    //根据店铺ID获取食品销售数量
    List<Food> findAllBySalesvolume(Integer stid) throws Exception;
    //根据店铺ID获取食品收藏数
    List<Food> findAllByCollection(Integer stid) throws Exception;

    List<Food> findAllByStid(Integer stid) throws Exception;
}