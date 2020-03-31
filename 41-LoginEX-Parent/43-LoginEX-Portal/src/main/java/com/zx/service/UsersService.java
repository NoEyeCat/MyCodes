package com.zx.service;

import com.zx.pojo.Users;

public interface UsersService {
	Users selByUser(Users user);
	
	int insUser(Users user);
}
