package com.zx.mapper;

import com.zx.model.Stores;
import com.zx.model.StoresExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoresMapper {
    int countByExample(StoresExample example);

    int deleteByExample(StoresExample example);

    int deleteByPrimaryKey(Integer stid);

    int insert(Stores record);

    int insertSelective(Stores record);

    List<Stores> selectByExample(StoresExample example);

    Stores selectByPrimaryKey(Integer stid);

    int updateByExampleSelective(@Param("record") Stores record, @Param("example") StoresExample example);

    int updateByExample(@Param("record") Stores record, @Param("example") StoresExample example);

    int updateByPrimaryKeySelective(Stores record);

    int updateByPrimaryKey(Stores record);

    //根据IP地址查看店铺信息
    List<Stores> selectStoresByAddress(String staddress);
    //根据商家Id获取店铺
    Stores selectStoresByUsid(Integer usid);
}