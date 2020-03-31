package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 *配置/为过滤所有内容，但是不过滤jsp
 *配置/*为过滤所有内容，但是不过滤jsp,html等扩展名页面
 */
@WebServlet("/")
public class DispatchaerServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = req.getParameter("control");
		if (result.equals("demo1")) {
			demo1(req,resp);
		}else if (result.equals("demo2")) {
			demo2();
		}else if (result.equals("demo3")) {
			demo3();
		}else if (result.equals("demo4")) {
			demo4();
		}
		System.out.println("执行控制器"+result);
	}
	/**
	 * 这种设计模式为front设计模式，也就是前端设计模式 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void demo1(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("demo1被调用");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	public void demo2(){
		System.out.println("demo2被调用");
	}
	public void demo3(){
		System.out.println("demo3被调用");
	}
	public void demo4(){
		System.out.println("demo4被调用");
	}
}
