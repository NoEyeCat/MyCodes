package com.zx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zx.pojo.Student;
import com.zx.pojo.Teacher;

public interface TeacherMapper {
	@Select("select id tid from teacher")
	List<Teacher> selAll();
	
	@Update("update teacher set id=#{1} where id=#{0}")
	int upTeacher(int oldId,int newId);
	
	@Insert("insert into teacher values(default,#{tname})")
	int insTeacher(Teacher t);
	@Delete("delete from teacher where name=#{tname}")
	int delTeacher(Teacher t);
	
	@Results(value={
				@Result(id=true,property="tid",column="id"),
				@Result(property="tname",column="name"),
				@Result(property="students",column="id",many=@Many(select="com.zx.mapper.StudentMapper.selById"))
					})
	@Select("select * from teacher")
	List<Teacher> selTS();
	
	List<Teacher> selAll2();
}
