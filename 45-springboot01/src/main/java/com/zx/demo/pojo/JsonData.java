package com.zx.demo.pojo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonData implements Serializable{
	private static final long serialVersionUID = 1L;
	//状态码 0表示成功 -1表示失败
	private int code;
	//结果
	@JsonIgnore
	private Object data;
	//错误信息
	private String msg;
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public JsonData(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	
}
