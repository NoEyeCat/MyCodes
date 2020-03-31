package com.zx.dao;

import java.util.List;

import com.zx.pojo.Flower;

public interface FlowerDao {
	/**
	 * 
	 * 查询全部花卉
	 * 
	 * @return
	 */
	List<Flower> selAll(); 
	
	/**
	 * 
	 * 新增新花卉
	 * 
	 * @param flower 花卉对象
	 * @return
	 */
	int insFlower(Flower flower);
}
