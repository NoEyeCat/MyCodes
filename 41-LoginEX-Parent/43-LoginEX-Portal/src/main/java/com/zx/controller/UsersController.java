package com.zx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
		public String login(Users users,HttpSession session){
			Users user = usersServiceImpl.selByUser(users);
			if(user!=null){
				session.setAttribute("user", user);
				return "redirect:/main.jsp";
			}else{
				return "redirect:/index.jsp";
			}
		}
	@RequestMapping("register")
	public String register(Users user,HttpServletRequest req){
		int result = usersServiceImpl.insUser(user);
		if (result>0) {
			HttpSession session = req.getSession();
			session.setAttribute("oper", "用户注册成功，请登录");
			return "redirect:/login.jsp";
		}else {
			return "redirect:/register.jsp";
		}
	}
}
