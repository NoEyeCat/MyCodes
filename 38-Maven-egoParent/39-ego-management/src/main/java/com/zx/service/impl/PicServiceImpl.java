package com.zx.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zx.mapper.PicMapper;
import com.zx.pojo.Pic;
import com.zx.service.PicService;

@Service
public class PicServiceImpl implements PicService{
	@Resource
	private PicMapper picMapper;
	
	@Override
	public int insPic(Pic pic) {
		return picMapper.insPic(pic);
	}

	@Override
	public List<Pic> show() {
		// TODO Auto-generated method stub
		return picMapper.selAll();
	}

	@Override
	public int delPic(int id) {
		
		return picMapper.delPic(id);
	}

}
