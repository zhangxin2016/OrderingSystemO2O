package com.zx.mapper;

import com.zx.model.Collectionuser;
import com.zx.model.CollectionuserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollectionuserMapper {
    int countByExample(CollectionuserExample example);

    int deleteByExample(CollectionuserExample example);

    int deleteByPrimaryKey(Integer collid);

    int insert(Collectionuser record);

    int insertSelective(Collectionuser record);

    List<Collectionuser> selectByExample(CollectionuserExample example);

    Collectionuser selectByPrimaryKey(Integer collid);

    int updateByExampleSelective(@Param("record") Collectionuser record, @Param("example") CollectionuserExample example);

    int updateByExample(@Param("record") Collectionuser record, @Param("example") CollectionuserExample example);

    int updateByPrimaryKeySelective(Collectionuser record);

    int updateByPrimaryKey(Collectionuser record);

    List<Collectionuser> findCollectionListByUid(Integer uid);

    List<Collectionuser> findCollectionStoresListByUid(Integer uid);
}