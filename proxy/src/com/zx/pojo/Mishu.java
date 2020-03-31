package com.zx.pojo;

public class Mishu implements Gongneng{
	private Leader leader = new Leader("王健林");

	@Override
	public void mubiao() {
		System.out.println("有预约吗");
		leader.mubiao();
		System.out.println("吧访客信息备注");
	}

	@Override
	public void chifan() {
		System.out.println("有预约吗");
		leader.chifan();
		System.out.println("吧访客信息备注");
	}
}
