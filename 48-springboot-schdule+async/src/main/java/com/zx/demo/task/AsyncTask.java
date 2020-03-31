package com.zx.demo.task;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;


/**
 * 异步任务测试类
 * @author zhang
 *
 */
@Async
@Component
public class AsyncTask {
	
	
	public void hello() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		System.out.println("任1务耗时："+(end-begin));
	}
	
	public void hello2() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(4000);
		long end = System.currentTimeMillis();
		System.out.println("任2务耗时："+(end-begin));
	}
	
	public void hello3() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(6000);
		long end = System.currentTimeMillis();
		System.out.println("任3务耗时："+(end-begin));
	}
	
	//--------------------------------------------------------
	
	public Future<String> hello4() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(3000);
		long end = System.currentTimeMillis();
		System.out.println("任4务耗时："+(end-begin));
		return new AsyncResult<String>("任务四");
	}
	
	public Future<String> hello5() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		System.out.println("任5务耗时："+(end-begin));
		return new AsyncResult<String>("任务五");
	}
	
	public Future<String> hello6() throws InterruptedException {
		long begin = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println("任6务耗时："+(end-begin));
		return new AsyncResult<String>("任务六");
	}
	
}
