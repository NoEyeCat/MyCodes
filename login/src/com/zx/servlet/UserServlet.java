package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zx.pojo.User;
import com.zx.service.UserService;
import com.zx.service.impl.UserServiceImpl;

@WebServlet("/log")
public class UserServlet extends HttpServlet{
	private UserService us;
	@Override
	public void init() throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		us = wac.getBean("UserServiceImpl",UserServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置相应编码格式
		resp.setContentType("text/html;charset=UTF-8");
		//接收请求数据
		String uname = req.getParameter("uname");
		String upwd = req.getParameter("upwd");
		//处理请求数据
		User user = us.logUser(uname,upwd);
		//返回处理结果
		if (user!=null) {
			resp.sendRedirect("main.jsp");;
		}else{
			resp.sendRedirect("index.jsp");
		}
		
	}
	
}
