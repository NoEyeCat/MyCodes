package com.zx.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.zx.mapper.LogMapper;
import com.zx.pojo.Log;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is=Resources.getResourceAsStream("MyBatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		
		/*
		 * 接口“实例化”
		 * 
		 * 需要给接口一个实例化对象
		 * 
		 * 利用的是jdk的动态代理设计模式
		 * 面向接口的代理设计模式（必须有接口）
		 * 
		 * 
		 * */		
		//接口绑定+多参数传递
		/*LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> selAll = logMapper.selAll();
		for (Log l : selAll) {
			System.out.println(l);
		}*/
		
		/*LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> selByInOut = logMapper.selByOutUnoInUno(1, 2);
		for (Log log : selByInOut) {
			System.out.println(log);
		}*/
		
		//动态sql
			//查询
		/*Scanner sc=new Scanner(System.in);
		System.out.println("请输入转账账号：");
		String outUno=sc.nextLine();
		System.out.println("请输入收款账号：");
		
		
		String inUno=sc.nextLine();
		
		LogMapper mapper = session.getMapper(LogMapper.class);
		List<Log> selByOutUnoInUno2 = mapper.selByOutUnoInUno2(outUno, inUno);
		for (Log log : selByOutUnoInUno2) {
			System.out.println(log);
		}*/
		
		//修改
		/*Scanner sc=new Scanner(System.in);
		System.out.println("请输入需要修改的日志id：");
		String id=sc.nextLine();
		System.out.println("请输入修改后的付款人账号：");
		String outUno=sc.nextLine();
		System.out.println("请输入修改后的收款人账号：");
		String inUno=sc.nextLine();
		
		Log log=new Log();
		log.setId(id);
		log.setOutUno(outUno);
		log.setInUno(inUno);
		log.setMoney(100);
		LogMapper logMapper=session.getMapper(LogMapper.class);
		List<Log> upLog = logMapper.selLog(log);
		System.out.println(upLog);*/
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(6);
		LogMapper mapper = session.getMapper(LogMapper.class);
		List<Log> selIn = mapper.selIn(list);
		for (Log log : selIn) {
			System.out.println(log);
		}
		
		session.commit();
		session.close();
	}
}
