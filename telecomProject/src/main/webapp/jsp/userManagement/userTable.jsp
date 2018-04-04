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
<script type="text/javascript" src="/telecomProject/static/js/easyui.demo.js"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body class="easyui-layout">
	<div id="tb">
	<tr>
	<td>姓名:</td>	
    <td> <input id="name" class="easyui-textbox" name="name"></td>
	<td>身份证：</td>
	<td><input class="easyui-textbox" type="text" id="indentity" 
		name="indentity" style="width:150px;"/></td>
	<td>地址：</td>
	<td><input class="easyui-textbox" type="text" id="address" 
		name="address"  style="width:150px;"/></td>
	<!--<td>激活状态：</td>
	 <td><select id="u_status" class="easyui-combobox" name="status" style="width:100px;">
		<option></option>
        <option value="未激活">未激活</option>
        <option value="已激活">已激活</option>
        <option value="已停用">已停用</option>            
		</select></td>	-->	
		<td><a id="query"
		    href="javascript:void(0)" class="easyui-linkbutton"
		    data-options="iconCls:'icon-search'">查询</a></td>
		<td><a id="adduser"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-add'">新增</a></td>
		<td><a id="updateuser"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-reload'">修改</a></td>
		<td><a id="deleteuser"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove'">删除</a></td>
		<td><a id="stopuser"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">停用</a></td>
		<td><a id="liveuser"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">激活</a></td>
	</tr>
	
	
	<!-- 
		    <a id="adduser" href="javascript:void(0)" class="easyui-linkbutton"
     		data-options="iconCls:'icon-add',plain:true">新增</a> 
     		<a id="updateuser"
			href="javascript:void(0)" class="easyui-linkbutton"
	 		data-options="iconCls:'icon-reload',plain:true">修改</a> 
	 		<a id="deleteuser"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">删除</a> 
			
			<a id="stopuser"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">停用</a>
			<a id="liveuser"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">激活</a>
			<a id="seleteUserById"
			href="javascript:void(0)" class="easyui-linkbutton">查看详细</a> -->
	</div>
 <table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
        <thead>
        <tr>
             <th data-options="field:'ck',checkbox:true"></th>
             <th data-options="field:'name',width:50,align:'center',sortable:true">姓名</th>
             <th data-options="field:'gender',width:50,align:'center',sortable:true">性别</th>
             <th data-options="field:'indentity',width:50,align:'center',sortable:true">身份证</th>
             <th data-options="field:'phone',width:50,align:'center',sortable:true">联系电话</th>
             <th data-options="field:'address',width:50,align:'center',sortable:true">通信地址</th>
             <th data-options="field:'postcode',width:50,align:'center',sortable:true">邮编</th>
             <th data-options="field:'qq',width:50,align:'center',sortable:true">QQ账号</th>
             <th data-options="field:'account',width:50,align:'center',sortable:true">账务账号</th>
             <th data-options="field:'status',width:50,align:'center',sortable:true">是否激活</th>
             		
           
        </tr>
        </thead>         	
    </table>
      <div id="add_user" class="easyui-dialog" style="width: 600px; height: 300px"
		data-options="title:'新增客户',buttons:'#add_user',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">
         <form id="addusers" method="post">		
         <table style="margin: 0 auto;padding-top: 10px">
                <tr>
                    <td>姓名:</td>
                    <td> <input id="add_name" class="easyui-textbox" style="width:150px;height:32px" name="name" data-options="required:true"></td>
                	<td>账务账号:</td>
                    <td> <input id="add_account" class="easyui-textbox" style="width:150px;height:32px" name="account" data-options="required:true"></td>              
                </tr>                                           
                	<tr>
                    <td>联系电话:</td>
                    <td> <input id="add_phone" type="easyui-textbox" class="easyui-textbox" style="width:150px;height:32px" name="phone" data-options="required:true,validType:'Length[11]'"></td>
                     <td>身份证号:</td>
                    <td> <input id="add_indentity" type="easyui-textbox" class="easyui-textbox" style="width:150px;height:32px" name="indentity" data-options="required:true"></td>
                </tr>
					<tr>
					<tr>
                    <td>地址:</td>
                    <td> <input id="add_address" class="easyui-textbox" style="width:150px;height:32px" name="address" data-options="required:true"></td>
                    <td>性别:</td>
                	<td>
                    	<input type="radio" checked="checked"  name='gender' value="1" >男 
        				<input type="radio" name='gender' value="0" >女  
                    </td>
                    
                </tr>
                
                <tr>
                    <td>邮编:</td>
                    <td> <input id="add_postcode" type="easyui-textbox" class="easyui-textbox" style="width:150px;height:32px" name="postcode"></td>
               		<td>QQ:</td>
                    <td> <input id="add_qq" type="easyui-textbox" class="easyui-textbox" style="width:150px;height:32px" name="qq"></td>
               
                </tr>              
            </table>
	</form>
	    <div style="width: 220px;margin: 0 auto;padding-top: 15px"; id="add_users_dialog_bb">
		<a id="ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 60px;height:32px" >确定</a>
        <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-no" style="width: 60px;height:32px"onclick="$('#add_user').dialog('close')">取消</a>     			
        <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" style="width: 90px;height:32px">文件上传</a>     
			
	     </div>	
	</div>
	
	<div id="update_user" class="easyui-dialog"
		style="width: 400px; height: 250px"
		data-options="title:'修改客户',buttons:'update_user',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">

		<form id="update_users" method="post">
			<input type="hidden" name="_method" value="put" /> 
			<input type="hidden" name="id" id="u_id" /> 
			<input type="hidden" name="name" id="u_name" />
			<input type="hidden" name="password" id="u_password" />
			<input type="hidden" name="gender" id="u_gender" />
			<input type="hidden" name="indentity" id="u_indentity" />
			<input type="hidden" name="phone" id="u_phone" />
			<input type="hidden" name="account" id="u_account" />
			<input type="hidden" name="status" id="u_status" />
			<table style="margin: 0 auto;padding-top: 10px">
				
				<tr>
					<td>邮编：</td>
					<td><input  class="easyui-validatebox" type="text" id="u_postcode"
						name="postcode"  style="width:150px;height:32px" data-options="required:true"/></td>
				</tr>
				<tr>
					<td>QQ号：</td>
					<td><input    class="easyui-validatebox" name="qq" id="u_qq" style="width:150px;height:32px" data-options="required:true"/>
					</td>
				</tr>
				<tr>
					<td>地址：</td>
					<td><input   class="easyui-validatebox" name="address" id="u_address" style="width:150px;height:32px" data-options="required:true"/>
					</td>
				</tr>
				
			</table>
		</form>
     <div style="width: 205px;margin: 0 auto;padding-top: 15px";id="update_users_dialog_bb">
		<a id="update_ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
        <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-no" style="width: 100px;height:32px" onclick="$('#update_user').dialog('close')">取消</a>     			
        </div>
</div>		     
</body>
</html>