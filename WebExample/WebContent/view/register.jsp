<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

</head>
<body>
<form action="${ctx}/register" method="post" enctype="multipart/form-data">
	<table align="center" style="margin-top: 200px;">
		<tr>
			<td colspan="2"><h2 class="form-signin-heading" align="center">请输入用户信息</h2></td>
		</tr>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="username" class="form-control" placeholder="用户名" required autofocus /></td>
		</tr>
		<tr>
			<td>密码:</td>
			<td><input type="password" name="password" class="form-control" placeholder="密码" required /></td>
		</tr>
		<tr>
			<td>头像上传:</td>
			<td><input type="file" name="photo" /></td>
		</tr>
		<tr>
			<td><button class="btn btn-lg btn-primary" type="submit">注册</button></td>
			<td></td>
		</tr>
	</table>
</form>
</body>
</html>