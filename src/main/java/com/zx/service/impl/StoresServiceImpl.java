package com.zx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.mapper.StoresMapper;
import com.zx.model.Stores;
import com.zx.model.Storestype;
import com.zx.service.StoresService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/3/27.
 */
@Service
public class StoresServiceImpl implements StoresService {

    @Autowired
    private StoresMapper storesMapper;
    @Override
    public List<Stores> getStoresByAddress(String staddress) {
        return storesMapper.selectStoresByAddress(staddress);
    }

    @Override
    public Stores getStoresByUsid(Integer usid) {
        return storesMapper.selectStoresByUsid(usid);
    }

    @Override
    public Integer addStores(Stores stores) {
        return storesMapper.insertSelective(stores);
    }

    @Override
    public Stores getStoresByStid(Integer stid) {
        return storesMapper.selectByPrimaryKey(stid);
    }

    @Override
    public Integer updateStorseByStid(Stores stores) {
        return storesMapper.updateByPrimaryKeySelective(stores);
    }

    @Override
    public List<Stores> findStoresListByNameAndStid(Stores stores) throws Exception {
        return storesMapper.findStoresListByNameAndStid(stores);
    }

    @Override
    public Map<String, Object> findAllStores(Integer currentPage, Integer lineSize, String keyWord) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>()   ;    //map集合保存分页信息和数据
        PageHelper.startPage(currentPage, lineSize)           ;     //设置分页参数
        if("".equals(keyWord) || keyWord==null){    //组织关键词
            keyWord="%"+keyWord+"%"  ;
        }else{
            keyWord="%"+keyWord+"%" ;
        }
        List<Stores> stores=this.storesMapper.findAllStores(keyWord) ;   //模糊查询
        PageInfo<Stores> pageInfo=new PageInfo<Stores>(stores) ; //获取分页信息
        map.put("stores", stores)   ;
        map.put("pageInfo", pageInfo)   ;
        return map;
    }

    @Override
    public Stores findStoresByStid(Integer stid) throws Exception {
        return storesMapper.findStoresByStid(stid);
    }

    @Override
    public List<Stores> findStoresByAddressOrderByUcollDesc(String staddress) {
        return storesMapper.selectStoresByAddressOrderByUcollDesc(staddress);
    }

    @Override
    public Integer deleteStoresByUserSell(Stores stores) {
        return storesMapper.updateByPrimaryKeySelective(stores);
    }

}
