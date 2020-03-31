<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!-- 引入jquery文件 -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<!-- 声明js代码域 -->
<script type="text/javascript">
/* 
*url:请求服务器地址
*data：服务器参数
*dataType：服务器返回的参数
*error：表示请求出错执行的功能
*success:请求成功时执行的功能 其中function（data）中的data是服务器返回的数据
*type:请求方式  post或get
*/
$(function(){
	$("a").click(function(){
		/* $.ajax({
			url:'demo',
			data:{"name":"张三"},
			dataType:'html',
			error:function(){
				alert("请求出错")
			},
			success:function(data){
				alert("请求成功"+data)
			},
			type:'POST',
		}); */
		$.post("demo",{"name":"张三"},function(data){
			var result="";
			for(var i =0 ;i<data.length;i++){
				result+="<tr>";
				result+="<td>"+data[i].uid+"</td>"
				result+="<td>"+data[i].uname+"</td>"
				result+="<td>"+data[i].upwd+"</td>"
				result+="</tr>"
			}
			//相当于js中的innerHTML先清空后添加
			$("#tbody").html(result);
			});
		return false;
	})
})

</script>
<body>
	<a href="demo">跳转</a>
	<table border="1">
		<tr>
			<td>id</td>
			<td>用户名</td>
			<td>密码</td>
		</tr>
		<tbody id="tbody"></tbody>
	</table>
</body>
</html>