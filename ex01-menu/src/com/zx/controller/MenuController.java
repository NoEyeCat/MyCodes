package com.zx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.pojo.Menu;
import com.zx.service.MenuService;

@Controller
public class MenuController{
	/*
	 * springMVC容器调用spring容器中的内容
	 * */
	@Resource
	private MenuService menuServiceImpl;
	
	@RequestMapping("show")
	@ResponseBody
	public List<Menu> show(){
		return menuServiceImpl.selByPid();
	}
}
