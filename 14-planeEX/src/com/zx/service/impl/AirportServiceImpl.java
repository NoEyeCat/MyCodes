package com.zx.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zx.mapper.AirportMapper;
import com.zx.pojo.Airport;
import com.zx.service.AirportService;
import com.zx.util.MyBatisUtil;

public class AirportServiceImpl implements AirportService{
	private SqlSession session = MyBatisUtil.getSession();
	private AirportMapper airportMapper = session.getMapper(AirportMapper.class);
	@Override
	public List<Airport> selUpPort() {
		
		
		
		List<Airport> selUpPort = airportMapper.selUpPort();
		return selUpPort;
	}

	@Override
	public List<Airport> selDownPort() {
		List<Airport> selDownPort = airportMapper.selDownPort();
		return selDownPort;
	}

}
