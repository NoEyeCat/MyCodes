package com.zx.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	
	/**
	 *调用控制器之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("prehandler");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	/**
	 *控制器后 视图之前
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("posthandler");
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 *视图之后 一般用于资源清理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("after");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
}
