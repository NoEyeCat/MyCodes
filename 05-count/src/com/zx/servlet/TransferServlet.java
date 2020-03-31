package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zx.pojo.User;
import com.zx.service.UserService;
import com.zx.service.impl.UserServiceImpl;
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet{
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		//设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		//接受响应数据 
		User ou=new User();
		ou.setUno(Integer.parseInt(req.getParameter("outUno")));
		ou.setPwd(req.getParameter("pwd"));
		ou.setCount(Double.parseDouble(req.getParameter("count")));
		User iu=new User();
		iu.setName(req.getParameter("name"));
		iu.setUno(Integer.parseInt(req.getParameter("inUno")));
		iu.setCount(Double.parseDouble(req.getParameter("count")));
		//处理响应数据
		int index = us.ZZCount(iu, ou);
		//返回处理结果
		if (index==UserService.SUCCESS) {
			resp.sendRedirect("/05-count/page");
		}else{
			HttpSession session = req.getSession();
			session.setAttribute("code", index);
			resp.sendRedirect("/05-count/error/error.jsp");
		
		}
	}
}
