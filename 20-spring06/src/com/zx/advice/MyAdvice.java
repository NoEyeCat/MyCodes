package com.zx.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
	public void myAfter(){
		System.out.println("后置通知-aspectJ");
	}
	public Object myArround(ProceedingJoinPoint p) throws Throwable{
		System.out.println("环绕前置通知-aspectJ");
		Object result = p.proceed();//放行
		System.out.println("环绕后置通知=aspectJ");
		return result;
	
	}
	public void myBefore(String name,int age){
		System.out.println("前置通知-aspectJ"+name+":"+age);
	}
	public void myBefore2(String name){
		System.out.println("前置通知-aspectJ"+name);
	}
	public void myError(Exception e){
		System.out.println("异常通知-aspectJ"+e.getMessage());
	}
}
