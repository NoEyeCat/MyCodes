package com.zx.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zx.pojo.People;
import com.zx.pojo.pageInfo;
import com.zx.service.pageService;

public class pageServiceImpl implements pageService{

	@Override
	public pageInfo page(int pageSize,int pageNumber) throws IOException {
	
		//读取数据流
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//使用工厂模式
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		//生产sqlsession对象
		SqlSession session = factory.openSession();
		//获取pageinfo对象
		pageInfo pi=new pageInfo();
		pi.setPageNumber(pageNumber);
		pi.setPageSize(pageSize);
		//获取map对象
		Map<String, Object> map=new HashMap<>();
		map.put("pageStart", pageSize*(pageNumber-1));
		map.put("pageSize", pageSize);
		pi.setList(session.selectList("com.zx.mapper.pageMapper.page",map));
		long count = session.selectOne("com.zx.mapper.pageMapper.pageCount");
		pi.setTotal(count%pageNumber==0?count/pageNumber:count/pageNumber+1);
		session.close();
		return pi;
	}

}
