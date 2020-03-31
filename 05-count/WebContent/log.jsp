<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
  <tr>
    <th>转账账号</th>
    <th>收款账号</th>
    <th>转账金额</th>
  </tr>
  <c:forEach items="${pageInfo.logList}" var="page">
  <tr>
    <td>${page.outUno }</td>
    <td>${page.inUno }</td>
    <td>${page.money }</td>
  </tr>
  </c:forEach>
</table>
<a href="page?pageNumber=${pageInfo.pageNumber-1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber<=1 }">onclick="javascript:return false"</c:if>>上一页</a>
<a href="page?pageNumber=${pageInfo.pageNumber+1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.pageNumber>pageInfo.total }">onclick="javascript:return false"</c:if>>下一页</a>
</body>
</html>