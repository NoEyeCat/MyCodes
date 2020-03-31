package com.zx.test;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		
	
		
		List<Teacher> teachers = session.selectList("com.zx.mapper.TeacherMapper.selAll1");
		for (Teacher teacher : teachers) {
			System.out.println(teacher);
		}
		
		session.close();
		System.out.println("程序执行结束");
	}
}
