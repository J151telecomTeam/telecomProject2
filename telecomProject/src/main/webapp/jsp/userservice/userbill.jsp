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
	<div id="tb">
		账单编号：<input id="" class="easyui-textbox" style="width:175px;heigth:22px"/>
		服务器名称：<input id="" class="easyui-textbox" style="width:175px;heigth:22px"/>
		开始时间：<input id="" class="easyui-textbox" style="width:175px;heigth:22px"/>
		结束时间：<input id="" class="easyui-textbox" style="width:175px;heigth:22px"/>
		<a id='selete' href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">精准查找</a>
	</div>
		<table id="tt" class="easyui-datagrid"
			style="width: auto; height: 100%"
			data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th
						data-options="field:'num',width:100,align:'center',sortable:true">账单编号</th>
					<th
						data-options="field:'service_name',width:100,align:'center',sortable:true">服务器名称</th>
					<th
						data-options="field:'expense',width:100,align:'center',sortable:true">缴纳费用</th>
					<th
						data-options="field:'day',width:100,align:'center',sortable:true">缴纳日期</th>
					<th
						data-options="field:'toll_collect',width:100,align:'center',sortable:true">收取人员</th>
					<th
						data-options="field:'Tariff_type',width:100,align:'center',sortable:true">资费类型</th>
				</tr>
			</thead>
		</table>
</div>
</body>
</html>