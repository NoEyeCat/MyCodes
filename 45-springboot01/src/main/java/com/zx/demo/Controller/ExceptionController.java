package com.zx.demo.Controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zx.demo.pojo.MyException;
import com.zx.demo.pojo.Users;

/**
 * 异常测试
 * @author zhang
 *
 */
@RestController
public class ExceptionController {
	
	@GetMapping("/exception")
	public Object test() {
		return new Users(1, "老王", "321", new Date());
	}
	
	@RequestMapping("exception2")
	public Object test2() {
		throw new MyException("500", "运行异常");
	}
	
	
}

