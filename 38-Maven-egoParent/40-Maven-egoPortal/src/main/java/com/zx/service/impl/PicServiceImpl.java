package com.zx.service.impl;

import java.nio.file.Path;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zx.mapper.PicMapper;
import com.zx.pojo.Pic;
import com.zx.service.PicService;
@Service
public class PicServiceImpl implements PicService{
	@Value("${management.url}")
	private String Path;
	@Resource
	private PicMapper picMapper;
	@Override
	public List<Pic> show() {
		List<Pic> list = picMapper.selAll();
		for (Pic pic : list) {
			pic.setPath(Path+pic.getPath());
		}
		return list;
	}

}
