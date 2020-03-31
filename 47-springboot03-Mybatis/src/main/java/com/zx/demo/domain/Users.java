package com.zx.demo.domain;

import java.util.Date;

public class Users {

	private int id;

	private String username;

	private String phone;

	
	private Date createTime;

	private int age;

	public Users(int id, String username, String phone, Date createTime, int age) {
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.createTime = createTime;
		this.age = age;
	}
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
