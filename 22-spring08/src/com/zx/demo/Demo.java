package com.zx.demo;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Demo{
	@Pointcut("execution(* com.zx.demo.Demo.demo01())")
	public void demo01(){
		System.out.println("方法主体");
	}	
	@Pointcut("execution(* com.zx.demo.Demo.demo02())")
	public void demo02(){
		System.out.println(1/0);
	}
}
