package com.zx.demo.Controller;

import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zx.demo.pojo.Users;
@SpringBootApplication
@RestController
public class SimpleController {
	
	
	@RequestMapping("/test/home")
	public String testDemo() {
		return "test demo";
	}
	
	
	@GetMapping("/testjson")
	public Object testjson() {
		return new Users(1, "123", "321", new Date());
	}
}
