package com.zx.service.impl;

import com.zx.mapper.CollectionuserMapper;
import com.zx.model.Collectionuser;
import com.zx.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Xin on 2017/5/14.
 */
@Service
public class CollectionServiceImpl implements CollectionService{
    @Autowired
    private CollectionuserMapper collectionMapper;
    @Override
    public Integer addCollection(Collectionuser collection) {
        return collectionMapper.insertSelective(collection);
    }

    @Override
    public List<Collectionuser> findCollectionListByUid(Integer uid) {
        return collectionMapper.findCollectionListByUid(uid);
    }

    @Override
    public List<Collectionuser> findCollectionStoresListByUid(Integer uid) {
        return collectionMapper.findCollectionStoresListByUid(uid);
    }

    @Override
    public Integer deleteCollectionFood(Collectionuser collection) {
        return collectionMapper.updateByPrimaryKeySelective(collection);
    }
}
