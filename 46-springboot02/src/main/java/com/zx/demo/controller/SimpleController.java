package com.zx.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zx.demo.domain.JsonData;



@RestController
@RequestMapping("/v2")
public class SimpleController {
	
	/**
	 * 微信支付回调接口
	 * @param msg 支付信息
	 * @return
	 */
	@RequestMapping("order")
	public Object order(String msg) {
		System.out.println("pridsadsadsadsasa");
		return JsonData.buildSuccess();
		
	}
}
