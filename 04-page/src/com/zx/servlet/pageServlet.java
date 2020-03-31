package com.zx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.pojo.People;
import com.zx.pojo.pageInfo;
import com.zx.service.pageService;
import com.zx.service.impl.pageServiceImpl;
@WebServlet("/page")
public class pageServlet extends HttpServlet{
	//获取业务层对象
	private pageService ps=new pageServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		//设置响应编码
		resp.setContentType("texy/html;charset=utf-8");
		//获取请求数据
		String pageSizeStr=req.getParameter("pageSize");
		int pageSize=2;
		if ( pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr=req.getParameter("pageNumber");
		int pageNumber=1;
		if (pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		
		//处理请求数据
		pageInfo pi = ps.page(pageSize, pageNumber);
		req.setAttribute("pi", pi);
		//响应处理结果
			//重定向
		req.getRequestDispatcher("index.jsp").forward(req, resp);;
	}
}
