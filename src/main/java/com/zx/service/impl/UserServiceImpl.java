package com.zx.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public UserBuy checkRegisterByUidcard(String uidcard) {
		return mapper.checkRegisterByUidcard(uidcard);
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

	@Override
	public Map<String, Object> findAllUserBuyBack(Integer currentPage, Integer lineSize, String keyWord) throws Exception {
		Map<String,Object> map=new HashMap<String, Object>();    //map集合保存分页信息和数据
		PageHelper.startPage(currentPage, lineSize);     //设置分页参数
		if("".equals(keyWord) || keyWord==null){    //组织关键词
			keyWord="%"+keyWord+"%";
		}else{
			keyWord="%"+keyWord+"%";
		}
		List<UserBuy> userBuysList=this.userMapper.findAllUserBuyBack(keyWord);   //模糊查询
		PageInfo<UserBuy> pageInfo=new PageInfo<UserBuy>(userBuysList); //获取分页信息
		map.put("userBuysList", userBuysList);
		map.put("pageInfo", pageInfo);
		return map;
	}

	@Override
	public Integer deleteUserBuyByAdmin(Integer uid) throws Exception {
		return userMapper.deleteUserBuyByAdmin(uid);
	}
}
