package com.zx.service;

import com.zx.model.Stores;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

}
