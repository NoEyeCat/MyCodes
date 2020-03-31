package com.zx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.pojo.Flower;
import com.zx.service.FlowerService;
import com.zx.service.impl.FlowerServiceImpl;
@WebServlet("/fs")
public class FlowerServlet extends HttpServlet{
	//获取servece层对象
	FlowerService fs=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Flower> list = fs.show();
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
