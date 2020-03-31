package com.zx.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zx.pojo.People;
import com.zx.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{

	@Override
	public List<People> selAll() throws IOException {
		InputStream is = Resources.getResourceAsStream("MyBatis.xml");
		//前面为工厂设计模式，实例化工厂对象时使用的是构建者设计模式  特点是后面有builder
		//构建者设计模式意义：简化对象实例化过程
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("com.zx.mapper.PeopleMapper.selAll");
		session.close();
		return list;
	}

}
