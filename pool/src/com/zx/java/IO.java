package com.zx.java;

import java.io.File;

public class IO {
	public static void main(String[] args) {
		File src = new File("D:/Mycodes2/pool/src");
		spName(src,0);
	}
	
	public static void spName(File src,int deep) {
		for (int i = 0; i < deep; i++) {
			System.out.print("-");
		}
		System.out.println(src.getName());
		if (null==src||!src.exists()) {
			return;
		}else if (src.isDirectory()) {
			for (File s : src.listFiles()) {
				spName(s,deep+1);
			}
		}
	}
}