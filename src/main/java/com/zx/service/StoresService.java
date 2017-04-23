package com.zx.service;

import com.zx.model.Stores;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Xin on 2017/3/27.
 */
public interface StoresService {

    List<Stores> getStoresByAddress(String staddress);
}
