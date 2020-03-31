package com.zx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.pojo.Airport;
import com.zx.service.AirportService;
import com.zx.service.impl.AirportServiceImpl;
@WebServlet("/upairport")
public class UpAirportServlet extends HttpServlet{
	AirportService as=new AirportServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		List<Airport> selUpPort = as.selUpPort();
		req.setAttribute("uplist", selUpPort);
		req.getRequestDispatcher("downairport").forward(req, resp);
		
	}
}
