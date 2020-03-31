package com.zx.test;

public class Test {
	public static void main(String[] args) {
		ThreadLocal<String> threadLocal=new ThreadLocal<>();
		threadLocal.set("测试");
		
		new Thread(){
			public void run() {
				String string = threadLocal.get();
				System.out.println(string);
			};
		}.start();
	}
}
