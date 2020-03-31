package com.zx.pojo;

public class Plane {
	private int id;
	private String name;
	private int time;
	private double price;
	private Airport upAirport;
	private Airport downAirport;
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setUpAirport(Airport upAirport) {
		this.upAirport = upAirport;
	}
	public Airport getDownAirport() {
		return downAirport;
	}
	public void setDownAirport(Airport downAirport) {
		this.downAirport = downAirport;
	}
	public Airport getUpAirport() {
		return upAirport;
	}
	@Override
	public String toString() {
		return "Plane [id=" + id + ", name=" + name + ", time=" + time + ", price=" + price + ", upAirport=" + upAirport
				+ ", downAirport=" + downAirport + "]";
	}
	
	
}
