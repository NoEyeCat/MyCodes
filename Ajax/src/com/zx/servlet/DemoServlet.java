package com.zx.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zx.pojo.User;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("执行控制器");
		String name = req.getParameter("name");
		
		User user=new User();
		user.setUname("张三");
		user.setUpwd("321");
		user.setUid(3);
		
		User user1=new User();
		user1.setUname("dsa");
		user1.setUpwd("321222");
		user1.setUid(4);
		
		List<User> list =new ArrayList<User>();
		
		list.add(user);
		list.add(user1);
		
		ObjectMapper mapper = new ObjectMapper();
		String string = mapper.writeValueAsString(list);
		
		
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print(string);
		out.flush();
		out.close();
	}
}
