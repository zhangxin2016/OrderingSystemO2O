package com.zx.service;

import com.zx.model.Address;

import java.util.List;

/**
 * Created by Xin on 2017/5/1.
 */
public interface AddressService {
    //根据用户获取地址列表
    List<Address> getuid(int uid);
    //收货地址的增加
    void add(Address address);
    //删除地址
    void delete(Address address);
    //修改地址
    void update(Address address);
    //地址id 收货地址查询
    Address getadid(int adid);
}
