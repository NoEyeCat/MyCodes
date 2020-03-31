<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="stu" method="post">
<input type="hidden" name="pageNumber" value="1"> 
每页显示数量为:2<input type="radio" name="pageSize" value="2" checked="checked">
3<input type="radio" name="pageSize" value="3">
4<input type="radio" name="pageSize" value="4"><br/>
学生姓名：<input type="text" name="sname">
教师姓名:<input type="text" name="tname"><br/>
<input type="submit" value="查询">
</form>
</body>
</html>