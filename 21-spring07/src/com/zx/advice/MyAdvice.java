package com.zx.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {
	@Before("com.zx.demo.Demo.demo01()")
	public void mybefore(){
		System.out.println("前置");
	}
	@After("com.zx.demo.Demo.demo01()")
	public void myafter(){
		System.out.println("后置通知");
	}
	@AfterThrowing("com.zx.demo.Demo.demo02()")
	public void mythrows(){
		System.out.println("异常通知");
	}
	@Around("com.zx.demo.Demo.demo01()")
	public Object myaround(ProceedingJoinPoint p) throws Throwable{
		
		System.out.println("环绕前置");
		Object proceed = p.proceed();
		System.out.println("环绕后置");
		return proceed;
	}
}
