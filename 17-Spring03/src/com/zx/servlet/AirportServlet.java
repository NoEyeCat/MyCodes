package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zx.service.AirportService;
import com.zx.service.impl.AirportServiceImpl;
@WebServlet("/airport")
public class AirportServlet extends HttpServlet{
	private AirportService airportService;
	
	@Override
	public void init() throws ServletException {
		//对service进行实例化
		//ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//spting和web整合后所有信息都存放在webApplicationContext
		WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		airportService = ac.getBean("airportServiceImpl",AirportServiceImpl.class);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", airportService.show());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
