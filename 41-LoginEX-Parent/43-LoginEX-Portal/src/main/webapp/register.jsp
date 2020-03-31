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
		var $repassword=false;
		$(":text").blur(function(){
			if ($(this).val()==""||$(this).val()==null) {
				$(this).next().css("color","red").html("X");
				$username=false;
			}else {
				$(this).next().css("color","green").html("√");
				$username=true;
			}
		});
		
		$(":password:eq(0)").blur(function(){
			if (!$(this).val().match(/^\w{6,12}$/)) {
				$(this).next().css("color","red").html("X");
				$password=false;
			}else {
				$(this).next().css("color","green").html("√");
				$password=true;
			}
		});
		
		$(":password:eq(1)").blur(function(){
			if ($(this).val()!=$(":password:eq(0)").val()) {
				$(this).next().css("color","red").html("X");
				$repassword=false;
			}else {
				$(this).next().css("color","green").html("√");
				$repassword=true;
			}
		});
		
		$(":submit").click(function(){
			if ($username==false||$password==false||$repassword==false) {
				alert("请填写正确信息");
				return false;
			}else{
				return true;
			}
		})
	});
</script>
</head>
<body>
<form action="register" method="post">
用户名：<input type="text" name="username"><span></span><br/>
密码：<input type="password" name="password"><span></span><br/>
确认密码：<input type="password" name="repassword"><span></span><br/>
<button type="submit">注册</button>
</form>
</body>
</html>