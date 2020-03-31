package com.zx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zx.pojo.People;
import com.zx.service.PeopleService;
import com.zx.service.impl.PeopleServiceImpl;
//大部分注解都有其默认属性，如果注解中只给默认属性赋值，那么可以省略属性名
//否则在注解中需要按照属性名=属性值的格式赋值
//如果一个属性是数组类型 那么格式为：属性名={值，值....}如果该数据只有一个值，那么可以省略大括号
//如果类型不是基本数据类型或string类型，而是一个类类型那么语法为 属性名=@类型
//注解中@表示引用一个注解声明的意思
@WebServlet("/ps")
public class PeopleServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码
		req.setCharacterEncoding("utf-8");
		//设置相应编码
		resp.setContentType("text/htm;charset=utf-8");
		//获取用户数据
		
		//处理用户数据
			//创建servie层对象
		PeopleService ps=new PeopleServiceImpl();
		List<People> list = ps.selAll();
		req.setAttribute("list",list );
		//返回处理结果
			//请求转发
		//相对路径 
		//只要路径中是以/开头的都叫做全路径，不以/开头的为相对路径
		//如果请求转发  前面的/代表webcontent目录
		//如果是重定向，静态资源引用（img图片 js、jq引用 css引用 其中名字最前面的/都表示tomcat的webapps文件夹）
		//webapps为服务器根目录
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
