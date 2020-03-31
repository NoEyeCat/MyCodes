package com.zx.demo.controller;

import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zx.demo.domain.JsonData;
import com.zx.demo.task.AsyncTask;




@RestController
@RequestMapping("/v4")
public class UsersController {
	
	@Resource
	private StringRedisTemplate srt;
	@Resource
	AsyncTask asT;
	
	@RequestMapping("add")
	public Object add() {
		//利用模板操作一个值
		srt.opsForValue().set("k1", "v1");
		return JsonData.buildSuccess("ok");
	}
	
	@RequestMapping("get")
	public Object get() {
		String string = srt.opsForValue().get("k1");
		return string;
	}
	
	@RequestMapping("async")
	public Object task() throws InterruptedException {
		long begin = System.currentTimeMillis();
		//asT.hello();
		//asT.hello2();
		//asT.hello3();
		
		Future<String> hello4 = asT.hello4();
		Future<String> hello5 = asT.hello5();
		Future<String> hello6 = asT.hello6();
		for (;;) {
			if (hello4.isDone()&&hello5.isDone()&&hello6.isDone()) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("任务总耗时"+(end-begin));
		return JsonData.buildSuccess("去看控制台");
	}
	
	
	
}



