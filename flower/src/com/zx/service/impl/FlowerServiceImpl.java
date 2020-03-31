package com.zx.service.impl;

import java.util.List;

import com.zx.dao.FlowerDao;
import com.zx.dao.impl.FlowerDaoImpl;
import com.zx.pojo.Flower;
import com.zx.service.FlowerService;


public class FlowerServiceImpl implements FlowerService{
	//创建数据访问层对象
	private FlowerDao fd=new FlowerDaoImpl();
	/* 显示所有花卉
	 * @see com.zx.service.FlowerService#show()
	 */
	@Override
	public List<Flower> show() {
		
		return fd.selAll();
	}
	
	
	/* 插入新花卉
	 * @see com.zx.service.FlowerService#insFlower(com.zx.pojo.Flower)
	 */
	@Override
	public int insFlower(Flower flower) {
		
		return fd.insFlower(flower);
	}

}
