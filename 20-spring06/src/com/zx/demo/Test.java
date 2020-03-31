package com.zx.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo d = ac.getBean("demo",Demo.class);
		d.demo01("张三",12);
		d.demo02("李四");
		
	
	}
}
