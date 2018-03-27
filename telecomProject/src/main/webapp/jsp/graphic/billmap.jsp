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
<script type="text/javascript"
	src="/telecomProject/static/easyui/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="/telecomProject/static/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="/telecomProject/static/js/echarts.js"></script>
	

<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body class="easyui-layout">
	<div>
    <div style="float: left;margin-right: 30px">
        <label>账务账号</label>
        <input class="easyui-textbox" style="width:80px;height:25px">
    </div>
    <div style="float: left;margin-right: 30px">
        <label>年份</label>
        <select class="easyui-combobox" name="state" style="width:80px;">
            <option value="2018">2018</option>
            <option value="2017">2017</option>
            <option value="2016">2016</option>
        </select>
    </div>

    <button class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="test()">查询</button>
    <div id="main" style="width: 1000px;height:500px;"></div>

    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('main'));
        function test() {
            option = {
                title : {
                    text: '2018账单图形报表',
                    x:'center'
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['一月','二月','三月','四月','五月','六月']
                },
                series : [
                    {
                        name: '资费金额',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:335, name:'一月'},
                            {value:310, name:'二月'},
                            {value:234, name:'三月'},
                            {value:135, name:'四月'},
                            {value:148, name:'五月'},
                            {value:748, name:'六月'}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };

            myChart.setOption(option);
        }
    </script>
</div>
</body>
</html>