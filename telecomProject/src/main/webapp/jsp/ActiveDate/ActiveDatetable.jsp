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
<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="/telecomProject/static/js/Change.js"
	charset="utf-8"></script>

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
	
<script type="text/javascript">
	/**
	 * 日期格式化函数
	 */
	function dateformatter(date) {
		var y = date.getFullYear();
		var m = date.getMonth() + 1;
		var d = date.getDate();
		return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
				+ (d < 10 ? ('0' + d) : d);
	}
</script>	
	
</head>
<body class="easyui-layout">
	<div id="tb">
	<table style="margin: 0 auto;padding-top: 10px">
                <tr>
					<td>管理员姓名:</td>
					<td><input class="easyui-validatebox" type="text" id="name" 
						name="name" style="width:150px;height:32px"/></td>
			
					<td>操作开始时间:</td>
					<td><input class="easyui-datebox" type="text" id="ontime" 
						name="ontime" style="width:150px;height:32px"
						data-options="required:false,formatter:dateformatter"/></td>
				
					<td>操作结束时间:</td>
					<td><input class="easyui-datebox" type="text" id="endtime" 
						name="endtime" style="width:150px;height:32px"
						data-options="required:false,formatter:dateformatter"/></td>
						
						
					<td><a id="seleteActiveDate"
			href="javascript:void(0)" class="easyui-linkbutton"
			data-options="iconCls:'icon-search',plain:true">查找</a></td>
				</tr>
            </table>
	</div>
 <table id="tt" class="easyui-datagrid"
           style="width: auto; height: 100%"
           data-options="fitColumns:true,method:'GET',idField:'id',striped:true,singleSelect:false,toolbar:'#tb',pagination:true">
        <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:50,align:'center',sortable:true">管理员名称</th>
            <th data-options="field:'account',width:50,align:'center',sortable:true">账号</th>
             <th data-options="field:'changeTime',width:50,align:'center',sortable:true,
			formatter: function(value,row,index){
				var text = ''; 
				if(value != ''){
					var date = new Date(value);
					text = date.format('yyyy-MM-dd');
				}
				return text;
			}">操作时间</th>
             <th data-options="field:'type',width:50,align:'center',sortable:true">操作类型</th>
             <th data-options="field:'description',width:50,align:'center',sortable:true">操作描述</th>
             <th data-options="field:'result',width:50,align:'center',sortable:true">返回结果</th>
        </tr>
        </thead>
    </table>
</body>
</html>