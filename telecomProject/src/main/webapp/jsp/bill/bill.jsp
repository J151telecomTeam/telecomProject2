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
<script type="text/javascript" src="/telecomProject/static/js/bill.js"
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
    	 客户姓名：<input class="easyui-textbox" style="width:155px;height:22px" id="##" /> 
    	 身份证号码：<input class="easyui-textbox" style="width:155px;height:22px" id="##" />    	
    	 月份：<select id="cc" class="easyui-combobox" name="dept" style="width:80px;">  
    <option value="aa">全部</option>  
    <option>1月</option>  
    <option>2月</option>  
    <option>3月</option>  
    <option>4月</option>  
    <option>5月</option>
    <option>6月</option>  
    <option>7月</option>  
    <option>8月</option>  
    <option>9月</option>  
    <option>10月</option>  
    <option>11月</option>  
    <option>12月</option>    
</select>  
    	 
    	<a id="query" href="javascript:void(0)" class="easyui-linkbutton" 
    		data-options="iconCls:'icon-search'">查询</a>
    	<a id="zhifu" href="javascript:void(0)" class="easyui-linkbutton" 
    		data-options="iconCls:'icon-redo'">支付</a>	
    	<a id="esc" href="javascript:void(0)" class="easyui-linkbutton" 
    		data-options="iconCls:'icon-undo'">返回</a>	
	</div>
	
		
	<table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">     
       	<thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th
                    data-options="field:'name',width:100,align:'center',sortable:true">客户名称</th>
            <th
                    data-options="field:'login',width:100,align:'center',sortable:true">账务账号</th>
           	<th
                    data-options="field:'feiyo',width:100,align:'center',sortable:true">费用</th>
            <th
                    data-options="field:'yue',width:100,align:'center',sortable:true">月份</th>
            <th
                    data-options="field:'zhifu',width:100,align:'center',sortable:true">支付方式</th>
            <th
                    data-options="field:'zhuantai',width:100,align:'center',sortable:true">支付状态</th>                                          				
        </tr>
     
        </thead>
        <tbody>
          <tr>
      <td>1</td>
      <td>大军</td>
      <td>0972</td>
      <td>520.00</td>
      <td>2月</td>      
      <td>支付宝</td>
      <td>未支付</td>
    
      </tr>
        </tbody>
     
    </table>
	</div>
	<div >
	<div id="update" class="easyui-dialog"
		style="width: 600px; height: 300px"
		data-options="title:'支付窗口',buttons:'#update_users_dialog_bb',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">

		<form id="update_custom" method="post">		
		
			<input type="hidden" name="_method" value="put" /> 
			<input type="hidden" name="id" id="c_id" /> 
			<input type="hidden" name="password" id="c_password" />
			<input type="hidden" class="easyui-datebox" name="createTime" id="c_createTime" />
			
			
			<table>
				<tr>
					<td>客户姓名：</td>
					<td><p>大军</p></td>
				</tr>
				<tr>
					<td>账务账号：</td>
					<td><p>9527</p>
				</tr>
				<tr>
					<td>所用费用：</td>
					<td><p>58000</p></td>
				</tr>
				<tr>
					<td>支付方式：</td>
					<td><select id="cc" class="easyui-combobox" name="dept" style="width:80px;"> 					 
    				<option>支付宝</option>  
    				<option>微信</option>   </select>
					
				</tr>
			</table>
		</form>
	<div id="update_bb">
		<a id="update_users" href="javascript:void(0)"
			class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">确定支付</a>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-no',plain:true"
			onclick="$('#update').dialog('close')">取消</a>
	</div>
	</div>
	
	</div>
</body>
</html>