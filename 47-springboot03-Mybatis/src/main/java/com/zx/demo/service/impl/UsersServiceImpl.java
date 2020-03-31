package com.zx.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zx.demo.domain.Users;
import com.zx.demo.mapper.UsersMapper;
import com.zx.demo.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	
	@Resource
	private UsersMapper usersMapper;
	
	@Override
	public int add(Users user) {
		usersMapper.insert(user);
		int id = user.getId();
		return id;
	}

	@Override
	public List<Users> show() {
		
		return usersMapper.getAll();
	}

	@Override
	public Users selById(int id) {
		
		return usersMapper.findById(id);
	}

	@Override
	//引入事务控制
	@Transactional(propagation = Propagation.REQUIRED)
	public int updUsers(Users user) {
		
		return usersMapper.update(user);
	}

	@Override
	public int delUsers(int userId) {
		
		return usersMapper.delete(userId);
	}

}
