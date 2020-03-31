package com.zx.service;

import com.zx.pojo.User;

public interface UserService {
	
	/**
	 * 检验用户
	 * @param name
	 * @param pwd
	 * @param checkCode
	 * @return
	 */
	User check(String name,String pwd);
	
}
