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
<script type="text/javascript" src="/telecomProject/static/js/easyui.demo.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/telecomProject/static/js/jquery.json-2.4.js"
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
		<a id="seleteActiveDate"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true">查找</a>
	</div>
 <table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:50,align:'center',sortable:true">管理员名称</th>
            <th data-options="field:'ip',width:50,align:'center',sortable:true">联系电话</th>
             <th data-options="field:'time',width:50,align:'center',sortable:true">操作时间</th>
             <th data-options="field:'type',width:50,align:'center',sortable:true">操作类型</th>
             <th data-options="field:'miaoshu',width:50,align:'center',sortable:true">操作描述</th>
             <th data-options="field:'fanhui',width:50,align:'center',sortable:true">返回结果</th>
        </tr>
        </thead>
    </table>
    
<div id="select_ActiveDate" class="easyui-dialog" title="操作日志查询" style="width:400px;height:250px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,">
            <table style="margin: 0 auto;padding-top: 10px">
                <tr>
					<td>管理员姓名:</td>
					<td><input class="easyui-textbox" type="text" id="u_userName" 
						name="userName" style="width:150px;height:32px"/></td>
				</tr>
                <tr>
					<td>操作开始时间:</td>
					<td><input class="easyui-datebox" type="text" id="u_userName" 
						name="userName" style="width:150px;height:32px"/></td>
				</tr>
                <tr>
					<td>操作结束时间:</td>
					<td><input class="easyui-datebox" type="text" id="u_userName" 
						name="userName" style="width:150px;height:32px"/></td>
				</tr>
				
            </table>
            <div style="width: 205px;margin: 0 auto;padding-top: 15px">
                <a id="ok" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">确定</a>
                <a id="not" href="Javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" style="width: 100px;height:32px">取消</a>
            </div>
    </div>   
</body>
</html>