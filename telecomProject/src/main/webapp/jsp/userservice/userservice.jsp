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
<script type="text/javascript" src="/telecomProject/static/js/easyui.userserver.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body class="easyui-layout">
	<div id="tb">
		服务器名称：<input id="" class="easyui-textbox" style="width:175px;heigth:22px"/>
		<a id='selete' href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">精准查找</a>
		<div style="float: right; margin-top: -12px; margin-right: 5%;">
		</div>
	</div>
<table id="usertt" class="easyui-datagrid"
			style="width: auto; height: 100%"
			data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th
						data-options="field:'name',width:100,align:'center',sortable:true">服务器名称</th>
					<th
						data-options="field:'ip',width:100,align:'center',sortable:true">服务器IP</th>
					<th
						data-options="field:'maintain',width:100,align:'center',sortable:true">服务器状态</th>
					<th
						data-options="field:'state',width:100,align:'center',sortable:true">运行状态</th>
				</tr>
			</thead>
		</table>
</body>
</html>