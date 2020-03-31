<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 引入jquery库 -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<!-- 声明js代码域 -->
<script type="text/javascript">
$(function(){
	$.post("show",function(data){
		var result="";
		for (var i = 0; i < data.length; i++) {
			result+="<dl>";
			result+="<dt>"+data[i].name+"</dt>";
			for (var j = 0; j < data[i].children.length; j++) {
				result+="<dd>"+data[i].children[j].name+"</dd>";
			}
			result+="</dl>";
		}
		$("body").html(result);
		//对所有父菜单添加点击事件
		//使用动态绑定
		//on("事件名",多个事件使用空格分割，function(){})
	$("dt").on("click",function(){
			$(this).siblings().toggle();
		});	
	})
});
</script>
<body>
	<dl>
		<dt>
		<dd>
	</dl>
</body>
</html>