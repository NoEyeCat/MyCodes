<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 导入jquery文件 -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<!-- 声明js代码域 -->
<script type="text/javascript">
//页面加载 后执行
//相当于 window.onload=function(){};  $(document).ready(function(){});
$(function(){
	$("form").submit(function(){
		//表单选择器  ：input标签的type属性值
		if($(":text:eq(0)").val()==""||$(":text:eq(1)").val()==""||$(":text:eq(2)").val()=="") {
			alert("信息不能为空")
			//阻止默认行为
			return false;
		}
	});
	
	
	
});
</script>
</head>
<body>
	<form action="insert" method="post">
		<table border="1px">
			<tr>
				<th colspan="2"
					style="text-align: center; font-size: 30px; font-weight: bold;">花卉信息</th>
			</tr>
			<tr>
				<td><b>花卉名称：</b></td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td><b>花卉价格：</b></td>
				<td><input type="text" name="price" value=""></td>
			</tr>
			<tr>
				<td><b>原产地</b>：</td>
				<td><input type="text" name="production" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交">
					<input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>