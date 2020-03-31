package com.zx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zx.mapper.UrlMapper;
import com.zx.pojo.Url;
import com.zx.service.UrlService;
@Service
public class UrlServiceImpl implements UrlService{
	@Resource
	private UrlMapper urlMapper;
	
	@Override
	public List<Url> selByRid(int rid) {
		return urlMapper.selUrl(rid);
	}

	@Override
	public List<Url> show() {
		// TODO Auto-generated method stub
		return urlMapper.selAll();
	}

}
