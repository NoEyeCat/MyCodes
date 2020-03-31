package com.zx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zx.mapper.MenuMapper;
import com.zx.pojo.Menu;
import com.zx.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{
	@Resource
	private MenuMapper menuMapper;
	@Override
	public List<Menu> showMenu(int rid) {
		return menuMapper.selMenu(rid,0);
	}

}
