<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>编号</th>
		<th>学生姓名</th>
		<th>年龄</th>
		<th>任课老师</th>
	</tr>
	<c:forEach items="${page.list}" var="stu">
		<tr>
		<td>${stu.id}</td>
		<td>${stu.name}</td>
		<td>${stu.age}</td>
		<td>${stu.teacher.name}</td>
	</tr>
	</c:forEach>
	
</table>
<a href="../stu?pageSize=${page.pageSize}&pageNumber=${page.pageNumber-1}"  <c:if test="${page.pageNumber<=1}">onclick="javascript:return false"</c:if>>上一条</a>
<a href="../stu?pageSize=${page.pageSize}&pageNumber=${page.pageNumber+1}"  <c:if test="${page.pageNumber>=page.total}">onclick="javascript:return false"</c:if>>下一条</a>
</body>
</html>