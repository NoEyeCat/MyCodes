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
<dl>
<c:forEach items="${user.menus }" var="menu">
	<dt>${menu.name}</dt>
	<c:forEach items="${menu.children }" var="child">
		<dd>${child.name}</dd>
	</c:forEach>
</c:forEach>
</dl>

<c:forEach items="${user.elements }" var="element">
	<c:if test="${element.eleno eq 'grant'}" var="ele">
		<button type="button" eleno="grant">授权</button>
	</c:if>
</c:forEach>

<button type="button">新增</button>

<a href="/demo">所有管理</a>

</body>
</html>