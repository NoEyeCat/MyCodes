package com.zx.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zx.pojo.Menu;

public interface MenuMapper {
	
	
	@Results(value={
			@Result(id=true,column="id",property="id"),
			@Result(column="name",property="name"),
			@Result(column="pid",property="pid"),
			@Result(property="children",many=@Many(select="selByUser2"),column="{uid=uid,pid=id}")
	})
	@Select("select *,#{uid} uid from menu where id in(select mid from users_menu where uid=#{uid}) and pid=#{pid}")
	List<Menu> selByUser2(Map<String, Object> map);
}
