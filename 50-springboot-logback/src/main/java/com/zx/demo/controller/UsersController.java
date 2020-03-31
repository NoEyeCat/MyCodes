package com.zx.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;







@RestController
@RequestMapping("/v5")
public class UsersController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/test")
	public void testing() {
		logger.debug("debug信息");
		logger.info("info信息");
		logger.warn("warn信息");
		logger.error("error信息");
	}
}



