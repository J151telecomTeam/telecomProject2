<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

	a{
		text-decoration:none;
	}
	
	#table a{
		color:#000;
	}
	
	#table a:hover{
		color:#000;
	}

</style>
<script type="text/javascript"
	src="/telecomProject/static/js/jquery-3.3.1.min.js" charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/js/jquery.json-2.4.js" charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 150px; background: url(/telecomProject/static/img/logo.jpg) no-repeat center;">
		<p style="position: absolute; margin-top: 1px; margin-left: 75%;">欢迎您，XXX！</p>
		<a href="javascript:void(0)"
			style="position: absolute; margin-top: 1px; margin-left: 83%;">[我的信息]</a>
		<a href="javascript:void(0)"
			style="position: absolute; margin-top: 1px; margin-left: 88%;">[修改密码]</a>
		<a href="javascript:void(0)"
			style="position: absolute; margin-top: 1px; margin-left: 93%;">[退出登陆]</a>
	</div>

	<div data-options="region:'center',title:'数据列表',iconCls:'icon-ok'"
		style="padding: 5px; background: #eee;">

		<iframe id="ifr1" name="iframe"
			style="padding: 5px; width: 100%; height: 100%; background: #eee;"
			src="home.jsp"> </iframe>

	</div>

	<div id="table" data-options="region:'west',split:true" title="管理员系统"
		style="width: 230px;">
		<div class="easyui-accordion" style="font-size: 60px; width: 100%;">
			<ul class="tree easyui-tree" data-options="animate:true,lines:true">
				<li data-options="iconCls:'icon-group'"><span>服务器管理</span>
					<ul>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/serverManagement/serverTable.jsp" target="iframe">服务器管理</a></li>
					</ul></li>

				<li data-options="iconCls:'icon-group'"><span>用户管理</span>
					<ul>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/userManagement/userTable.jsp" target="iframe">用户管理</a></li>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/userManagement/accounting/accountTable.jsp" target="iframe">业务管理</a></li>
					</ul></li>

				<li data-options="iconCls:'icon-group'"><span>管理员管理</span>
					<ul>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/adminmage/admin.jsp" target="iframe">管理员列表</a></li>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/adminmage/role.jsp" target="iframe">角色管理</a></li>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/adminmage/power.jsp" target="iframe">权限管理</a></li>
					</ul></li>

				<li data-options="iconCls:'icon-group'"><span>账单系统</span>
					<ul>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/bill/bill.jsp" target="iframe">账单处理</a></li>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/bill/accounting.jsp" target="iframe">账务统计</a></li>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/bill/deal.jsp" target="iframe">资费管理</a></li>
					</ul></li>

				<li data-options="iconCls:'icon-group'"><span>图形报表</span>
					<ul>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/graphic/businessmap.jsp" target="iframe">业务图形表</a></li>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/graphic/billmap.jsp" target="iframe">账单图形表</a></li>
					</ul></li>

				<li data-options="iconCls:'icon-group'"><span>日志管理</span>
					<ul>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/loginDate/loginDateTable.jsp" target="iframe">登陆日志</a></li>
						<li data-options="iconCls:'icon-group_add'"><a href="/telecomProject/jsp/ActiveDate/ActiveDatetable.jsp" target="iframe">操作日志</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</body>
</html>