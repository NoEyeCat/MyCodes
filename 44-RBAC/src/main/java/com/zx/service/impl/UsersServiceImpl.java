package com.zx.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zx.mapper.UserMapper;
import com.zx.pojo.Users;
import com.zx.service.ElementService;
import com.zx.service.MenuService;
import com.zx.service.UrlService;
import com.zx.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Resource
	private UserMapper userMapper;
	@Resource
	private MenuService menuServiceImpl;
	@Resource
	private ElementService elementServiceImpl;
	@Resource
	private UrlService urlServiceImpl;
	
	@Override
	public Map<String, Object> login(Users user) {
		Map<String, Object> map=new HashMap<>();
		Users resultu = userMapper.selByUser(user);
		if (resultu!=null) {
			resultu.setMenus(menuServiceImpl.showMenu(resultu.getRid()));
			resultu.setElements(elementServiceImpl.selByRid(resultu.getRid()));
			resultu.setUrls(urlServiceImpl.selByRid(resultu.getRid()));
			map.put("allurl",urlServiceImpl.show());
		}	
		map.put("user", resultu);
		return map;
	}

}
