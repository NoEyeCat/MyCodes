package com.zx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zx.mapper.FilesMapper;
import com.zx.pojo.Files;
import com.zx.pojo.Users;
import com.zx.service.FilesService;

@Service
public class FilesServiceImpl implements FilesService{
	@Resource
	private FilesMapper filesMapper;
	
	@Override
	public List<Files> show() {
		return filesMapper.selAll();
	}

	@Override
	public int updCount(int id,Users user,String name) {
		Logger logger=Logger.getLogger(FilesServiceImpl.class);
		logger.debug(user.getUsername()+"下载了"+name);
		return filesMapper.updById(id);
	}

}
