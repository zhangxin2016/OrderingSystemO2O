package com.zx.mapper;

import java.util.List;


import com.zx.model.Admin;
import com.zx.model.AdminExample;
import com.zx.util.Page;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);
    //根据ID删除管理员信息
    int deleteByPrimaryKey(Integer aid);
    //增加管理员
    int insert(Admin record);

    int insertSelective(Admin record);
    //显示所有管理员信息
    List<Admin> selectByExample(AdminExample example);
    //获取管理员信息
    Admin selectByPrimaryKey(Integer aid);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);
    //修改管理员信息
    int updateByPrimaryKey(Admin record);
    //登录验证
    List<Admin> checkUsername(String username);
    Admin checkPassword(String password);
    //根据ID搜索管理员信息
    List<Admin> findById(String id);
    //分页
    Integer getCounts();
    List<Admin> getAll(Page page);
    List<Admin> findByid(int id,Page page);
}