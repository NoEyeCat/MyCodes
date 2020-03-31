package com.zx.service.impl;

import com.zx.mapper.UserMapper;
import com.zx.pojo.User;
import com.zx.service.UserService;

public class UserServiceImpl implements UserService{
	private UserMapper us;
	
	public UserMapper getUs() {
		return us;
	}

	public void setUs(UserMapper us) {
		this.us = us;
	}

	@Override
	public User check(String name, String pwd) {
		
		return us.check(name, pwd);
	}

}
