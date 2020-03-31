package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.pojo.Log;
import com.zx.service.LogService;
import com.zx.service.impl.LogServiceImpl;
@WebServlet("/test")
public class LogServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Log log=new Log();
		log.setOutUno("3");
		log.setInUno("4");
		log.setMoney(100.12);
		LogService ls=new LogServiceImpl();
		int index = ls.insLog(log);
		if (index>0) {
			System.out.println("插入成功");
		}

	}
}
