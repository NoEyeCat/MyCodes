package com.zx.pojo;

public class Leader implements Gongneng{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Leader(String name) {
		super();
		this.name = name;
	}
	
	public Leader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void mubiao(){
		System.out.println("制定一个目标");
	}

	@Override
	public void chifan() {
		System.out.println("一起吃饭");
		
	}
	
}
