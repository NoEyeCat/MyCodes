package com.zx.mapper;

import org.apache.ibatis.annotations.Select;

import com.zx.pojo.User;

public interface UserMapper {
	@Select("select * from t_user2 where uname=#{0} and upwd=#{1}")
	User check(String uname,String upwd);
}
