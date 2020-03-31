<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>转账系统</title>
</head>
<body>
	<form action="transfer" method="post">
		转账账户：<input type="text" name="outUno"><br>
		密码：<input type="password" name="pwd"><br>
		金额：<input type="text" name="count"><br>
		收款账户：<input type="text" name="inUno"><br>
		收款人姓名：<input type="text" name="name"><br>
		<input type="submit" value="转账">
	</form>
</body>
</html>