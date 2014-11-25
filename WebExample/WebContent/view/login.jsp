<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登陆</title>
</head>
<body>
<form action="${ctx}/login" method="post">
<table align="center">
	<tr>
		<td colspan="2" align="center">用户信息</td>
	</tr>
	<tr>
		<td>用户名:</td>
		<td><input type="text" name="userName" value="${userName}" /></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="password" name="password" value="" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="登陆" />&nbsp;&nbsp;</td>
	</tr>
</table>
</form>
</body>
</html>