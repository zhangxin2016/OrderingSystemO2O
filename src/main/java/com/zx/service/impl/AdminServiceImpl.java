package com.zx.service.impl;

import java.util.List;

import com.zx.mapper.AdminMapper;
import com.zx.model.Admin;
import com.zx.model.AdminExample;
import com.zx.service.AdminService;
import com.zx.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

@Autowired
 private AdminMapper adminMapper;

	public int insert(Admin record) {
		return adminMapper.insert(record);
	}

	@Override
	public List<Admin> selectByExample(AdminExample example) {
		return adminMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer aid) {
		return adminMapper.deleteByPrimaryKey(aid);
	}

	@Override
	public int updateByPrimaryKey(Admin record) {
		return adminMapper.updateByPrimaryKey(record);
	}

	@Override
	public Admin selectByPrimaryKey(Integer id) {
		return adminMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Admin> findById(String id) {
		return adminMapper.findById(id);
	}

	@Override
	public List<Admin> getAll(Page page) {
		return adminMapper.getAll(page);
	}

	@Override
	public Integer getCounts() {
		return adminMapper.getCounts();
	}

	@Override
	public List<Admin> findByid(int id, Page page) {
		return adminMapper.findByid(id, page);
	}

	@Override
	public List<Admin> checkUsername(String username) {
		return adminMapper.checkUsername(username);
	}

	@Override
	public Admin checkPassword(String password) {
		return adminMapper.checkPassword(password);
	}
}
