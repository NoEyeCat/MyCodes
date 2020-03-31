package com.zx.service;

import java.util.Map;

import com.zx.pojo.Users;

public interface UsersService {
	Map<String, Object> login(Users user);
}
