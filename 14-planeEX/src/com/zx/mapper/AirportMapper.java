package com.zx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zx.pojo.Airport;

public interface AirportMapper {
	
	@Select("select * from airport where id in (select distinct upid from plane)")
	List<Airport> selUpPort();
	
	@Select("select * from airport where id in (select distinct downid from plane)")
	List<Airport> selDownPort();
	

}
