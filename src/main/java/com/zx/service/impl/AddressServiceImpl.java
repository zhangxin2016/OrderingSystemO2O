package com.zx.service.impl;

import com.zx.mapper.AddressMapper;
import com.zx.model.Address;
import com.zx.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Xin on 2017/5/1.
 */
@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressMapper addressMapper;
    @Override
    public List<Address> getuid(int uid) {
        return addressMapper.getuid(uid);
    }

    @Override
    public void add(Address address) {
        addressMapper.insertSelective(address);
    }

    @Override
    public void delete(Address address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public void update(Address address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public Address getadid(int adid) {
        return addressMapper.selectByPrimaryKey(adid);
    }
}
