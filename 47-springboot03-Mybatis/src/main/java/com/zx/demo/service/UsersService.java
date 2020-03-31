package com.zx.demo.service;

import java.util.List;

import com.zx.demo.domain.Users;

public interface UsersService {
	
	/**
	 * 数据库增加数据
	 * @param user
	 * @return
	 */
	int add(Users user);
	
	/**
	 * 查询全部用户
	 * @return
	 */
	List<Users> show();
	
	/**
	 * 根据id查询用户
	 * @return
	 */
	Users selById(int id);
	
	
	/**
	 * 更新用户信息
	 * @return
	 */
	int updUsers(Users user);
	
	
	/**
	 * 根据userid删除用户
	 * @param userId
	 * @return
	 */
	int delUsers(int userId);
}
