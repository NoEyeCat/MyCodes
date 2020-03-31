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
		<th>机场名</th>
		<th>城市</th>
	</tr>
	<c:forEach items="${list}" var="li">
	<tr>
		<td>${li.portName }</td>
		<td>${li.cityName }</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>