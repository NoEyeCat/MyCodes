package com.zx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.pojo.Plane;

public interface PlaneMapper {
	List<Plane> selPlane(@Param("upid")int upid,@Param("downid")int downid);

	
	
}
