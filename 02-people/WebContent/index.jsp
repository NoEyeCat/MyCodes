<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索全部</title>
</head>
<body>
	<form action="ps" method="post">
		<table>
		  <tr>
		    <th>编号</th>
		    <th>姓名</th>
		    <th>年龄</th>
		  </tr>
		  <c:forEach items="${list}" var="li">
			  <tr>
			    <td>${li.id}</td>
			    <td>${li.name}</td>
			  	<td>${li.age}</td>
			  </tr>
		  </c:forEach>
		</table>
	<input type="submit" value="查看所有人信息">
	</form>
</body>
</html>