package com.zx.advice;

import java.lang.reflect.Method;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;


import com.zx.pojo.User;

public class BeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		String name = (String)arg1[0];
		Logger logger=Logger.getLogger(BeforeAdvice.class);
		logger.info(name+"在"+new Date().toLocaleString()+"进行登录");
	}

}
