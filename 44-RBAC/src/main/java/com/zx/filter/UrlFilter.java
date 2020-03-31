package com.zx.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zx.pojo.Url;
import com.zx.pojo.Users;
@WebFilter("/")
public class UrlFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest reqs, ServletResponse resps, FilterChain filterChain)
			throws IOException, ServletException {
		// 放行静态资源
		HttpServletResponse resp=(HttpServletResponse)resps;
		HttpServletRequest req=(HttpServletRequest)reqs;
		String uri = req.getRequestURI();
		if (uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".html")||uri.endsWith(".jpg")||uri.endsWith(".png")||uri.endsWith(".gif")) {
			filterChain.doFilter(reqs, resps);
		}else{
			if (uri.equals("/login")||uri.equals("/login.jsp")) {
				filterChain.doFilter(reqs, resps);
			}else{
				HttpSession session = req.getSession();
				Object user = session.getAttribute("user");
				if (user!=null) {
					List<Url> lsiturl = (List<Url>)session.getAttribute("allurl");
					boolean isExists=false;
					for (Url url : lsiturl) {
						if (url.getName().equals(uri)) {
							isExists=true;
						}
					}
					//如果该url需要进行权限控制
					if (isExists) {
						Users u=(Users)user;
						boolean isRight=false;
						for (Url url : lsiturl) {
							if (url.getName().equals(uri)) {
								isRight=true;
							}
							if (isRight) {
								filterChain.doFilter(reqs, resps);
							}else {
								session.removeAttribute("user");
								session.removeAttribute("allurl");
								resp.sendRedirect("/login.jsp");
							}
						}
					}else{
						filterChain.doFilter(reqs, resps);
					}
				}else{
					resp.sendRedirect("/login.jsp");
				}
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
