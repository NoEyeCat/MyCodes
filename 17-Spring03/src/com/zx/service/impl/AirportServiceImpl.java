package com.zx.service.impl;

import java.util.List;

import com.zx.mapper.AirportMapper;
import com.zx.pojo.Airport;
import com.zx.service.AirportService;

public class AirportServiceImpl implements AirportService{
	private AirportMapper airportMapper;
	
	public AirportMapper getAirportMapper() {
		return airportMapper;
	}

	public void setAirportMapper(AirportMapper airportMapper) {
		this.airportMapper = airportMapper;
	}

	@Override
	public List<Airport> show() {
		// TODO Auto-generated method stub
		return airportMapper.selAll();
	}
	
}
