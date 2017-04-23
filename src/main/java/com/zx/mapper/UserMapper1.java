package com.zx.mapper;

import java.util.List;
import com.zx.model.UserBuy;

public interface UserMapper1{
	
	/**
	 * @title :getUserByNameAndPass
	 * @description :登录验证
	 */
	UserBuy getUserByNameAndPass(UserBuy user);
	
	/**
	 * @title :checkRegister
	 * @description :注册验证
	 */
	UserBuy checkRegister(String name);
	
	/**
	 * @title :updateDetail
	 * @description :更新用户基本信息
	 */ 
	int updateDetail(UserBuy user);
	
	/**
	 * @title :updatePhone
	 * @description :更新绑定手机
	 */ 
	int updatePhone(UserBuy user);
	
	/**
	 * @title :updateEmail
	 * @description :更新邮箱
	 */ 
    int updateEmail(UserBuy user);
	
	/**
	 * @title :updatePass
	 * @description :更新密码
	 */ 
	int updatePass(UserBuy user);
	
	List<Integer> selectByFindStrs(String username);
	
}