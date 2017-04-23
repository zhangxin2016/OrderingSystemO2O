package com.zx.service;

import com.zx.model.Admin;
import com.zx.model.AdminExample;
import com.zx.util.Page;

import java.util.List;


public interface AdminService {

    int insert(Admin record);
    List<Admin> selectByExample(AdminExample example);
    int deleteByPrimaryKey(Integer aid);
    Admin selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(Admin record);
	//登录验证
    List<Admin> checkUsername(String username);
    Admin checkPassword(String password);
    //分页
    Integer getCounts();
    List<Admin> getAll(Page page);
    List<Admin> findByid(int id,Page page);
    //搜索
    List<Admin> findById(String id);

}
