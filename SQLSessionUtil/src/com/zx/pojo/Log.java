package com.zx.pojo;

public class Log {
	private String id;
	private String outUno;
	private String inUno;
	private double money;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOutUno() {
		return outUno;
	}
	public void setOutUno(String outUno) {
		this.outUno = outUno;
	}
	public String getInUno() {
		return inUno;
	}
	public void setInUno(String inUno) {
		this.inUno = inUno;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inUno == null) ? 0 : inUno.hashCode());
		long temp;
		temp = Double.doubleToLongBits(money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((outUno == null) ? 0 : outUno.hashCode());
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
		Log other = (Log) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inUno == null) {
			if (other.inUno != null)
				return false;
		} else if (!inUno.equals(other.inUno))
			return false;
		if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
			return false;
		if (outUno == null) {
			if (other.outUno != null)
				return false;
		} else if (!outUno.equals(other.outUno))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Log [id=" + id + ", outUno=" + outUno + ", inUno=" + inUno + ", money=" + money + "]";
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Log(String id, String outUno, String inUno, double money) {
		super();
		this.id = id;
		this.outUno = outUno;
		this.inUno = inUno;
		this.money = money;
	}
	



}
