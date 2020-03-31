package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zx.pojo.PageInfo;
import com.zx.service.StudentService;
import com.zx.service.impl.StudentServiceImpl;
@WebServlet("/stu")
public class StudentServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentService ss=new StudentServiceImpl();
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//接收请求数据
		String pageSizeStr = req.getParameter("pageSize");
		String pageNumberStr = req.getParameter("pageNumber");
		String sname=req.getParameter("sname");
		String tname=req.getParameter("tname");
		//处理请求数据
		PageInfo page = ss.selStudents(sname, tname, pageSizeStr, pageNumberStr);
		//返回处理结果
		HttpSession session=req.getSession();
		System.out.println(session==null);
		if (page!=null&&page.getTotal()!=0) {
			session.setAttribute("page", page);
			resp.sendRedirect("/09-selectEX/success/success.jsp");
		}else {
			resp.sendRedirect("/09-selectEX/error/error.jsp");
		}
		
	}
}
