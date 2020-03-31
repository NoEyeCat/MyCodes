package com.zx.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zx.demo.domain.Users;

/**
 * 用于访问数据库的接口
 * 
 * @author zhang
 *
 */
public interface UsersMapper {
	// 推荐使用#{}取值，不要用${},因为存在数据注入的风险
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@Insert("INSERT INTO users(username,phone,createtime,age) VALUES(#{username},#{phone},#{createTime},#{age})")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // keyProperty java对象的属性；keyColumn表示数据库的字段
	int insert(Users user);

	/**
	 * 查找全部
	 * @return
	 */
	@Select("SELECT * FROM users")
	@Results({ @Result(column = "createtime", property = "createTime") // javaType = java.util.Date.class
	})
	List<Users> getAll();

	/**
	 * 按照id查找用户
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({ @Result(column = "createtime", property = "createTime") })
	Users findById(int id);

	/**
	 * 修改用户
	 * @param user
	 * @return 
	 */
	@Update("UPDATE users SET username=#{username} WHERE id =#{id}")
	int update(Users user);

	/**
	 * 删除用户
	 * @param userId
	 */
	@Delete("DELETE FROM users WHERE id =#{userId}")
	int delete(int userId);

}
