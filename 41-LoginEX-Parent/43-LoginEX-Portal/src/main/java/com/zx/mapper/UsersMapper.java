package com.zx.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zx.pojo.Users;

public interface UsersMapper {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	
	@Results(value={
			@Result(id=true,column="id",property="id"),
			@Result(column="username",property="username"),
			@Result(column="password",property="password"),
			@Result(property="menus",many=@Many(select="com.zx.mapper.MenuMapper.selByUser2"),column="{uid=id,pid=pid}")
	})
	//如果需要传递多个参数，语法column="{key=列名,key=列名}" key为自定义名字
	//另一个查询中获取传递过来的参数#{key}
	//另一个查询方法中接受参数应该使用map来接，比如：public void select(Map(string,object) map)
	@Select("select *,0 pid from users where username=#{username} and password=#{password}")
	Users selByUser(Users user);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	@Insert("insert into users values(default,#{username},#{password})")
	int insUser(Users user);
}
