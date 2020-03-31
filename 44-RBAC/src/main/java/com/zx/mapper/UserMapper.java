package com.zx.mapper;

import org.apache.ibatis.annotations.Select;

import com.zx.pojo.Users;

public interface UserMapper {
	
	/**
	 * 登陆功能
	 * @return
	 */
	@Select("select * from users where username=#{username} and password=#{password}")
	Users selByUser(Users user);
	
}
