package com.zx.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DemoController {
	@RequestMapping("demo1")
	public String demo1(HttpServletRequest req,HttpSession session2){
		//request作用域
		req.setAttribute("req", "req的值");
		//sesison作用域
		HttpSession session1 = req.getSession();
		session1.setAttribute("session1", "session1的值");
		session2.setAttribute("session2", "session2的值");
		//application作用域
		ServletContext application = req.getServletContext();
		application.setAttribute("application", "application的值");
		return "/index.jsp";
	}
	@RequestMapping("demo2")
	public String demo2(Map<String, Object> map){
		map.put("map", "map的值");
		return "/index.jsp";
	}
	@RequestMapping("demo3")
	public String demo3(Model model){
		model.addAttribute("model", "model的值");
		return "/index.jsp";
	}
	@RequestMapping("demo4")
	public ModelAndView demo4(){
		//参数表示跳转视图
		ModelAndView modelAndView=new ModelAndView("/index.jsp");
		modelAndView.addObject("mav","mav的值");
		return modelAndView;
	}
}