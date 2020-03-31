<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 引入jquery外部文件 -->
<script type="text/javascript" src=""/14-planeEX/js/jquery-1.7.2.js""></script>
<!-- 声明js代码域 -->
<script type="text/javascript">
$(function(){
	location.href="/airport"
})
</script>

</head>
<body>
<form action="upairport" method="post">
起飞机场：
<select name="upId">
	<option value="">--请选择--</option>
	<c:forEach items="${uplist }" var="up">
		<option value="${up.id }">${up.portName}</option>
	</c:forEach>
</select>
降落机场：
<select name="downId">
	<option value="">--请选择--</option>
	<c:forEach items="${downlist }" var="down">
		<option value="${down.id }">${down.portName}</option>
	</c:forEach>
</select>

<input type="submit">
<table border="1px">
  <tr>
    <th>飞机编号</th>
    <th>起飞机场</th>
    <th>起飞城市</th>
    <th>降落机场</th>
    <th>降落城市</th>
    <th>航行时间</th>
    <th>票价</th>
  </tr>
 	<c:forEach items="${plane }" var="pla">
 	 <tr>
	    <td>${pla.name}</td>
	    <td>${pla.upAirport.portName}</td>
	    <td>${pla.upAirport.cityName}</td>
	    <td>${pla.downAirport.portName}</td>
	    <td>${pla.downAirport.cityName}</td>
	    <c:choose>
	    	<c:when test="${pla.time>=60}">
	    		<td>${Math.floor(pla.time/60)}小时${pla.time%60}分钟</td>
	    	</c:when>
	    	<c:otherwise>
	    		<td>${pla.time}分钟</td>
	    	</c:otherwise>
	    </c:choose>
	    <td>${pla.price}<td>
 	 </tr>
 	</c:forEach>
</table>
</form>
</body>
</html>