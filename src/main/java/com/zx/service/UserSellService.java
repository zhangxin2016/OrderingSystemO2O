package com.zx.service;

import com.zx.model.UserSell;

import java.util.Map;

/**
 * Created by Xin on 2017/4/11.
 */
public interface UserSellService {
    /**
     * @title :getUserByNameAndPass
     * @description :用户登录验证实现类
     */
    UserSell getUserByNameAndPass(UserSell user);

    /**
     * @title :register
     * @description :接口方法实现类，进行用户信息录入
     */
    int register(UserSell user);

    /**
     * @title :checkRegister
     * @description :验证用户是否存在，防止重名
     */
    UserSell checkRegister(String name);

    //获取所有
    Map<String,Object> findAllUserSellBack(Integer currentPage, Integer lineSize, String keyWord) throws Exception;

    UserSell findStoresByUserSell(Integer usid) throws Exception;
}
