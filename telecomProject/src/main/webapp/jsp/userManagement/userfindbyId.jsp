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
	src="nee/static/easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body class="easyui-layout">
<div id="tb">
       <tr>
		<td>服务器名称:
		<input id="add_userName" class="easyui-textbox" style="width:150px;height:32px">
         </td>
         <td>缴费状态:
		<input id="add_userName" class="easyui-textbox" style="width:150px;height:32px">
       </td>
    
    
		<td>开始时间:
		<input id="add_userName" class="easyui-textbox" style="width:150px;height:32px">
    	</td>
    	<td>结束时间:
		<input id="add_userName" class="easyui-textbox" style="width:150px;height:32px">
   		</td>
   		<td>
		<a id="ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">查询</a>
       
		<a id="back" href="/telecomProject/jsp/userManagement/userTable.jsp" class="easyui-linkbutton" iconCls="icon-back" style="width: 100px;height:32px">返回</a>
       
        </td>
    </tr>
          
     </div>
     <table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:55,align:'center',sortable:true">服务器</th>
            <th data-options="field:'ip',width:55,align:'center',sortable:true">开通时间</th>
             <th data-options="field:'true',width:55,align:'center',sortable:true">资费模式</th>
             <th data-options="field:'state',width:55,align:'center',sortable:true">运营天数</th>
             <th data-options="field:'chuzu',width:55,align:'center',sortable:true">服务器状态</th>
             <th data-options="field:'weihu',width:55,align:'center',sortable:true">缴费状态</th>
             <th data-options="field:'weihu',width:55,align:'center',sortable:true">总缴费</th>
        </tr>
        <thead>      	
    </table>
   
</body>
</html>