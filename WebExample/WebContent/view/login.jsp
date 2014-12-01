<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户登陆</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="${resources}/dist/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="${resources}/dist/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${resources}/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
	function register()
	{
		
		window.location = "${ctx}/view/register.jsp";
		
	}
</script>
</head>
<body>
<div class="container">
	<form action="${ctx}/login" method="post" class="form-signin" role="form">
		<h2 class="form-signin-heading">请登陆</h2>
		<input name="userName" type="text" class="form-control" placeholder="用户名" required autofocus>
		<input name="password" type="password" class="form-control" placeholder="密码" required>
		<div class="checkbox">
			<label>
				<input type="checkbox" value="remember-me">记住账号
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>&nbsp;&nbsp;<button onclick="javascript:register()" class="btn btn-lg btn-primary btn-block" type="button">注册</button>
	</form>
</div>
</body>
</html>