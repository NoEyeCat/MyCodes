package com.zx.mapper;

import java.util.List;

import com.zx.pojo.PageInfo;
import com.zx.pojo.Students;

public interface StudentMapper {
	List<Students> selStudents(PageInfo p);
	
	long selTotal(PageInfo p);
}
