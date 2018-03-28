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
<script type="text/javascript" src="/telecomProject/static/js/easyui.demo.js"
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
		<a id="addserver" href="javascript:void(0)" class="easyui-linkbutton"
     		data-options="iconCls:'icon-add',plain:true">新增</a> 
     		<a id="updateserver"
			href="javascript:void(0)" class="easyui-linkbutton"
	 		data-options="iconCls:'icon-reload',plain:true">修改</a> 
	 		<a id="deleteserver"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">删除</a> 
			<a id="selectserver"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true">查询</a>
			<a id="stopserver"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">停用</a>
			<a id="liveserver"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">激活</a>
	</div>
 <table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:70,align:'center',sortable:true">名称</th>
            <th data-options="field:'ip',width:70,align:'center',sortable:true">服务器IP</th>
             <th data-options="field:'true',width:70,align:'center',sortable:true">是否可用</th>
             <th data-options="field:'state',width:70,align:'center',sortable:true">服务器状态</th>
        </tr>
        </thead>         	
    </table>
      <div id="add_server" class="easyui-dialog" title="服务器添加" style="width:400px;height:260px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,">
         
		<form id="add?" method="post">
			<input type="hidden" name="_method" value="put" /> <input
				type="hidden" name="id" id="u_id" /> <input type="hidden"
				name="version" id="u_version" />
				<input type="hidden" name="password" id="u_password" />
         <table style="margin: 0 auto;padding-top: 10px">
                <tr>
                    <td>服务器名称:</td>
                    <td> <input id="add_userName" class="easyui-textbox" style="width:150px;height:32px"></td>
                </tr>
                <tr>
                    <td>IP地址:</td>
                    <td> <input id="add_loginName" class="easyui-textbox" style="width:150px;height:32px"></td>
                </tr>
                
                <tr>
                    <td>出租人员上限:</td>
                    <td> <input id="add_password"  class="easyui-textbox" style="width:150px;height:32px"></td>
                </tr>
                <tr>
                    <td>维护人员：</td>
                    <td> <input id="add_password2"  class="easyui-textbox" style="width:150px;height:32px"></td>
                </tr>
                
            </table>
	</form>
	    <div style="width: 205px;margin: 0 auto;padding-top: 15px";id="add_users_dialog_bb">
		<a id="ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
        <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">取消</a> 
	     </div>	
	</div>
	
	<div id="update_server" class="easyui-dialog"
		style="width: 400px; height: 220px"
		data-options="title:'修改服务器',buttons:'#update_users_dialog_bb',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">

		<form id="update_user" method="post">
			<input type="hidden" name="_method" value="put" /> <input
				type="hidden" name="id" id="u_id" /> <input type="hidden"
				name="version" id="u_version" />
				<input type="hidden" name="password" id="u_password" />
			<table style="margin: 0 auto;padding-top: 10px">
				<tr>
					<td>服务器姓名：</td>
					<td><input class="easyui-textbox" type="text" id="u_userName" 
						name="userName" data-options="required:true" style="width:150px;height:32px"/></td>
				</tr>
				<tr>
					<td>维护人员：</td>
					<td><input class="easyui-textbox" type="text" id="u_loginName"
						name="loginName" data-options="required:true" style="width:150px;height:32px"/></td>
				</tr>
				<tr>
					<td>出租人数上限：</td>
					<td><input class="easyui-textbox" name="gender" id="u_gender" style="width:150px;height:32px"
						data-options="valueField:'id',textField:'text',url:'users/genders',method:'GET'"/>
					</td>
				</tr>
				
			</table>
		</form>
    <div style="width: 205px;margin: 0 auto;padding-top: 15px">
		<a id="ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
        <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">取消</a>
           </div>
	</div>
<div id="select_server" class="easyui-dialog" title="服务器查询" style="width:400px;height:200px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,">
            <table style="margin: 0 auto;padding-top: 10px">
                <tr>
					<td>服务器名称：</td>
					<td><input class="easyui-textbox" type="text" id="u_userName" 
						name="userName" style="width:150px;height:32px"/></td>
				</tr>
				<tr>
					<td>服务器状态：</td>
					<td><select id="cc" class="easyui-combobox" name="dept" style="width:200px;">
                         <option value="aa">无</option>
                                 <option>关闭</option>
                                 <option>开启</option>
                                 
						</select>
						</td>
				</tr>
            </table>
            <div style="width: 205px;margin: 0 auto;padding-top: 15px">
                <a id="ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
                <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">取消</a>
            </div>
    </div>   
</body>
</html>