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
<script type="text/javascript" src="/telecomProject/static/js/deal.js"
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
	<div data-options="region:'center'">	   	 
    	<div id="tb">
    	资费类型：<select id="cc" class="easyui-combobox" name="dept" style="width:80px;">  
    	<option value="0">包月</option>  
   		<option value="1">计时</option>  
   	    <option value="2">套餐</option>  
    	</select>
    	<a id="query" href="javascript:void(0)" class="easyui-linkbutton" 
    		data-options="iconCls:'icon-search'">查询</a>
    	<a id="add" href="javascript:void(0)" class="easyui-linkbutton"data-options="iconCls:'icon-add',plain:true">添加</a> 
    	<a id="update" href="javascript:void(0)" class="easyui-linkbutton"data-options="iconCls:'icon-reload',plain:true">修改</a> 
    	<a id="delete" href="javascript:void(0)" class="easyui-linkbutton"data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a id='save' href="javascript:void(0)" class="easyui-linkbutton"data-options="iconCls:'icon-redo',plain:true">开通</a>
    	<a id='remove' href="javascript:void(0)" class="easyui-linkbutton"data-options="iconCls:'icon-cancel',plain:true">暂停</a>
    	</div>
  		 <table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">     
       	<thead>
       	 <tr>       
            <th
                    data-options="field:'a',width:100,align:'center',sortable:true">业务账号</th>
            <th
                    data-options="field:'b',width:100,align:'center',sortable:true">资费名称</th>
           	<th
                    data-options="field:'c',width:100,align:'center',sortable:true">资费类型</th>
            <th
                    data-options="field:'d',width:100,align:'center',sortable:true">基本费用(RMB)</th>
            <th
                    data-options="field:'e',width:100,align:'center',sortable:true">资费说明</th>                                                  				
        </tr>
        </thead>
        </table>
        
</div>
<div>
		<div id="add_deal" class="easyui-dialog"
		style="width: 300px; height: 300px"
		data-options="title:'新增资费',buttons:'#add_users_dialog_bb',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">
		<form id="add_deal_form" method="post">								
			<table>
				<tr>
					<td>资费名称：</td>
					<td><input class="easyui-validatebox" type="text" id="##"
						name="##" data-options="required:true" /></td>				
				</tr>
				<tr>
					<td>资费类型：</td>
					<td><input class="easyui-validatebox" type="text" id="##"
						name="##" data-options="required:true" /></td>				
				</tr>
					<tr>
					<td>资费费用：</td>
					<td><input class="easyui-validatebox" type="text" id="##"
						name="##" data-options="required:true" required="required"/></td>				
				</tr>
				</tr>
					<tr>
					<td>资费说明：</td>
					<td><input class="easyui-validatebox" type="text" id="##"
						name="##" data-options="required:true" /></td>				
				</tr>
			</table>
		</form>
		<div id="add_id">
		<a id="add_deal_y" href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">确定</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-no',plain:true"
			onclick="$('#update').dialog('close')">取消</a>
	</div>
		</div>
	
	<div id="update_deal" class="easyui-dialog"
		style="width: 300px; height: 300px"
		data-options="title:'修改客户',buttons:'#update_users_dialog_bb',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">

		<form id="update_deal_form" method="post">		
		
			<input type="hidden" name="_method" value="put" /> 
			<input type="hidden" name="id" id="c_id" /> 								
			<table>
				<tr>
					<td>资费名称：</td>
					<td><input class="easyui-validatebox" type="text" id="c_customName"
						name="customName" data-options="required:true" /></td>
				</tr>
				<tr>
					<td>资费类型：</td>
					<td><input class="easyui-validatebox" type="text" id="c_loginName"
						name="loginName" data-options="required:true" /></td>
				</tr>
			
					<tr>
					<td>资费费用：</td>
					<td><input class="easyui-validatebox" type="text" id="##"
						name="##" data-options="required:true" required="required"/></td>				
				</tr>
				
					<tr>
					<td>资费说明：</td>
					<td><input class="easyui-validatebox" type="text" id="##"
						name="##" data-options="required:true" /></td>				
				</tr>
			</table>
		</form>
		<div id="update_deal_dd">
		<a id="update_deal_y" href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">修改</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-no',plain:true"
			onclick="$('#update_users_dialog_bb').dialog('close')">取消</a>
		</div>
    
	</div>
	
		
		</div>
</body>
</html>