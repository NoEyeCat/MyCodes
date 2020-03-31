package com.zx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zx.service.impl.AirportServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		AirportServiceImpl bean = ac.getBean("airportServiceImpl",AirportServiceImpl.class);
		System.out.println(bean.show());
	}
}
