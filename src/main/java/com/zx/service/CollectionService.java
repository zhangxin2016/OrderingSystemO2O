package com.zx.service;

import com.zx.model.Collectionuser;

import java.util.List;

/**
 * Created by Xin on 2017/5/14.
 */
public interface CollectionService {
    Integer addCollection(Collectionuser collection);
    List<Collectionuser> findCollectionListByUid(Integer uid);
    List<Collectionuser> findCollectionStoresListByUid(Integer uid);
    Integer deleteCollectionFood(Collectionuser collection);
}
