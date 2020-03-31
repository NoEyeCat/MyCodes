package com.zx.demo.pojo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



//异常自定义实体类注解
@ControllerAdvice
public class ExcHandler {
	
	/**
	 * 捕获全局异常，处理所有不可知异常
	 * @param e
	 * @param req
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	Object handleException(Exception e,HttpServletRequest req) {
		//定义map对象接收异常信息 返回json数据给前端
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 100);
		map.put("msg", e.getMessage());
		map.put("url", req.getRequestURL());
		return map;
	}
	
	@ExceptionHandler(value = {MyException.class})
	Object handleMyException(MyException e,ModelAndView mav,HttpServletRequest req) {
		/*
		 //使用ModelAndView对象跳转页面并存放信息 mav.setViewName("error.html");
		 * mav.addObject("msg", e.getMessage()); return mav;
		 */
		
		//定义map对象接收异常信息 返回json数据给前端
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", e.getCode());
		map.put("msg", e.getMessage());
		map.put("url", req.getRequestURL());
		return map;
	}
	
	
	
}
