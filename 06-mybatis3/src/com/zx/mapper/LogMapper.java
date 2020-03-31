package com.zx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.pojo.Log;

public interface LogMapper {
	
	/**
	 * 显示全部
	 * @return
	 */
	List<Log> selAll();
	//绑定接口多参数传递
	List<Log> selByOutUnoInUno(int outuno,int inuno);
	//动态sql
	List<Log> selByOutUnoInUno2(@Param("outUno")String outUno,@Param("inUno")String inUno);
	
	/**
	 * 修改表
	 * @param outUno
	 * @param inUno
	 * @return
	 */
	int upLog(Log log);
	
	List<Log> selLog(Log l);
	
	List<Log> selIn(List<Integer> list);
}
