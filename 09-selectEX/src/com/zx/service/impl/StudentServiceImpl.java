package com.zx.service.impl;

import java.io.IOException;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


import com.zx.mapper.StudentMapper;
import com.zx.mapper.TeacherMapper;
import com.zx.pojo.PageInfo;
import com.zx.pojo.Students;
import com.zx.service.StudentService;
import com.zx.util.MyBatisUtil;

public class StudentServiceImpl implements StudentService{

	@Override
	public PageInfo selStudents(String sname,String tname,String pageSizeStr,String pageNumberStr) throws IOException {
		SqlSession session = MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		PageInfo p=new PageInfo();
	
		int pageSize=2;
		int pageNumber=1;
		if (pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize=Integer.parseInt(pageSizeStr);
		}
		if (pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		p.setPageSize(pageSize);
		p.setPageStart((pageNumber-1)*pageSize);
		p.setSname(sname);
		p.setTname(tname);
		
	
		List<Students> selStudents = studentMapper.selStudents(p);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		for (Students stu : selStudents) {
			stu.setTeacher(teacherMapper.selById(stu.getTid()));
		}
		long count = studentMapper.selTotal(p);
		System.out.println(count);
		p.setList(selStudents);
		p.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		p.setPageSize(pageSize);
		p.setPageNumber(pageNumber);
		return p;
	}
	
}
