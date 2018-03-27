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
<script type="text/javascript"
	src="/telecomProject/static/js/echarts.js"></script>


<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="/telecomProject/static/easyui/themes/icon.css">
</head>
<body class="easyui-layout">
	<div>
		<div style="float: left; margin-right: 30px">
			<label>账务账号</label> <input class="easyui-textbox"
				style="width: 80px; height: 25px">
		</div>
		<div style="float: left; margin-right: 30px">
			<label>年份</label> <select class="easyui-combobox" name="state"
				style="width: 80px;">
				<option value="2018">2018</option>
				<option value="2017">2017</option>
				<option value="2016">2016</option>
			</select>
		</div>
		<div style="float: left; margin-right: 30px">
			<label>月份</label> <select class="easyui-combobox" name="state"
				style="width: 50px;">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
		</div>
		<button class="easyui-linkbutton" data-options="iconCls:'icon-search'"
			onclick="test()">查询</button>
		<div id="main" style="width: 1000px; height: 500px;"></div>

		<script type="text/javascript">
			var myChart = echarts.init(document.getElementById('main'));
			function test() {
				option = {
					color : [ '#3398DB' ],
					tooltip : {
						trigger : 'axis',
						axisPointer : { // 坐标轴指示器，坐标轴触发有效
							type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
						}
					},
					grid : {
						left : '3%',
						right : '4%',
						bottom : '3%',
						containLabel : true
					},
					xAxis : [ {
						type : 'category',
						data : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月',
								'八月', '九月', '十月', '十一月', '十二月' ],
						axisTick : {
							alignWithLabel : true
						}
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [ {
						name : '使用资费',
						type : 'bar',
						barWidth : '60%',
						data : [ 10, 52, 200, 334, 390, 330, 220, 70, 50, 440,
								350, 420 ]
					} ]
				};
				myChart.setOption(option);
			}
		</script>
	</div>
</body>
</html>