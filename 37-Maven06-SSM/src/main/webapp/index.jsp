<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 引入jquery文件 -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<!-- 声明js代码域 -->
<script type="text/javascript">
$(function(){
	var username=false;
	var password=false;
	var repassword=false;
	$(":text:eq(0)").blur(function(){
		if($(this).val()==""||$(this).val()==null){
			$(this).next().css("color","red").html("X");
			username=false;
		}else{
			$(this).next().css("color","green").html("√");
			username=true;
		};
	});
	$(":password:eq(0)").blur(function(){
		if (!$(this).val().match(/^\w{6,12}$/)) {
			$(this).next().css("color","red").html("X");
			password=false;
		}else{
			$(this).next().css("color","green").html("√");
			password=true;
		}
	});
	$(":password:eq(1)").blur(function(){
		if ($(this).val()!=$(":password:eq(0)").val()||$(this).val()==""||$(this).val()==null) {
			$(this).next().css("color","red").html("X");
			repassword=false;
		}else{
			$(this).next().css("color","green").html("√");
			repassword=true;
		}
	});
	
	$(":submit").click(function(){
		if (repassword==false||username==false||password==false) {
			alert("请填写完整信息")
			return false;
		}
	});
})

</script>
<body>
<form action="register" method="post" enctype="multipart/form-data">
用户名：<input type="text" name="username"><span></span><br/>
密码：<input type="password" name="password"><span></span><br/>
确认密码：<input type="password" name="password"><span></span><br/>
头像：<input type="file" name="file"><br/>
<button type="submit">注册</button>
</form>
</body>
</html>