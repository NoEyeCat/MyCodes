package com.zx.pojo;

import java.util.List;

public class Demo {

	private People p2;
	
	public People getP2() {
		return p2;
	}

	public void setP2(People p2) {
		this.p2 = p2;
	}

	private List<People> p;

	public List<People> getP() {
		return p;
	}

	public void setP(List<People> p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Demo [p2=" + p2 + ", p=" + p + "]";
	}


}
