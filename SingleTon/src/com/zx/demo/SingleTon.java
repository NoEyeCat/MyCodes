package com.zx.demo;

public class SingleTon {
	//由于对象需要被静态方法调用，所以该对象也为静态的
	//由于对象为静态，所以必须要设置访问权限修饰符为private
	private static SingleTon singleTon;
	/**
	 * 构造方法无返回值
	 * 方法名和类名相同
	 * 
	 * 构造方法私有化：其他类不能实例化该对象
	 * 对外提供一个访问入口
	 */
	private SingleTon(){
		
	}
	
	/**
	 * 实例方法，实例方法必须由对象调用
	 * 
	 * 设置实例方法为静态方法
	 *
	 * @return
	 */
	public static SingleTon getInstance(){
		//添加逻辑
		if (singleTon==null) {
			/*
			 * 多线程访问下可能出现if同时出现成立的情况，所以需要添加锁
			 */
			synchronized (SingleTon.class ) {
				//双重验证
				if (singleTon==null) {
					singleTon=new SingleTon();
				}
				
			}
			
		}
		return singleTon;
	}
}
