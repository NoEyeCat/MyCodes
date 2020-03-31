package com.zx.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zx.pojo.Student;

public interface StudentMapper {
	
	@Select("select s.name sname,s.id sid,s.age sage,s.tid stid,t.name 'teacher.tname',t.id 'teacher.tid' from student s left join teacher t on s.tid=t.id")
	List<Student> selST();
	
	@Results(value={@Result(id=true,column="id",property="sid"),
					@Result(column="name",property="sname"),
					@Result(column="age",property="sage"),
					@Result(column="tid",property="stid")
	})
	@Select("select * from student where tid=#{0}")
	List<Student> selById();
}
