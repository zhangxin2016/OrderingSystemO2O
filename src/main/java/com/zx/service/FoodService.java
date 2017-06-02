package com.zx.service;

import com.zx.model.Food;
import com.zx.util.Page;

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
    //添加店铺
    Integer addFood(Food food);
    //根据店铺ID获取菜品数量
    Integer findFoodCountByStid(Integer stid) throws Exception;
    //根据店铺ID获取食品(分页)
    List<Food> findFoodByStid(Page page) throws Exception;
    //Map<String,Object> findFoodByStid(Integer currentPage, Integer lineSize, Integer stid)throws Exception ;
    //商家删除菜品
    Integer deleteFoodByFid(Integer fid) throws Exception;
    //前台搜索菜品
    List<Food> findFoodListByNameAndStid(Food food) throws Exception;
    //根据地区获取所有菜品
    List<Food> findFoodByStores(Page page) throws Exception;
    Integer findFoodByStoresCount(String staddress);
    Food findStoresByFood(Integer fid) throws Exception;

    List<Food> findFoodByFpic(String fpic) throws Exception;
}
