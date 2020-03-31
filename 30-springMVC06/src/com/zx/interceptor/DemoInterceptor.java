package com.zx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{
	//在进入控制器之前执行。如果返回值为false，阻止进入控制器
	//用来书写控制代码
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("preHandle");
		return true;
	}
	//控制器执行完成，进入jsp前执行、
	
	//日志记录功能
	//敏感词语过滤
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("往"+arg3.getViewName()+"跳转");
		System.out.println("德玛西亚的值为"+arg3.getModel().get("德玛西亚"));
		//arg3.getModel().put("德玛西亚修改", "德玛西亚修改后的值");
		String word = arg3.getModel().get("德玛西亚").toString();
		String newword = word.replace("敏感词语", "**");
		arg3.getModel().put("德玛西亚", newword);
		System.out.println("postHandle");
		
	}
	//jsp执行完成后执行
	//记录在执行过程中出现的异常，无论是否出现异常，该方法都会执行
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion"+arg3.getMessage());
		
	}



	

}
