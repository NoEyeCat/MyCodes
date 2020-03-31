package com.zx.pojo;

public class User {
	private int id;
	private int uno;
	private String name;
	private String pwd;
	private double count;
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(count);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + uno;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Double.doubleToLongBits(count) != Double.doubleToLongBits(other.count))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (uno != other.uno)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "InUser [id=" + id + ", uno=" + uno + ", name=" + name + ", pwd=" + pwd + ", count=" + count + "]";
	}
	public User(int id, int uno, String name, String pwd, double count) {
		super();
		this.id = id;
		this.uno = uno;
		this.name = name;
		this.pwd = pwd;
		this.count = count;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
