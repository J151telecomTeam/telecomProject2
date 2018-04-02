<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
<script type="text/javascript"
	src="/telecomProject/static/js/jquery-3.3.1.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/js/jquery.json-2.4.js" charset="utf-8"></script>
<script type="text/javascript" src="/telecomProject/static/js/bill.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/jquery.easyui.min.js"
	charset="utf-8"></script>

<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>

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
	<div data-options="region:'center'">
		<div id="tb">
			账务账号：<input class="easyui-textbox" style="width: 155px; height: 22px"
				id="zwAccount" /> 身份证号码：<input class="easyui-textbox"
				style="width: 155px; height: 22px" id="idcard" /> 年-月<input
				id="attYearMonth" editable="false" name="attYearMonth"
				class="easyui-datebox" style="width: 172px" /> <a id="query"
				href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search'">查询</a> <a id="zhifu"
				href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-redo'">支付</a> 
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
						data-options="field:'idCard',width:100,align:'center',sortable:true">身份证号</th>
					<th 
						data-options="field:'price',width:100,align:'center',sortable:true">当月费用</th>
					<th 
						data-options="field:'date',width:100,align:'center',sortable:true">月份</th>
					<th 
						data-options="field:'payWay',width:100,align:'center',sortable:true">支付方式</th>
							<th
						data-options="field:'state',width:100,align:'center',
			formatter: function(value,row,index){
				var ret = '';
				if (value == '1'){
					ret = '已支付';
				} else if(value == '0'){
					ret = '未支付';
				}
				return ret;
			}
					">支付状态</th>
				</tr>

			</thead>

		</table>
	</div>
	<div>
		<div id="update" class="easyui-dialog"
			style="width: 600px; height: 300px"
			data-options="title:'支付窗口',buttons:'#update_users_dialog_bb',modal:true,
		collapsible:true,minimizable:true,maximizable:true,resizable:true,closable:true,closed:true">

			<form id="update_custom" method="post">

				<input type="hidden" name="_method" value="put" /> <input
					type="hidden" name="id" id="c_id" /> <input type="hidden"
					name="password" id="c_password" /> <input type="hidden"
					class="easyui-datebox" name="createTime" id="c_createTime" />


				<table>
					<tr>
						<td>账务账号：</td>
						<td><label id="zwCard"></label></td>
					</tr>
					<tr>
						<td>支付费用：</td>
						<td><input class="easyui-validatebox" type="text" id="price"
						name="##" data-options="required:true" /></td>
					</tr>
					<tr>
						<td>支付方式：</td>
						<td><select id="payWay" class="easyui-combobox" name="dept"
							style="width: 80px;">
								<option>支付宝</option>
								<option>微信</option>
								<option>现金</option>
						</select>
					</tr>
				</table>
			</form>
			<div id="update_bb">
				<a id="surePay" href="javascript:void(0)"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-ok',plain:true">确定支付</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-no',plain:true"
					onclick="$('#update').dialog('close')">取消</a>
			</div>
		</div>

	</div>
</body>
</html>