<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
<script type="text/javascript" src="/telecomProject/static/js/jquery-3.3.1.min.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/telecomProject/static/js/jquery.json-2.4.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/telecomProject/static/easyui/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body class="easyui-layout">
	<div>
		<div style="position: absolute; left: 600px;top:10px">
			<h1>个人信息</h1>
		</div>
		<div>
			<div style="position: absolute; left: 400px;top:200px">
				<span>姓名：</span><span id='name'></span>
			</div>
				
			<div style="position: absolute; left: 700px ;top:200px">
				<span>账务账号：</span><span id='acc'></span>
			</div>
			
			<div style="position: absolute;left: 400px ;top:250px">
				<span>QQ号：</span><span id='QQ'></span>
			</div>
			
			<div style="position: absolute;left: 700px ;top:250px">
				<span>联系电话：</span><span id='tel'></span>
			</div>
			
			<div style="position: absolute;left: 400px ;top:300px">
				<span>地址：</span><span id='address '></span>
			</div>
			
			<div style="position: absolute;left: 700px ;top:300px">
				<span>个人头像：</span><span id='head'></span>
			</div>
		</div>
	</div>
</body>
</html>