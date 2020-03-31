package com.zx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.pojo.Menu;

public interface MenuMapper {
	
	/**
	 * 根据角色rid和user的pid查询菜单
	 * @param rid
	 * @param pid
	 * @return
	 */
	List<Menu> selMenu(@Param("rid") int rid,@Param("pid") int pid);
	
}
