package com.zx.service.impl;

import com.zx.mapper.StoresMapper;
import com.zx.model.Stores;
import com.zx.service.StoresService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
