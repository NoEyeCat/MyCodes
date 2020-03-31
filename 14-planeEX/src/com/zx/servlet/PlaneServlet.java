package com.zx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.pojo.Plane;
import com.zx.service.PlaneService;
import com.zx.service.impl.PlaneServiceImpl;
@WebServlet("/plane")
public class PlaneServlet extends HttpServlet{
	private PlaneService ps=new PlaneServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码和响应编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//校验获取的用户信息
		int upid=0;
		int downid=0;
		String upIdStr=req.getParameter("upId");
		String downIdStr=req.getParameter("downId");
		
		if (upIdStr!=null&&!upIdStr.equals("")) {
			upid=Integer.parseInt(upIdStr);
		}
		
		if (downIdStr!=null&&!downIdStr.equals("")) {
			downid=Integer.parseInt(downIdStr);
		}
		//处理用户请求
		List<Plane> selPlane = ps.selPlane(upid, downid);
		System.out.println(selPlane);
		req.setAttribute("plane", selPlane);
		//返回处理结果
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
