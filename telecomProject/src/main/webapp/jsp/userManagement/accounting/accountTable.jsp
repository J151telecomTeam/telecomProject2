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
<script type="text/javascript" src="/telecomProject/static/js/business.js"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body class="easyui-layout">
  <div data-options="region:'center'">
  
           <!--  <a id="addAccounting" href="javascript:void(0)" class="easyui-linkbutton"
     		data-options="iconCls:'icon-add',plain:true">新增</a> 
     		<a id="updateAccounting"
			href="javascript:void(0)" class="easyui-linkbutton"
	 		data-options="iconCls:'icon-reload',plain:true">修改</a> 
	 		<a id="deleteAccounting"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-remove',plain:true">删除</a>  -->
														
			
			<div id="tb">	
			<table>
			<tr>
			<td>账务账号：</td>
				<td><input id="account" class="easyui-validatebox"
					data-options="required:false" /></td>	
		           <td><a id="query"
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'">查询</a></td>
					<td><a id="addAccounting"
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'">新增</a></td>
					<td><a id="updateAccounting"
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-reload'">修改</a></td>
					<td><a id="deleteAccounting"
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove'">删除</a></td>
					<td><a id="stopAccounting"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true">停用</a></td>
			<td><a id="liveAccounting"
			href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true">激活</a></td>
			</tr>			
			</table>
			
			</div>
  </div>
			
 <table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>           
            <th data-options="field:'account',width:50,align:'center',sortable:'true',formatter: function(value,row,index){
				if (row.user){
					return row.user.account;
				} else {
					return value;
				}
			}">账务账号</th>
             <th data-options="field:'osAccount',width:50,align:'center',sortable:'true'">OS账号</th>
             <th data-options="field:'servicName',width:50,align:'center',sortable:'true',formatter: function(value,row,index){
				if (row.server){
					return row.server.name;
				} else {
					return value;
				}
			}">服务器名字</th>
             <th data-options="field:'type',width:50,align:'center',sortable:'true',formatter: function(value,row,index){
				
				if (row.deal){
					return row.deal.type;
				} else {
					return value;
					}
				}">资费类型</th>            
             <th data-options="field:'indentity',width:50,align:'center',sortable:'true',formatter: function(value,row,index){
				var ret = '';
				if (row.user){
					return row.user.indentity;
				} else {
					return value;
				}
				
			}">身份证</th>
             <th data-options="field:'status',width:50,align:'center',sortable:'true',
             formatter: function(value,row,index){
				var ret = '';
				if (value == 1){
					ret = '已激活';
				}else if(value == -1){
					ret = '已停用'
				}
				return ret;
			}">是否激活</th>
            
          
           
        </tr>
        </thead>         	
    </table>
      <div id="add_Accounting" class="easyui-dialog" style="width: 600px; height: 300px"
		data-options="title:'新增客户',buttons:'#add_user',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">
         
		<form id="addAccount" method="post">
		
         <table style="margin: 0 auto;padding-top: 10px">                          
                 <tr>
                    <td>账务账号:</td>
                    <td> <input id="u_account" class="easyui-textbox" style="width:150px;height:32px" name="account" data-options="required:true"></td>
                
                    <td>OS账号:</td>
                    <td> <input id="u_osAccount" class="easyui-textbox" style="width:150px;height:32px" name="osAccount" data-options="required:true"></td>
                	</tr>
                	<tr>
                    <td>服务器名字:</td>
                  
   						 <td><input class="easyui-combobox" name="servicName" id="u_servicName" 
						data-options="valueField:'id',textField:'text',url:'/telecomProject/business/server',method:'GET'" />
					</td>
					
  					 <td>身份证:</td>
                    <!-- <select id="servicid" class="easyui-combobox"  name="serverName" style="width:80px;">    						 						   						 
   						  </select> -->
   						 <td><input id="u_indentity" class="easyui-textbox" style="width:150px;height:32px" name="indentity" data-options="required:true"></td>
   						 						
                </tr>
				<tr>
                    <td>资费类型:</td>
                    <td> <select id="u_type" class="easyui-combobox" name="type" style="width:80px;">  
    				<option value="2">套餐</option>  
    				<option value="1">包月</option>  
    				<option value="3">计时</option>  
    				</select> 
                	</td>
                </tr>                                    
            </table>
	</form>
	    <div style="width: 220px;margin: 0 auto;padding-top: 15px"; id="add_users_dialog_bb">
		<a id="add_ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
        <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-no" style="width: 100px;height:32px" onclick="$('#add_Accounting').dialog('close')">取消</a>     					
	     </div>	
	</div>
	
	<div id="update_Accounting"class="easyui-dialog"
		style="width: 400px; height: 250px"
		data-options="title:'修改业务',buttons:'update_user',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">


		<form id="update_users" method="post">
			<input type="hidden" name="_method" value="put" /> 
			
			<input type="hidden" name="id" id="u_id" /> 
			<input type="hidden" name="indentity" id="u_indentity" /> 
			<input type="hidden" name="status" id="u_status" /> 
			<table style="margin: 0 auto;padding-top: 10px">
			  <tr>
					<td>OS账号</td>
					<td><input class="easyui-validatebox" type="text" id="u_osAccount" 
						name="osAccount"  style="width:150px;height:32px" data-options="required:true"/></td>
				</tr>
				
				<tr>
					<td>业务账号</td>
					<td><input class="easyui-validatebox" type="text" id="u_account" 
						name="account"  style="width:150px;height:32px" data-options="required:true"/></td>
				</tr>
				<tr>
					<td>资费类型</td>
					<td><select id="u_type" class="easyui-combobox" name="type" style="width:80px;">  
    				<option value="2">套餐</option>  
    				<option value="1">包月</option>  
    				<option value="3">计时</option>  
    				</select> </td>
				</tr>					
				<tr>
					<td>服务器名称</td>
					<td><input class="easyui-combobox" name="servicName" id="u_servicName" 
						data-options="valueField:'id',textField:'text',url:'/telecomProject/business/server',method:'GET'" /></td>								
				</tr>					
			</table>
		</form>
     <div style="width: 205px;margin: 0 auto;padding-top: 15px";id="update_users_dialog_bb">
		<a id="update_ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
        <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-no" style="width: 100px;height:32px" onclick="$('#update_Accounting').dialog('close')">取消</a>     			
        </div>
</div>
	
	

   
    
    
</body>
</html>