package com.zx.mapper;

import com.zx.model.Address;
import com.zx.model.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    int countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer adid);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer adid);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> getuid(Integer uid);
}