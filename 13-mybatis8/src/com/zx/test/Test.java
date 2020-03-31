package com.zx.test;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zx.mapper.StudentMapper;
import com.zx.mapper.TeacherMapper;
import com.zx.pojo.Student;
import com.zx.pojo.Teacher;

public class Test {
	/**
	 * mybatis中默认设置缓存开启
	 * 只有session对象第一次进行查询操作的时候才会去访问数据库
	 * 然后将查询返回的结果信息储存在缓存中 缓存的是statement对象
	 * 在mybatis中一个select就对应着一个statement对象
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		InputStream is=Resources.getResourceAsStream("MyBatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		TeacherMapper mapper = session.getMapper(TeacherMapper.class);
		//使用注解查询数据
		/*List<Teacher> selAll = mapper.selAll();
		for (Teacher teacher : selAll) {
			System.out.println(teacher);
			
		}*/
		
		//使用注解增删改数据 传值
		/*int upTeacher = mapper.upTeacher(3, 5);
		System.out.println(upTeacher);*/
		
		//使用注解增删改数据 传对象
		/*Teacher t=new Teacher();
		t.setTname("老师5");
		mapper.delTeacher(t);*/
		
		/*StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Student> selST = studentMapper.selST();
		System.out.println(selST);*/
		
		List<Teacher> selTS = mapper.selAll2();
		System.out.println(selTS);
		
		session.commit();
		session.close();
		System.out.println("程序执行结束");
	}
}
