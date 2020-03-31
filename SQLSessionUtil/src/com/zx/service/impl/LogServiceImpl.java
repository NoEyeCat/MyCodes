package com.zx.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.zx.mapper.LogMapper;
import com.zx.pojo.Log;
import com.zx.service.LogService;
import com.zx.util.MyBatisUtil;

public class LogServiceImpl implements LogService{

	@Override
	public int insLog(Log log) {
		
		SqlSession session = MyBatisUtil.getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		int index = mapper.ins(log);
		return index;
	}
	
}
