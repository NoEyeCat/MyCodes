<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 引入jquery -->
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<!-- 声明js代码域 -->
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
			//浏览器带有缓存功能，不会多次请求相同数据
			$("img").attr("src","validcode?date="+new Date());
			return false;
		})
		
	})

</script>
</head>
<body>
	<form action="log" method="post">
		用户名：<input type="text" name="username"><br /> 密码：<input
			type="password" name="password"><br /> 验证码：<input type="text"
			size="1" name="code"> <img alt="" src="validcode"
			width="80px" height="40px"> <a href="">看不清</a><br />
		<button type="submit">登录</button>
		<button type="reset">重置</button>
		<a>${oper}</a>
	</form>
</body>
</html>