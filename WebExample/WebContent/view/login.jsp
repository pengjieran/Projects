<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
<script type="text/javascript">
	
	function register()
	{
		
		window.location = "${ctx}/register";
		
	}
</script>
</head>
<body>
<form action="${ctx}/login" method="post">
<table align="center" style="margin-top: 200px;">
	<tr>
		<td colspan="2" align="center">用户信息</td>
	</tr>
	<tr>
		<td>用户名:</td>
		<td><input type="text" name="userName" value="${userName}" /></td>
	</tr>
	<tr>
		<td>密&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
		<td><input type="password" name="password" value="" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="登陆" />&nbsp;&nbsp;
			<input type="button" value="注册" />&nbsp;&nbsp;
			<input type="button" value="忘记密码" />	
		</td>
	</tr>
</table>
</form>
</body>
</html>