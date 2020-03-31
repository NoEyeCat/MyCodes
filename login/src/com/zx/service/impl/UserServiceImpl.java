package com.zx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.mapper.UserMapper;
import com.zx.pojo.User;
import com.zx.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper um;
	
	@Override
	public User logUser(String name, String pwd) {
		
		return um.logUser(name, pwd);
	}
}
