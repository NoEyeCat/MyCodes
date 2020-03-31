<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post" enctype="multipart/form-data">
广告图片：<input type="file" name="file"><br/>
<button type="submit">提交</button>
<button type="submit" formaction="show">查看图片</button>

</form>
</body>
</html>