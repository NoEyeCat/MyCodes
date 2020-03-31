package com.zx.service;

import java.util.List;

import com.zx.pojo.Flower;

public interface FlowerService {
	/**
	 * 显示所有花卉
	 * @return
	 */
	List<Flower> show();
	
	/**
	 * 
	 * 插入新花卉
	 * @param flower 花卉对象
	 * @return
	 */
	int insFlower(Flower flower);
}
