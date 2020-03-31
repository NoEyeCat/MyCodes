package com.zx.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		String uri = req.getRequestURI();
		System.out.println(uri);
		if (uri.equals("/29-springMVC05/login")) {
			return true;
		}else{
			HttpSession session = req.getSession();
			Object attribute = session.getAttribute("user");
			if (attribute!=null) {
				return true;
			}else {
				resp.sendRedirect("/29-springMVC05/login.jsp");
				return false;
			}
		}
	}

}
