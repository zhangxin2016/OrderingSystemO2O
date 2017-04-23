package com.zx.service.impl;

import com.zx.mapper.UserSellMapper;
import com.zx.model.UserSell;
import com.zx.service.UserSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Xin on 2017/4/11.
 */
@Service
public class UserSellServiceImpl implements UserSellService {
    @Autowired
    private UserSellMapper userMapper;
    @Override
    public UserSell getUserByNameAndPass(UserSell user) {
        return userMapper.getUserByNameAndPass(user);
    }

    @Override
    public int register(UserSell user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public UserSell checkRegister(String name) {
        return userMapper.checkRegister(name);
    }
}
