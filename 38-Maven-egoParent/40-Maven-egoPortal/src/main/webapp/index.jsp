<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
$(function(){
	var index=0;
	var imglength = ${list.size()};
	$(".imgindex").eq(index).css("background","green");
	$.each($(".adpic"),function(i,n){
		$(n).css("left",300*i+"px")
	});
	setInterval(function(){
		$.each($(".adpic"),function(i,n){
			$(n).animate({"left":parseInt($(n).css("left"))-300+"px"},1000,function(){
				//当动画执行完成之后执行的功能
				if(i==0){
					var $newimg = $(n).clone();
					$(n).remove();
					$newimg.css("left","800px");
					$("#addiv").append($newimg);
				}
			})
		}); 
		index++;
		if(index>imglength-1){
			index=0;
		}
		$(".imgindex").css("background","red");
		$(".imgindex").eq(index).css("background","green");
		}, 5000)
	})
</script>
</head>
<body>
	<div id="addiv" style="width: 300px; height: 200px; position: absolute; overflow: hidden; margin-left: 25%">
	<c:forEach items="${list }" var="pic">
		<img src="${pic.path }" width="300" height="200" style="position: absolute; left: 0px;top: 0px;" class="adpic">
	</c:forEach>
	</div>
	<div style="position: absolute; top: 180px;margin-left: 32%">
		<c:forEach begin="1" end="${list.size() }" var="step">
			<span class="imgindex" style="background-color:white;">${step }</span>
		</c:forEach>
	</div>
</body>
</html>