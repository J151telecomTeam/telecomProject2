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
		color:#58ff00;
	}
	
	a:hover{
		color:#58ff00;
	}
	
	#table a{
		color:#000;
	}
	
	#table a:hover{
		color:#000;
	}

</style>
<script type="text/javascript" src="/telecomProject/static/js/jquery-3.3.1.min.js"
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

<iframe id="ifr1" name="iframe" style="padding: 5px;width: 100%;height: 100%; background: #eee;" src="home.jsp">

</iframe>

</div>

<div data-options="region:'west',split:true" title="用户系统"
     style="width: 230px;" id="table">
    <div class="easyui-accordion" style="font-size: 60px;width: 100%;">
        <ul class="tree easyui-tree" data-options="animate:true,lines:true">
            <li data-options="iconCls:'icon-group'"><a href="/telecomProject/jsp/userservice/userservice.jsp" target="iframe">我的服务器</a>
               
            </li>
            
             <li data-options="iconCls:'icon-group'"><a href="/telecomProject/jsp/userservice/userbill.jsp" target="iframe">我的账单</a>
               
            </li>
        </ul>
    </div>
</div>
</body>
</html>