package com.zx.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zx.pojo.Users;
import com.zx.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("login")
	public String login(Users user,HttpSession session){
		Map<String, Object> map = usersServiceImpl.login(user);
		if (map.get("user")!=null) {
			session.setAttribute("user",map.get("user"));
			session.setAttribute("allurl", map.get("allurl"));
			return "redirect:/main.jsp";
		}else {
			session.removeAttribute("user");
			return "redirect:/login.jsp";
		}
	}
	@RequestMapping("demo")
	public String demo(){
		return "/123.jsp";
	}
}
