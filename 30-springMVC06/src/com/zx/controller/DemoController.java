package com.zx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("demo")
	public String demo(Model model){
		model.addAttribute("德玛西亚","德玛西亚的值");
		System.out.println("执行demo");
		return "index.jsp";
	}
	
}