package com.zx.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zx.mapper.PlaneMapper;
import com.zx.pojo.Plane;
import com.zx.service.PlaneService;
import com.zx.util.MyBatisUtil;

public class PlaneServiceImpl implements PlaneService{

	@Override
	public List<Plane> selPlane(int upid,int downid) {
		
		SqlSession session = MyBatisUtil.getSession();
		PlaneMapper planeMapper = session.getMapper(PlaneMapper.class);
		List<Plane> selPlane = planeMapper.selPlane(upid, downid);
		return selPlane;
	}

}
