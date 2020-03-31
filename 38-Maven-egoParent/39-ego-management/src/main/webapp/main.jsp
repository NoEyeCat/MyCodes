<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<span>${opper}</span>
<table border="1px">
	<tr>
		<td width="500px">图片</td>
		<td width="200px">操作</td>
	</tr>
	<c:forEach items="${list }" var="pic">
		<tr>
			<td><img src="images/${pic.path}" width="500px"/></td>
			<td><a href="delete?id=${pic.id }">删除</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>