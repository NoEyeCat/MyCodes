package com.zx.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OtherHttpController {
	//声明一个map类型的参数接收信息
		Map<String, Object> param=new HashMap<String, Object>();
	
	@PostMapping("/v1/login")
	public Object login(String id,String pwd) {
		param.clear();
		param.put("id", id);
		param.put("pwd", pwd);
		return param;
	}
	
	@PutMapping("/v1/put")
	public Object put(String id) {
		param.clear();
		param.put("id", id);
		return param;
	}
	@DeleteMapping("/v1/delete")
	public Object delete(String id) {
		param.clear();
		param.put("id", id);
		return param;
	}
	
	
	
}
