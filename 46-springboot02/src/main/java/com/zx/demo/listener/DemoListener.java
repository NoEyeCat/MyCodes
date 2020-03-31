package com.zx.demo.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class DemoListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("--------------------监听器销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("--------------------监听器初始化");
	}
	
}
