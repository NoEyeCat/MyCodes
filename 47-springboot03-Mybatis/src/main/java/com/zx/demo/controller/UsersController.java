package com.zx.demo.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zx.demo.domain.JsonData;
import com.zx.demo.domain.Users;
import com.zx.demo.service.UsersService;

@RestController
@RequestMapping("/v2")
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	
	@RequestMapping("add")
	public Object addUsers() {
		Users user =new Users();
		user.setAge(11);
		user.setPhone("12345");
		user.setUsername("张三");
		user.setCreateTime(new Date());
		int add = usersServiceImpl.add(user);
		return JsonData.buildSuccess(add);
	}
	
	@RequestMapping("selAll")
	public Object selAll() {
		return JsonData.buildSuccess(usersServiceImpl.show());
	}
	
	@RequestMapping("selOne")
	public Object selOne() {
		return JsonData.buildSuccess(usersServiceImpl.selById(2));
	}
	
	@RequestMapping("upd")
	public Object updOne() {
		Users user=new Users();
		user.setUsername("王五");
		user.setId(1);
		return JsonData.buildSuccess(usersServiceImpl.updUsers(user));
	}
	
	@RequestMapping("del")
	public Object delOne() {
		return JsonData.buildSuccess(usersServiceImpl.delUsers(4));
	}
}



