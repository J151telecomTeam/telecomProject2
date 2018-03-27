<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
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
<body class="easyui-layout">
	<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="管理员信息"  style="width:800px;padding:30px 60px">
    <div style="float: left">
        <div style="margin-bottom:20px">
            <div>真实姓名</div>
            <input class="easyui-textbox" style="width:300px;height:32px" disabled>
        </div>
        <div style="margin-bottom:20px">
            <div>权限管理:</div>
            <input class="easyui-textbox" style="width:300px;height:32px" disabled>
        </div>
        <div style="margin-bottom:20px">
            <div>QQ号码:</div>
            <input class="easyui-textbox" style="width:300px;height:32px" disabled>
        </div>
        <div style="margin-bottom:20px">
            <div>联系电话:</div>
            <input class="easyui-textbox" style="width:300px;height:32px" disabled>
        </div>
        <div style="margin-bottom:20px">
            <div>居住地址:</div>
            <input class="easyui-textbox" style="width:300px;height:32px" disabled>
        </div>
        <div>
            <a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:100px;height:32px;float: right">返回</a>
        </div>
    </div>
    <div style="float:left; margin-left: 100px; margin-top: 20px">
        <div>照片:</div>
        <img src="/telecomProject/static/img/1.jpg">
    </div>
</div>
</body>
</html>