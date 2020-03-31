package com.zx.pojo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class People {
	private int id;
	private String name;
	private Set<String> set;
	private List<String> list;
	private String[] str;
	private Map<String, String> map;
	private Desk desk;
	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	public String[] getStr() {
		return str;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setStr(String[] str) {
		this.str = str;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", set=" + set + ", list=" + list + ", str="
				+ Arrays.toString(str) + ", map=" + map + ", desk=" + desk + "]";
	}

	public People(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public People() {
		super();
		System.out.println("无参构造");
		// TODO Auto-generated constructor stub
	}
	
	
}
