package com.zx.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Mishu implements InvocationHandler{
	private Laozong laozong=new Laozong("王健林");

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("预约时间");
		Object reult = method.invoke(laozong, args);
		System.out.println("记录访客信息");
		return null;
	}

}
