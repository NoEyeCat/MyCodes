package com.zx.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zx.demo.pojo.ServerSetting;
import com.zx.demo.pojo.Users;
//responsebody注解+controller注解
@RestController
public class GetController {
	
	//声明一个map类型的参数接收信息
	Map<String, Object> param=new HashMap<String, Object>();
	
	
	
	/**
	 * 使用ResultFul风格编码，将浏览地址后面拼接的信息通过get的方式接收后返回给页面
	 * 如果传递参数名和方法接收参数对应可以省略PathVariable注解
	 * @param cityid
	 * @param userid
	 * @return
	 */
	/*
	 * @RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)
	 * public Object finduser(@PathVariable("city_id")String
	 * cityid,@PathVariable("user_id")String userid) { param.clear();
	 * param.put("cityid", cityid); param.put("userid", userid); return param; }
	 */
	
	/**
	 * GetMapping注解等同于@requestMapping(value="",method=RequestMethod.GET)
	 * @param from
	 * @param size
	 * @return
	 */
	@GetMapping("/vi/user_page")
	public Object finduser1(String from,String size) {
		param.clear();
		param.put("from", from);
		param.put("size", size);
		return param;
	}
	
	
	/**
	 * RequestParam注解可以设置某一个参数的默认值，当用户没有填写信息时将返回默认值
	 * @param from
	 * @param size
	 * @return
	 */
	@GetMapping("/vi/user_page2")
	public Object finduser2(@RequestParam(defaultValue = "0",name = "page")String from,@RequestParam(defaultValue = "1",name = "lala")String size) {
		param.clear();
		param.put("from", from);
		param.put("size", size);
		return param;
	}
	
	
	
	/**
	 * bean对象传参
	 * 注意：1.需要指定http的头为application/json
	 * 		2.使用body传输数据
	 * @param user
	 * @return
	 */
	@RequestMapping("/vi/save_user")
	public Object finduser3(@RequestBody Users user) {
		param.clear();
		param.put("user", user);
		return param;
	}
	
	/**
	 * 获取请求头信息
	 * @param header
	 * @param id
	 * @return
	 */
	@RequestMapping("/v1/getheader")
	public Object finduser4(@RequestHeader("access_header") String header,String id) {
		param.clear();
		param.put("access_header", header);
		param.put("id", id);
		return param;
	}
	
	@Resource
	private ServerSetting serverSetting;
	@RequestMapping("/testpro")
	public Object testproperties() {
		
		return serverSetting;
	}
	
}
