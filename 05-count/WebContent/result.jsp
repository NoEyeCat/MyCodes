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
	<table>
  <tr>
    <th>转账账户</th>
    <th>收款账户</th>
    <th>收款人姓名</th>
    <th>转账金额</th>
  </tr>
  <tr>
    <td>${outUser.uno}</td>
    <td>${inUser.uno}</td>
    <td>${inUser.name}</td>
    <td>${inUser.count}</td>
  </tr>
</table>

</body>
</html>