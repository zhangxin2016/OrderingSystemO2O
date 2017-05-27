package com.zx.service;

import com.zx.model.Stores;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Xin on 2017/3/27.
 */
public interface StoresService {
    //根据IP地址获取店铺
    List<Stores> getStoresByAddress(String staddress);
    //根据商家获取店铺
    Stores getStoresByUsid(Integer usid);
    //新建店铺
    Integer addStores(Stores stores);
    //根据店铺ID获取店铺
    Stores getStoresByStid(Integer stid);
    //修改店铺信息
    Integer updateStorseByStid(Stores stores);
    //前台搜索店铺
    List<Stores> findStoresListByNameAndStid(Stores stores) throws Exception;
    //后台查询所有（分页）
    Map<String,Object> findAllStores(Integer currentPage, Integer lineSize, String keyWord)throws Exception ;

    Stores findStoresByStid(Integer stid) throws Exception;

    //根据IP地址查看店铺信息 (stcoll 排序)
    List<Stores> findStoresByAddressOrderByUcollDesc(String staddress);
    //注销店铺
    Integer deleteStoresByUserSell(Stores stores);

}
