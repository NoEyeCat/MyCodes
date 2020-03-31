package com.zx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.pojo.Demo;
import com.zx.pojo.People;

@Controller
public class DemoController {
	@RequestMapping("demo")
	public String demo(@RequestParam(value="name")String name,@RequestParam(value="age")int age){
		System.out.println("执行代码"+name+"    "+age);
		return "/main.jsp";
	}
	@RequestMapping("demo2")
	public String demo2(People p,HttpServletRequest req){
		System.out.println("执行demo2"+p);
		req.setAttribute("demo2", "我来了");
		return "main.jsp";
	}
	@RequestMapping("demo3")
	public String demo3(@RequestParam(defaultValue="2")int pageSize,@RequestParam(defaultValue="1")int pageNumber){
		System.out.println("执行demo3");
		return "main.jsp";
	}
	@RequestMapping("demo4")
	public String demo4(@RequestParam(required=true)String name){
		System.out.println("name是sql的查询条件，必须要传递name参数"+name);
		return "main.jsp";
	}
	@RequestMapping("demo5")
	public String demo5(String name,String age,@RequestParam("hover")List<String> hover){
		System.out.println("接收多个参数的集合"+name+"   "+age+"  "+hover);
		return "main.jsp";
	}
	@RequestMapping("demo6")
	public String demo6(Demo d){
		System.out.println(d);
		return "main.jsp";
	}
	
	@RequestMapping("demo7")
	public String demo7(String name,int id){
		System.out.println(name+"  "+id);
		return "main.jsp";
	}
	@RequestMapping("demo8/{id}/{name}")
	public String demo8(@PathVariable String name,@PathVariable int id){
		System.out.println(name+"  "+id);
		return "/main.jsp";
	}
	@RequestMapping("demo9")
	public String demo9(){
		return "redirect:/main.jsp";
	}
	@RequestMapping(value="demo10",produces="text/html;charset=utf-8")
	@ResponseBody
	public String demo10(People p){
		p.setAge(12);
		p.setName("张三");
		return "我来饿了";
	}
}