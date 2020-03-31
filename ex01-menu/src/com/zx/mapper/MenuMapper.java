package com.zx.mapper;

import java.util.List;

import com.zx.pojo.Menu;

public interface MenuMapper {
	List<Menu> selByPid(int pid);
}
