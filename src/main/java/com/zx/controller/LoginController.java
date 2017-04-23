package com.zx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zx.model.Admin;
import com.zx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/back/login")
public class LoginController {
@Autowired	
private AdminService adminService;

	@RequestMapping("/index")
	public String index(){
		return "back/index";
	}
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "back/welcome";
	}

	@RequestMapping("/backlogin")
	public String login(@RequestParam("aname") String username,
			@RequestParam("apassword") String password,
			HttpServletRequest request) {
		if(adminService.checkUsername(username) != null){
			List<Admin> list = adminService.checkUsername(username);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getApassword().equals(password)) {
					Admin admin = list.get(i);
					request.getSession().setAttribute("admin", admin);
					return "back/index";
				}
			}
		}
		request.setAttribute("mess", "用户名或密码错误");
		return "/back/login";
	}
}
