package com.zx.demo;

public class Test {
	public static void main(String[] args) {
		SingleTon singleTon=SingleTon.getInstance();
		SingleTon singleTon1=SingleTon.getInstance();
		System.out.println(singleTon==singleTon1);
	}
}
