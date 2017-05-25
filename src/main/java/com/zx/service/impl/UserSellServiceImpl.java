package com.zx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zx.mapper.UserSellMapper;
import com.zx.model.UserSell;
import com.zx.service.UserSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> findAllUserSellBack(Integer currentPage, Integer lineSize, String keyWord) throws Exception {
        Map<String,Object> map=new HashMap<String, Object>();    //map集合保存分页信息和数据
        PageHelper.startPage(currentPage, lineSize);     //设置分页参数
        if("".equals(keyWord) || keyWord==null){    //组织关键词
            keyWord="%"+keyWord+"%";
        }else{
            keyWord="%"+keyWord+"%";
        }
        List<UserSell> userSellsList=this.userMapper.findAllUserSellBack(keyWord);   //模糊查询
        PageInfo<UserSell> pageInfo=new PageInfo<UserSell>(userSellsList); //获取分页信息
        map.put("userSellsList", userSellsList);
        map.put("pageInfo", pageInfo);
        return map;
    }

    @Override
    public UserSell findStoresByUserSell(Integer usid) throws Exception {
        return userMapper.findStoresByUserSell(usid);
    }

    @Override
    public Integer updateUserSell(UserSell userSell) throws Exception {
        return userMapper.updateByPrimaryKeySelective(userSell);
    }
}
