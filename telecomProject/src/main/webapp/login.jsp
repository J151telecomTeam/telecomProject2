<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<td>用户名：</td>
		<td><input type="text" name="username"></input></td>
		<br />
		<td>密码：</td>
		<td><input type="password" name="password"></input></td>
		<br />
		<td>记住我</td>
		<td><input type="checkbox" name="rememberMe" /></td>
		<br/>
		<input type="submit" value="登陆"/>
	</form>
	<a href="jsp/home/adminpage.jsp">暂用登陆</a>
</body>
</html>