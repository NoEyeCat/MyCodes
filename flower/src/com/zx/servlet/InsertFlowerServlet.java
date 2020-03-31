package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.pojo.Flower;
import com.zx.service.FlowerService;
import com.zx.service.impl.FlowerServiceImpl;
@WebServlet("/insert")
public class InsertFlowerServlet extends HttpServlet{
	private FlowerService fs=new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("name");
		String price=req.getParameter("price");
		String production=req.getParameter("production");
		Flower flower=new Flower();
		flower.setName(name);
		flower.setPrice(Double.parseDouble(price));
		flower.setProduction(production);
		int index=fs.insFlower(flower);
		if (index>0) {
			resp.sendRedirect("fs");
		}else{
			resp.sendRedirect("add.jsp");
		}
	}
}
