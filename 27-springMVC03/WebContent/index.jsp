<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
request:${requestScope.req}<br/>
session1:${sessionScope.session1}<br/>
session2:${sessionScope.session2}<br/>
application:${applicationScope.application}<br/>
<hr>
map:${map}
<hr>
model:${model}
<hr>
mav:${mav}

</body>
</html>