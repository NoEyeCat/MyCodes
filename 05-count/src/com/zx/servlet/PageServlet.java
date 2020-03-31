package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.pojo.Page;
import com.zx.service.UserService;
import com.zx.service.impl.UserServiceImpl;
@WebServlet("/page")
public class PageServlet extends HttpServlet{
	UserService us=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		//设置响应编码
		resp.setContentType("text/html;charset=utf-8");
		//接收用户数据
		String pageSizeStr =req.getParameter("pageSize");	
		String pageNumberStr =req.getParameter("pageNumber");	
		int pageNumber=1;
		int pageSize=2;
		if (pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize=Integer.parseInt(pageSizeStr);
		}
		if (pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		//处理用户数据
		Page p=us.resUser(pageSize, pageNumber);
		//返回处理结果
		req.setAttribute("pageInfo",p);
		req.getRequestDispatcher("/log.jsp").forward(req, resp);
	}
}
