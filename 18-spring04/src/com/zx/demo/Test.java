package com.zx.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		/*Demo demo=new Demo();
		demo.demo01();
		demo.demo02();
		demo.demo03();*/
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		Demo d = ac.getBean("demo",Demo.class);
		
		try {
			d.demo02();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
}
