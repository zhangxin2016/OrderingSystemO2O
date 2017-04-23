package com.zx.service.impl;


import java.util.List;

import com.zx.mapper.UserBuyMapper;
import com.zx.mapper.UserMapper1;
import com.zx.model.UserBuy;
import com.zx.service.UserService;
import com.zx.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserBuyMapper userMapper;

	@Autowired
	private UserMapper1 mapper;


	/**
	 * @title :getUserByNameAndPass
	 * @description :用户登录验证实现类
	 */
	@Override
	public UserBuy getUserByNameAndPass(UserBuy user){
		return mapper.getUserByNameAndPass(user);
	}

	/**
	 * @title :register
	 * @description :接口方法实现类，进行用户信息录入
	 */
	@Override
	public int register(UserBuy user) {
		return userMapper.insertSelective(user);
	}

	/**
	 * @title :checkRegister
	 * @description :验证用户是否存在，防止重名
	 */
	@Override
	public UserBuy checkRegister(String name) {
		return mapper.checkRegister(name);
	}


	@Override
	public UserBuy selectByPrimaryKey(Integer uid) {
		return userMapper.selectByPrimaryKey(uid);
	}


	@Override
	public int updateEmail(UserBuy user) {
		return mapper.updateEmail(user);
	}

	@Override
	public int updatePass(UserBuy user) {
		return mapper.updatePass(user);
	}


	@Override
	public int updateDetail(UserBuy user) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int updatePhone(UserBuy user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> selectByFindStrs(String username) {
		return mapper.selectByFindStrs(username);
	}


	/**
	 * @文件名称: UserServiceImpl.java
	 * @类路径: com.mars.service.impl
	 * @描述:   接口实现类：显示用户信息分页及搜索功能
	 */
	@Override
	public Integer getCounts() {
		return userMapper.getCounts();
	}

	@Override
	public List<UserBuy> getAll(Page page) {
		return userMapper.getAll(page);
	}

	@Override
	public List<UserBuy> findByid(int uid, Page page) {
		return userMapper.findByid(uid, page);
	}

	@Override
	public List<UserBuy> findByName(String username) {

		return userMapper.findByName(username);
	}

	@Override
	public int updateUser(UserBuy u) {
		return userMapper.updateByPrimaryKey(u);
	}


}
