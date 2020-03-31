package com.zx.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zx.pojo.Users;

@Controller
public class DemoController {
	@RequestMapping("{page}")
	public String main(@PathVariable String page){
		return page;
	}
	@RequestMapping("login")
	public String login(Users user,HttpSession session){
		if (user.getUsername().equals("admin")&&user.getPassword().equals("123")) {
			session.setAttribute("user", user);
			return "main";
		}else {
			return "redirect:/login.jsp";
		}
	}
}