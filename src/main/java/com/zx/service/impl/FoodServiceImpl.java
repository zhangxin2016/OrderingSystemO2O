package com.zx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.mapper.FoodMapper;
import com.zx.model.Food;
import com.zx.service.FoodService;
import com.zx.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/3/27.
 */
@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;
    @Transactional
    public Map<String,Object> getAllFood(Integer currentPage, Integer lineSize,
                                 String keyWord) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();    //map集合保存分页信息和数据
        PageHelper.startPage(currentPage, lineSize);     //设置分页参数
        if("".equals(keyWord) || keyWord==null){    //组织关键词
            keyWord="%"+keyWord+"%";
        }else{
            keyWord="%"+keyWord+"%";
        }
        List<Food> foods=this.foodMapper.findAll(keyWord);   //模糊查询
        PageInfo<Food> pageInfo=new PageInfo<Food>(foods); //获取分页信息
        map.put("foods", foods);
        map.put("pageInfo", pageInfo);
        return map;
    }

    @Override
    public List<Food> findAllBySalesvolume(Integer stid) throws Exception {
        return foodMapper.findAllBySalesvolume(stid);
    }

    @Override
    public List<Food> findAllByCollection(Integer stid) throws Exception {
        return foodMapper.findAllByCollection(stid);
    }

    @Override
    public List<Food> findAllByStid(Integer stid) throws Exception {
        return foodMapper.findAllByStid(stid);
    }

    @Override
    public Food findFoodById(Integer id) throws Exception {
        return foodMapper.findFoodById(id);
    }

    @Override
    public void updateFood(Integer id, Food food) throws Exception {
        foodMapper.updateByPrimaryKeySelective(food);
    }

    @Override
    public Integer addFood(Food food) {
        return foodMapper.insertSelective(food);
    }

    @Override
    public Integer findFoodCountByStid(Integer stid) throws Exception {
        return foodMapper.findFoodCountByStid(stid);
    }

    @Override
    public List<Food> findFoodByStid(Page page) throws Exception {
        return foodMapper.findFoodByStid(page);
    }


    @Override
    public Integer deleteFoodByFid(Integer fid) throws Exception {
        return foodMapper.deleteFoodByFid(fid);
    }

    @Override
    public List<Food> findFoodListByNameAndStid(Food food) throws Exception {
        return foodMapper.findFoodListByNameAndStid(food);
    }


    @Override
    public List<Food> findFoodByStores(Page page) throws Exception {
        return foodMapper.findFoodByStores(page);
    }

    @Override
    public Integer findFoodByStoresCount(String staddress) {
        return foodMapper.findFoodByStoresCount(staddress);
    }

    @Override
    public Food findStoresByFood(Integer fid) throws Exception {
        return foodMapper.findStoresByFood(fid);
    }

    @Override
    public List<Food> findFoodByFpic(String fpic) throws Exception {
        return foodMapper.findFoodByFpic(fpic);
    }


}
