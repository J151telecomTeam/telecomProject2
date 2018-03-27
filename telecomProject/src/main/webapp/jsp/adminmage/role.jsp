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
	
<script type="text/javascript" src="/telecomProject/static/js/adminmage/role.js"
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
			<a id="add" href="javascript:void(0)" class="easyui-linkbutton"data-options="iconCls:'icon-add',plain:true">新增角色</a>
			<a id="update"href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">修改角色</a>
			<a id="delete" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除角色</a>
			<a id='selete' href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
	</div>
 <table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:50,align:'center',sortable:true">角色</th>
            <th data-options="field:'login',width:50,align:'center',sortable:true">创建人</th>
            <th data-options="field:'birthday',width:100,align:'center',sortable:true,
							formatter: function(value,row,index){
									var text = ''; 
									if(value != ''){
									var date = new Date(value);
									text = date.format('yyyy-MM-dd');
										}
										return text;
								}">创建日期</th>
         
			<th data-options="field:'login',width:100,align:'center',sortable:true">描述</th>
                  
                 
        </tr>
        
        </thead>
    </table>
</div>

<div id="tb">
		<a id="add" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增角色</a> 
		<a id="update" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">修改角色</a> 
		<a id="delete" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除角色</a>
		<a id='selete' href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
	</div>
	
	<div id="find_users_dialog" class="easyui-dialog"
			style="width: 600px; height: 300px"
			data-options="title:'角色查询',buttons:'#add_users_dialog_bb',modal:true,
			collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">
		<form id='find_user' method="post">
			
				<tr>
					<td>姓名：</td>
					<td><input class="easyui-validatebox" type="text" id="ondate" name="onDate" data-options="required:false" /></td>
				</tr><br/>
				
			<br/>	
			<tr>
					<td>角色：</td>
					<td><input class="easyui-validatebox" type="text" id="ondate" name="onDate" data-options="required:false" /></td>
				</tr><br/>
						<tr>
					<td>性别：</td>
					<td><input class="eeasyui-validatebox" type="text" id="ondate" name="onDate" data-options="required:false" /></td>
				</tr><br/>
						<tr>
					<td>开始日期：</td>
					<td><input class="easyui-datebox" type="text" id="ondate" name="onDate" data-options="required:false" /></td>
				</tr><br/>
						<tr>
					<td>结束日期：</td>
					<td><input class="easyui-datebox" type="text" id="ondate" name="onDate" data-options="required:false" /></td>
				</tr><br/>
			
			<div style="position:absolute;right:0px;bottom:0px;">
				<a id="find_users" href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">查询</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-no',plain:true"
			onclick="$('#find_users_dialog').dialog('close')">取消</a>
			</div>
		</form>
	</div>
	
	
	<div id="add_users_dialog" class="easyui-dialog"
			style="width: 600px; height: 300px"
		data-options="title:'新增角色',buttons:'#add_users_dialog_bb',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">
		<form id='find_user' method="post">
				<tr>
					<td>角色名：</td>
					<td><input class="easyui-validatebox" type="text" id="username"
						name="userName" data-options="required:false" /></td>
				</tr><br/>
				<tr>
					<td>角色类型：</td>
					<td style="text-align:left">
            <span class="radioSpan">
                <input type="radio" name="adminFlag" value="0">用户管理</input>
                <input type="radio" name="adminFlag" value="1">账单管理</input>
                <input type="radio" name="adminFlag" value="0">日志管理</input>
            </span>
        </td>
				
				</tr><br/>
				
			<br/>
					<td>描述：</td>
					<td><input class="easyui-validatebox" required="required" type="text" id="ondate"
						name="onDate" data-options="required:false" /></td>
				</tr><br/>
			<div style="position:absolute;right:0px;bottom:0px;">	
			<a id="add_users" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">添加</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-no',plain:true" 
																				onclick="$('#add_users_dialog').dialog('close')">取消</a>
			</div>
		</form>
	</div>



</body>
</html>