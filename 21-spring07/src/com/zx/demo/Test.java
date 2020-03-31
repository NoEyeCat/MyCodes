package com.zx.demo;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		/*String[] beanDefinitionNames = ac.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));*/
		Demo d = ac.getBean("demo",Demo.class);
		d.demo01();
		try {
			d.demo02();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	
	}
}
