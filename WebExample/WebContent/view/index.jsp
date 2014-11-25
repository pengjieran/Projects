<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>你好中国</title>
<script type="text/javascript">
	function login()
	{
		window.location = "http://localhost:8080/WebExample/login";
	}
</script>
</head>
<body>

<table>
	<tr>
		<td><input type="button" name="login" value="登陆" onclick="login()" /> </td>
	</tr>
</table>
</body>
</html>