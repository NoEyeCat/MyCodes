package com.zx.advice;


public class MyThrowAdvice{
	public void myexception(Exception e){
		System.out.println("这是异常通知，异常信息为："+e.getMessage());
		
	}
}
