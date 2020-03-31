package com.zx.pojo;

public class Laozong implements Gongneng{
	String name;
	
	public Laozong(String name) {
		super();
		this.name = name;
	}

	public Laozong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void mubbiao() {
		System.out.println("吃饭");
		
	}

	@Override
	public void chifan() {
	System.out.println("目标");
		
	}

}
