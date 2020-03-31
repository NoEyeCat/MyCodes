<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- 声明CSS代码域 -->
<style type="text/css">
a {
	color: black;
	text-decoration: none;
}

a:HOVER {
	color: red;
}
</style>
</head>
<form action="fs" method="post">
	<body>
		<table border="1px">
			<tr>
				<th>花卉编号</th>
				<th>花卉名称</th>
				<th>花卉价格</th>
				<th>花卉原产地</th>
			</tr>
			<c:forEach items="${list}" var="li">
				<tr>
					<td>${li.id}</td>
					<td>${li.name}</td>
					<td>${li.price}</td>
					<td>${li.production}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="add.jsp">添加花卉信息</a>
		<input type="submit" value="查询花卉信息">
</form>
</body>
</html>