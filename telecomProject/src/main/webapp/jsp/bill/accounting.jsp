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
<script type="text/javascript" src="/telecomProject/static/js/accounting.js"
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
	账务账号：<input class="easyui-textbox" style="width:155px;height:22px" id="zwAccount" /> 
         年份：<input class="easyui-textbox" style="width:155px;height:22px" id="year" />   
          月份：<select id="month" class="easyui-combobox" name="dept" style="width:80px;">  
    <option>全部</option>  
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
	</div>
	<table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">     
    <thead>
       	<tr>
         	<th data-options="field:'ck',checkbox:true"></th>
            <th
                    data-options="field:'zwAccount',width:100,align:'center',sortable:true">账务账号</th>
            <th
                    data-options="field:'osAccount',width:100,align:'center',sortable:true">OS账号</th>
            <th
                    data-options="field:'ip',width:100,align:'center',sortable:true">服务器IP</th>
            <th
                    data-options="field:'year',width:100,align:'center',sortable:true">年份</th>
           <th
                    data-options="field:'runTime',width:100,align:'center',sortable:true">年使用时长</th>
           </tr>
           
       	</thead>
       	</table>
       	
       	
	</div>
</body>
</html>