<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jqery库 -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<!-- 声明js代码域 -->
<script type="text/javascript">
	$(function(){
		var $username=false;
		var $password=false;
		$(":text").blur(function(){
			if ($(this).val()==""||$(this).val()==null) {
				$username=false;
			}else {
				$username=true;
			}
		});
		
		$(":password").blur(function(){
			if ($(this).val()==""||$(this).val()==null) {
				$password=false;
			}else {
				$password=true;
			}
		});
		$(":submit").click(function(){
			if ($username==false||$password==false) {
				alert("用户名或密码不能为空");
				return false;
			}else{
				return true;
			}
		})
	});
</script>
</head>
<body>
<form action="login" method="post">
用户名：<input type="text" name="username"><span></span><br/>
密码：<input type="password" name="password"><span></span><br/>
<button type="submit">登录</button>
<a href="/register.jsp"><button type="button" >注册</button></a><br/>
<b style="color: red;">${oper }</b>
</form>
</body>
</html>