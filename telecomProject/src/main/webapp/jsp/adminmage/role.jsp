<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();//得到项目名称
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
<script type="text/javascript"
	src="/telecomProject/static/js/jquery-3.3.1.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/js/jquery.json-2.4.js" charset="utf-8"></script>

<script type="text/javascript"
	src="/telecomProject/static/js/adminmage/role.js" charset="utf-8"></script>
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
	<div id="tb">
		<a id="add" href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true">新增角色</a> <a id="update"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true">修改角色</a> <a
			id="delete" href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">删除角色</a>
		<td>角色名: <input id="rname" class="easyui-textbox"
			style="width: 150px; height: 32px">
		</td>
		<td>创建人: <input id="rfounder" class="easyui-textbox"
			style="width: 150px; height: 32px">
		</td>
		</td> <a id='query' href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true">查询</a>
	</div>


	<table id="rolett" class="easyui-datagrid"
		style="width: auto; height: 100%"
		data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
		<thead>
			<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				<th
					data-options="field:'name',width:50,align:'center',sortable:true">角色</th>
				<th
					data-options="field:'founder',width:50,align:'center',sortable:true">创建人</th>
				<th
					data-options="field:'createTime',width:100,align:'center',sortable:true,
							formatter: function(value,row,index){
									var text = ''; 
									if(value != ''){
									var date = new Date(value);
									text = date.format('yyyy-MM-dd');
										}
										return text;
								}">创建日期</th>

				<th
					data-options="field:'describe',width:100,align:'center',sortable:true">描述</th>


			</tr>

		</thead>
	</table>







	<div id="add_role_dialog" class="easyui-dialog"
		style="width: 400px; height: 200px"
		data-options="title:'新增角色',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">
		<form id='add_role' method="post">
			<tr>
				<td>角色名：</td>
				<td><input class="easyui-validatebox" type="text" id="name"
					name="name" data-options="required:false" /></td>
			</tr>
			<br /> <br /> <br />
			<td>描述：</td>
			<td><input class="easyui-validatebox" required="required"
				type="text" id="describe" name="describe"
				data-options="required:false" /></td>
			</tr>
			<br />
			<div style="position: absolute; right: 0px; bottom: 0px;">
				<a id="add_r_role" href="javascript:void(0)"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-search',plain:true">添加</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-no',plain:true"
					onclick="$('#add_role_dialog').dialog('close')">取消</a>
			</div>
		</form>
	</div>
	<div id="update_role_dialog" class="easyui-dialog"
		style="width: 300px; height: 300px"
		data-options="title:'修改角色',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">

		<form id="update_r_role" method="post">

			<table style="margin: 0 auto; padding-top: 10px">
				<tr>
					<input type="hidden" name="id" id="r_id" />
					<td>权限名：</td>
					<td><input class="easyui-textbox" type="text" id="r_name"
						name="name" style="width: 150px; height: 32px" /></td>
				</tr>
				<tr>
					<td>描述：</td>
					<td><input class="easyui-textbox" type="text" id="r_describe"
						name="describe" style="width: 150px; height: 32px" /></td>
				</tr>
				<tr>
					<td>权限：</td>
					<td><input id="powerAll" class="easyui-combobox"
						name="powerAll"
						data-options="valueField:'id',textField:'text',url:'Role/findAllPowerName',method:'GET'" />

						<!--   <input id="powerAll" name="powerAll" class="easyui-combobox" data-options="width:150px,valueid:'id' textField:'text', url:'Role/findAllPowerName',method:'GET'"/> -->
					</td>
				</tr>

			</table>
		</form>
		<div
			style="position: absolute; width: 205px; margin: 0 auto; padding-top: 15px">
			<a id="updatepowers" href="Javascript:void(0)"
				class="easyui-linkbutton" iconCls="icon-ok"
				style="width: 100px; height: 32px">确定</a> <a id="not"
				href="Javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-no" style="width: 100px; height: 32px"
				onclick="$('#update_power_dialog').dialog('close')">取消</a>
		</div>
	</div>


</body>
</html>