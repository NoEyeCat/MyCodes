package com.zx.advice;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import com.zx.pojo.User;

public class AfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		Logger logger=Logger.getLogger(AfterAdvice.class);
		String name=(String)arg2[0];
		if (arg0!=null) {
			logger.info(name+"登录成功！");
		}else{
			logger.info(name+"登录失败！");
		}
		
	}

}
