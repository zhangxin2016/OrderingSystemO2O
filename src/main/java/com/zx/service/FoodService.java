package com.zx.service;

import com.zx.model.Food;

import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/3/27.
 */
public interface FoodService {
    //获取所有菜品
    Map<String,Object> getAllFood(Integer currentPage, Integer lineSize, String keyWord) throws Exception;
    //根据店铺ID获取食品销售数量前三名（根据IP地址）
    //首页滚动条
    List<Food> findAllBySalesvolume(Integer stid) throws Exception;
    //根据店铺ID获取食品收藏数前三名（根据IP地址）
    //首页下方食品推荐
    List<Food> findAllByCollection(Integer stid) throws Exception;
    //根据店铺ID获取食品
    List<Food> findAllByStid(Integer stid) throws Exception;
    //根据食物ID获取食物详细信息
    Food  findFoodById(Integer id) throws Exception;
    //修改食物信息
    void updateFood(Integer id,Food food) throws Exception;
}