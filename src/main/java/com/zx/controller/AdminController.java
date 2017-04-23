package com.zx.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zx.model.Admin;
import com.zx.model.AdminExample;
import com.zx.service.AdminService;
import com.zx.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes(value={"page","see_type"})
@Controller
@RequestMapping("/back/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/insert")
	public String insert(Admin record){
		adminService.insert(record);
		return "redirect:list.html";
	}
	
	
	@RequestMapping("/list")
	public String list(AdminExample example, ModelMap modelMap, HttpServletRequest request){
	List <Admin> list =adminService.selectByExample(example);
	modelMap.put("list", list);
		return "/back/admin/adminList";
	}

//返回添加管理员页面
	@RequestMapping("/add-admin")
	public String add_admin(){
		return "/back/admin/addAdmin";
	}

	@RequestMapping("/deleteByPrimaryKey")
	public String deleteByPrimaryKey(Admin admin,HttpServletRequest request){
		System.out.println("aid============"+admin.getAid());
		adminService.deleteByPrimaryKey(admin.getAid());
		return "redirect:list.html";
	}

	//根据ID获取需要修改的管理员信息
	@RequestMapping("/get")
	public String selectByPrimaryKey(Admin record,ModelMap modelMap,HttpServletRequest request){
	Admin admin=adminService.selectByPrimaryKey(record.getAid());
	modelMap.put("admin", admin);
		return "back/admin/updateAdmin";
	}
	
	@RequestMapping("/update")
	public String update(Admin record){
		adminService.updateByPrimaryKey(record);
		return "redirect:list.html";
	}
	
	@RequestMapping("/search")
	public String findById(@RequestParam("id")String id,ModelMap modelMap,HttpServletRequest request){
		List <Admin> list =adminService.findById(id);
		Page page = new Page(list.size(), 3);
		modelMap.put("list", list);
		modelMap.put("page", page);
		modelMap.put("i", 1);
		return "/back/admin/adminList";
	}

//分页
	
	@RequestMapping("/fenye")
	public String listPage(Map<String,Object> map ,HttpServletRequest request){
		String currentPage=request.getParameter("currentPage");
		int i = 0;
		System.out.println("admin>>>>>");
		Page page = new Page(adminService.getCounts(), 3);
		if(currentPage == null){
		List<Admin> list = adminService.getAll(page);
		map.put("list", list);
			i=1;
		}else{
			i=Integer.parseInt(currentPage);
			page.setCurrentPage(i);
			List<Admin> list = adminService.getAll(page);
			map.put("list", list);
		}
		
		map.put("page", page);
		map.put("i", i); // 将键和值放在Map中	
		
		return "/back/admin/adminList";
	}
	

}
