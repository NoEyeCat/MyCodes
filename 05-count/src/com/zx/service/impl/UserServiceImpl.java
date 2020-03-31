package com.zx.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.zx.pojo.Log;
import com.zx.pojo.Page;
import com.zx.pojo.User;
import com.zx.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public int ZZCount(User iu,User ou) throws IOException {
		//读取xml文件
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		//将读取内容放入工厂模式
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		//生产sqlsession对象
		SqlSession session = factory.openSession();
		//获取user对象
		//判断付款方账号和密码是否匹配
		User out = session.selectOne("com.zx.mapper.UserMapper.selByUnoPwd", ou);
		if (out!=null) {
			if (out.getCount()>=ou.getCount()) {
				//判断收款方账号和姓名是否匹配
				User in = session.selectOne("com.zx.mapper.UserMapper.selByUnoName", iu);
				if (in!=null) {
					ou.setCount(-ou.getCount());
					int index = session.update("com.zx.mapper.UserMapper.updateCount", ou);
					index += session.update("com.zx.mapper.UserMapper.updateCount", iu);
					if (index==2) {
						Log log=new Log();
						log.setInUno(iu.getUno());
						log.setOutUno(ou.getUno());
						log.setMoney(iu.getCount());
						session.insert("com.zx.mapper.LogMapper.insLog", log);
						Logger logger=Logger.getLogger(UserServiceImpl.class);
						logger.info(log.getOutUno()+"给"+log.getInUno()+"在"+new Date().toLocaleString()+"转账"+log.getMoney()+"元。");
						session.commit();
						session.close();
						return SUCCESS;
					} else {
						session.rollback();
						session.close();
						return ERROR;
					}
				}else{
					//收款方账号和姓名不匹配
					return UNO_NAME_NOT_MATCH;
				}
			}else{
				//余额不足
				return ACC_COUNT_NOT_ENOUGH;
			}
		} else {
			//付款方账号和密码不匹配
			return UNO_PWD_NOT_MATCH;
		}
	}

	@Override
	public Page resUser(int pageSize,int pageNumber) throws IOException {
		InputStream is=Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		Map<String, Integer> map=new HashMap<>();
		map.put("pageSize", pageSize);
		map.put("pageStart", pageSize*(pageNumber-1));
		Page page = new Page();
		page.setLogList(session.selectList("com.zx.mapper.LogMapper.pageInfo",map));
		long count=session.selectOne("com.zx.mapper.LogMapper.pageCount");
		page.setPageSize(pageSize);
		page.setPageNumber(pageNumber);
		page.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		session.close();
		return page;
	}
}
