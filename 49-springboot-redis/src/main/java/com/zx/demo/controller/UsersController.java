package com.zx.demo.controller;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zx.demo.domain.JsonData;




@RestController
@RequestMapping("/v4")
public class UsersController {
	
	@Resource
	private StringRedisTemplate srt;
	
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
	
}



