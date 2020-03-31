package com.zx.demo.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {
	//空字段不会返回给页面
	@JsonInclude(Include.NON_NULL)
	private int id;
	//对返回字段添加别名
	@JsonProperty("用户")
	private String username;
	//jackson中的注解，过滤密码
	@JsonIgnore
	private String password;
	//制定日期的数据格式
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "ch",timezone = "GTM+8")
	private Date createTime;
	
	public Users(int id, String username, String password, Date createTime) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createTime = createTime;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
