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
<script type="text/javascript" src="/telecomProject/static/js/easyui.server.js"
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
		<a id="addServer" href="javascript:void(0)" class="easyui-linkbutton"
     		data-options="iconCls:'icon-add',plain:true">新增</a> 
     		<a id="updateServer"
			href="javascript:void(0)" class="easyui-linkbutton"
	 		data-options="iconCls:'icon-reload',plain:true">修改</a> 
	 		<a id="deleteServer"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">删除</a> 
			<a id="selectServer"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true">查询</a>
			<a id="stopServer"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">停用</a>
			<a id="liveServer"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">激活</a>
	</div>
 <table id="servertt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:70,align:'center',sortable:true">名称</th>
            <th data-options="field:'ip',width:70,align:'center',sortable:true">服务器IP</th>
             <th data-options="field:'state',width:70,align:'center',sortable:true">运行状态</th>
             <th data-options="field:'maintain',width:70,align:'center',sortable:true">服务器状态</th>
        </tr>
        </thead>         	
    </table>
    
    <div id="add_server_dialog" class="easyui-dialog"
       title="服务器添加" style="width:400px;height:260px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,">
         
		<form id="add_server" method="post">
         	<table style="margin: 0 auto;padding-top: 10px">
                <tr>
                    <td>服务器名称:</td>
                    <td> <input id="s_name" name="name" class="easyui-textbox" style="width:150px;height:32px"></td>
                </tr>
                <tr>
                    <td>IP地址:</td>
                    <td> <input id="s_ip" name="ip" class="easyui-textbox" style="width:150px;height:32px"></td>
                </tr>
                
            </table>
		</form>
	    <div style="width: 205px;margin: 0 auto;padding-top: 60px";id="add_users_dialog_bb">
			<a id="add_server_execute" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
	        <a id="add_server_nope" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" style="width: 100px;height:32px">取消</a> 
	    </div>	
	</div>
	
	
	
	<div id="update_server_dialog" class="easyui-dialog"
       title="服务器修改" style="width:400px;height:260px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

		<form id="update_server" method="post">
			<input type="hidden" name="id" id="s_id" />
			<table style="margin: 0 auto;padding-top: 10px">
				<tr>
					<td>服务器姓名：</td>
					<td><input class="easyui-textbox" type="text" id="s_name" 
						name="name" style="width:150px;height:32px"/></td>
				</tr>
				<tr>
					<td>服务器IP：</td>
					<td><input class="easyui-textbox" type="text" id="s_ip"
						name="ip" style="width:150px;height:32px"/></td>
				</tr>
			</table>
		</form>
	    <div style="width: 205px;margin: 0 auto;padding-top: 15px">
			<a id="update_server_execute" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
	        <a id="update_server_nope" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" style="width: 100px;height:32px">取消</a>
	    </div>
	</div>
	
	<div id="select_server_dialog" class="easyui-dialog" title="服务器查询" style="width:400px;height:200px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,">
            <form id="select_server" method="post">
           		<table style="margin: 0 auto;padding-top: 10px">
	                <tr>
						<td>服务器名称：</td>
						<td><input class="easyui-textbox" type="text" id="s_name" 
							name="name" style="width:150px;height:32px"/></td>
					</tr>
					<tr>
						<td>服务器状态：</td>
						<td>
							<select id="s_state" class="easyui-combobox" name="state" style="width:200px;">
	                         		<option value="无">无</option>
	                                <option value="关闭">关闭</option>
	                                <option value="开启">开启</option>
							</select>
						</td>
					</tr>
            	</table>
            </form>
            <div style="width: 205px;margin: 0 auto;padding-top: 15px">
                <a id="con_server_execute" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
                <a id="con_server_nope" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" style="width: 100px;height:32px">取消</a>
            </div>
    </div>   
</body>
</html>