package com.zx.demo;

public class SingleTon2 {
	//饿汉式
	private static SingleTon2 singleTon = new SingleTon2();
	private SingleTon2(){
		
	}
	public static SingleTon2 getInstance(){
		return singleTon;
	}
}
