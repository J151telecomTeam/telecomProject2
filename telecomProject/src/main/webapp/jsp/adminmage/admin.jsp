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
	src="/telecomProject/static/js/adminmage/admin.js" charset="utf-8"></script>
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
	<div data-options="region:'north',title:'查询条件',split:true"
		style="height: 80px;">
		<table>
			<tr>
				<td>管理员名称：</td>
				<td><input id="adminName" class="easyui-validatebox"
					data-options="required:false" /></td>
				<td>角色信息：</td>
				<td><input id="roleName" class="easyui-validatebox"
					data-options="required:false" /></td>
				<td align="center"><a id="query" href="javascript:void(0)"
					class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a></td>
			</tr>
		</table>
	</div>





	<div data-options="region:'center',title:'数据列表',iconCls:'icon-ok'"
		style="padding: 5px; background: #eee;">
		<table id="tt" class="easyui-datagrid"
			style="width: auto; height: 100%"
			data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th
						data-options="field:'name',width:70,align:'center',sortable:true">管理员姓名</th>
					<th
						data-options="field:'account',width:70,align:'center',sortable:true">管理员账号</th>
					<th
						data-options="field:'tel',width:70,align:'center',sortable:true">联系电话</th>
					<th
						data-options="field:'mail',width:70,align:'center',sortable:true">邮编</th>
					<th
						data-options="field:'role',formatter:function(val,row){
					if(val) return val.name;  
						else return ''; 
					},width:80,align:'center'">角色信息</th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="tb">
		<a id="add" href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add',plain:true">新增</a> <a id="update"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload',plain:true">修改</a> <a id="delete"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">删除</a>
	</div>


	<div id="add_controllers_dialog" class="easyui-dialog"
		style="width: 600px; height: 300px"
		data-options="title:'管理员添加',
		buttons:'#add_users_dialog_bb',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">
		<form id='add_controller'>
			<table>
				<tr>
					<td>管理员名称：</td>
					<td><input class="easyui-validatebox" type="text" id="a_name"
						name="name" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>管理员账号：</td>
					<td><input class="easyui-validatebox" type="text"
						id="a_account" name="account" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>管理员密码：</td>
					<td><input type="password" class="easyui-validatebox"
						name="password" id="a_password" data-options="required:true" /></td>
				</tr>

				<tr>
					<td>联系电话：</td>
					<td><input class="easyui-validatebox" name="tel" id="a_tel"
						data-options="required:true,validType:'Length[11]l'" /></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" class="easyui-validatebox" name="mail"
						id="a_mail" data-options="required:true,validType:'email'" /></td>
				</tr>
				<tr>
					<td>角色信息：</td>
					<td><input type="text" class="easyui-combobox" name="role"
						id="a_r_id"
						data-options="valueField:'id',textField:'text',url:'admins/role',method:'GET'" /></td>
				</tr>
			</table>
		</form>
		<div id="add_controllers_dialog_bb"
			style="position: absolute; right: 0px; bottom: 0px;">
			<a id="add_controllers" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true">添加</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-no',plain:true"
				onclick="$('#add_controllers_dialog').dialog('close')">取消</a>
		</div>

	</div>


	<div id="update_controllers_dialog" class="easyui-dialog"
		style="width: 600px; height: 300px"
		data-options="title:'修改管理员',buttons:'#update_users_dialog_bb',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">
		<form id='update_controller' method="post">
			<input type="hidden" name="_method" value="put" /> <input
				type="hidden" name="id" id="b_administrator_id" />
			<table>
				<tr>
					<td>管理员名称：</td>
					<td><input class="easyui-validatebox" type="text" id="b_name"
						name="adminName" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>管理员账号：</td>
					<td><input class="easyui-validatebox" type="text"
						id="b_account" name="adminAccount" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input class="easyui-validatebox" type="password"
						id="b_password" name="pasword" data-options="required:true" /></td>
				</tr>
				<br />
				<tr>
					<td>电话：</td>
					<td><input class="easyui-validatebox" type="text" id="b_tel"
						name="tel" data-options="required:true" /></td>
				</tr>
				<br />
				<tr>
					<td>邮箱：</td>
					<td><input class="easyui-validatebox" type="text" id="b_mail"
						name="mail" data-options="required:true" /></td>
				</tr>
				<br />
				<br />
				<tr>
					<td>角色信息：</td>
					<td><input type="text" class="easyui-combobox" name="role"
						id="b_r_id"
						data-options="valueField:'id',textField:'text',url:'admins/role',method:'GET'" /></td>
				</tr>
			</table>
		</form>
		<div id="update_controllers_dialog_bb">
			<a id="update_controllers" href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-ok',plain:true">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-no',plain:true"
				onclick="$('#update_controllers_dialog').dialog('close')">取消</a>
		</div>
	</div>







</body>
</html>