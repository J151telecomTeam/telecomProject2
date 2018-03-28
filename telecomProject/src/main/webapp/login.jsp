<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="/telecomProject/static/js/jquery-3.3.1.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/js/jquery.json-2.4.js" charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body style="width: 100%;height:100%;margin: 0px;background: url(/telecomProject/static/img/1.jpg) no-repeat;background-size: 100%;">
		
		<div style="width:450px;height:450px;background: url(/telecomProject/static/img/2.jpg) no-repeat;background-size: 100%; position:absolute;left:32%; top:25%;">
			<form action="/telecomProject/jsp/home/adminpage.jsp" method="post">
				<div style="position:absolute; margin-left:28%; margin-top: 13%;">
					<p style="height: 12px;">用户名</p><input style="width: 200px;" class="easyui-textbox" type="text" name="username"></input>
				</div>
				<div style="position:absolute; margin-left:28%; margin-top: 28%;">
					<p style="height: 12px;">密码</p><input style="width: 200px;" class="easyui-textbox" type="password" name="password"></input>
				</div>
				<div style="position:absolute; margin-left:28%; margin-top: 48%;">
					<input style="width: 80px;height: 40px;" class="easyui-linkbutton" type="submit" value="用户登陆" />
					<input style="width: 80px;height: 40px;margin-left: 39px;" class="easyui-linkbutton" type="submit" value="管理员登陆" />
				</div>
			</form>
		</div>
		
		
		
	</div>
		
	</div>
	

</body>
</html>