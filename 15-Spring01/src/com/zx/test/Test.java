package com.zx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zx.pojo.People;
import com.zx.pojo.PeopleFactory;
import com.zx.pojo.PeopleFactory2;

public class Test {
	public static void main(String[] args) {
		//People p=new People();
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//默认为无参构造方法来实例化对象
		People p = ac.getBean("peo2",People.class);
		System.out.println(p);
		//创建工厂对象
		/*PeopleFactory pf=new PeopleFactory();
		People createPeople = pf.createPeople();
		System.out.println(createPeople);*/
		
		/*
		 * 实例工厂测试代码
		 * 
		 * 如何实例化工厂和spring是无关的
		 * 
		*/		
		/*PeopleFactory2 pf2 =new PeopleFactory2();
		People p2=pf2.newInstance();*/
		
	/*
	 * 静态工厂
	 * 
	 * 
	 * */		
	/*People newIntance = PeopleFactory.newIntance();
	System.out.println(newIntance);*/
		
	}
}
