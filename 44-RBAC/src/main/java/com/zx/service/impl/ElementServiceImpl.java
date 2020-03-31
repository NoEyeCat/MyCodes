package com.zx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zx.mapper.ElementMapper;
import com.zx.pojo.Element;
import com.zx.service.ElementService;

@Service
public class ElementServiceImpl implements ElementService{
	@Resource
	private ElementMapper elementMapper;

	@Override
	public List<Element> selByRid(int rid) {
		
		return elementMapper.sElement(rid);
	}
	
	
}
