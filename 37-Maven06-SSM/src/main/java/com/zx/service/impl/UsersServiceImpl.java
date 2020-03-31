package com.zx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zx.mapper.UsersMapper;
import com.zx.pojo.Users;
import com.zx.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	private UsersMapper usersMapper;
	@Override
	public int insUsers(Users user) {
		
		return usersMapper.insUser(user);
	}

}
