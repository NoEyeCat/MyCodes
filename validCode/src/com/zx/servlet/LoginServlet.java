package com.zx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zx.pojo.User;
import com.zx.service.UserService;
import com.zx.service.impl.UserServiceImpl;

@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	private UserService userService;
	@Override
	public void init() throws ServletException {
	ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
	userService=ac.getBean("userServiceImpl",UserServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = req.getSession();
		String codesession = session.getAttribute("code").toString();
		String code=req.getParameter("code");
		if (codesession.equals(code)) {
			String username=req.getParameter("username");
			String userpwd=req.getParameter("password");
			User u = userService.check(username, userpwd);
			if (u!=null) {
				req.setAttribute("oper", "登录成功");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}else {
				req.setAttribute("oper", "用户名或密码错误");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}else {
			req.setAttribute("oper", "验证码错误");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
		
	}
}
