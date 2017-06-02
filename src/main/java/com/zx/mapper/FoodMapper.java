package com.zx.mapper;

import com.zx.chart.FoodChart;
import com.zx.model.Food;
import com.zx.model.FoodExample;
import java.util.List;

import com.zx.util.Page;
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
    //根据店铺ID获取菜品
    List<Food> findAllByStid(Integer stid) throws Exception;
    //根据店铺ID获取菜品数量
    Integer findFoodCountByStid(Integer stid) throws Exception;
    //根据店铺ID获取菜品(分页)
    List<Food> findFoodByStid(Page page) throws Exception;
    //删除商品
    int deleteFoodByFid(Integer fid) throws Exception;
    //前台搜索菜品根据名字
    List<Food> findFoodListByNameAndStid(Food food)throws Exception;

    //根据地区获取所有菜品
    List<Food> findFoodByStores(Page page) throws Exception;
    Integer findFoodByStoresCount(String staddress);
    Food findStoresByFood(Integer fid);

    List<FoodChart> chartByFood();
    //根据图片获取所有菜品
    List<Food> findFoodByFpic(String fpic) throws Exception;
}