$(function() {

	$('#query').click(function() {
		if ($('#month').val() == '全部') {
			year()
		} else {
			month();
		}

	});

	$('#tt').datagrid({
		url : '/telecomProject/accounting/yearOrMonth',
		method : "GET",
		queryParams : yearParams()
	});

	function yearParams() {

		var zwAccount = $('#zwAccount').val();
		var year = $('#year').val();
		var month = $('#month').val();

		var data = {
			zwAccount : zwAccount,
			year : year,
			month : month
		};

		return data;
	}

	var clickNum = 0;

	$('#tt').datagrid({

		onDblClickRow : function(rowIndex, rowData) {

			clickNum += 1;

			if (clickNum == 1) {
				month1();
			} else if (clickNum == 2) {
				day1();
			}
		}

	});

	function month1() {
		// 按月查询的数据
		var row = $('#tt').datagrid('getSelected');
		$('#tt').datagrid({
			url : '/telecomProject/accounting/month',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'ck',
				checkbox : true
			}, {
				field : 'zwAccount',
				title : '账务账号',
				width : 100
			}, {
				field : 'osAccount',
				title : 'OS账号',
				width : 100
			}, {
				field : 'ip',
				title : '服务器IP',
				width : 100
			}, {
				field : 'year',
				title : '年份',
				width : 100
			}, {
				field : 'month',
				title : '月份',
				width : 100
			}, {
				field : 'runTime',
				title : '月使用时长',
				width : 100
			} ] ],
			method : "GET",
			queryParams : {
				year : row.year,
				zwAccount : row.zwAccount
			}
		});
	}

	function month() {
		// 按月查询的数据
		$('#tt').datagrid({
			url : '/telecomProject/accounting/yearOrMonth',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'ck',
				checkbox : true
			}, {
				field : 'zwAccount',
				title : '账务账号',
				width : 100
			}, {
				field : 'osAccount',
				title : 'OS账号',
				width : 100
			}, {
				field : 'ip',
				title : '服务器IP',
				width : 100
			}, {
				field : 'year',
				title : '年份',
				width : 100
			}, {
				field : 'month',
				title : '月份',
				width : 100
			}, {
				field : 'runTime',
				title : '月使用时长',
				width : 100
			} ] ],
			method : "GET",
			queryParams : yearParams()
		});
	}
	
	function day1() {
		// 按月查询的数据
		var row = $('#tt').datagrid('getSelected');
		$('#tt').datagrid({
			url : '/telecomProject/accounting/day',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'ck',
				checkbox : true
			}, {
				field : 'zwAccount',
				title : '账务账号',
				width : 100
			}, {
				field : 'osAccount',
				title : 'OS账号',
				width : 100
			}, {
				field : 'ip',
				title : '服务器IP',
				width : 100
			}, {
				field : 'day',
				title : '日期',
				formatter: function(value,row,index){
					var text = ''; 
					if(value != ''){
						var date = new Date(value);
						text = date.format('yyyy-MM-dd');
					}
					return text;
				},
				width : 100
			}, {
				field : 'runTime',
				title : '日使用时长',
				width : 100
			} ] ],
			method : "GET",
			queryParams : {
				year : row.year,
				zwAccount : row.zwAccount
			}
		});
	}
	
	/*function day1() {
		// :按日查询的数据
		var row = $('#tt').datagrid('getSelected');
		$('#tt').datagrid({
			url : '/telecomProject/accounting/day',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'ck',
				checkbox : true
			}, {
				field : 'zwAccount',
				title : '账务账号',
				width : 100
			}, {
				field : 'osAccount',
				title : 'OS账号',
				width : 100
			}, {
				field : 'ip',
				title : '服务器IP',
				width : 100
			}, {
				field : 'day',
				title : '日期',
				formatter : function(value, row, index) {
					var text = '';
					if (value != '') {
						var date = new Date(value);
						text = date.format('yyyy-MM-dd');
					}
					return text;
				},
				width : 100
			}, {
				field : 'runTime',
				title : '日使用时长',
				width : 100,
			} ] ],
			method : "GET",
			queryParams : {
				zwAccount : row.zwAccount,
				year : row.year,
				month : row.month
			}
		});

	}*/

	function year() {// 按年查询
		$('#tt').datagrid({
			url : '/telecomProject/accounting/yearOrMonth',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'zwAccount',
				title : '账务账号',
				width : 100
			}, {
				field : 'osAccount',
				title : 'OS账号',
				width : 100
			}, {
				field : 'ip',
				title : '服务器IP',
				width : 100
			}, {
				field : 'year',
				title : '年份',
				width : 100
			}, {
				field : 'runTime',
				title : '当年使用时长',
				width : 100
			} ] ],
			method : "GET",
			queryParams : yearParams()
		});
	}
	$('#esc').click(function() {
		// 返回
		clickNum--;

		if (clickNum == 1) {
			moth();
		} else if (clickNum == 0) {

			year();
		}
	});
	
	Date.prototype.format = function(fmt) { 
	    var o = { 
	       "M+" : this.getMonth()+1,                 // 月份
	       "d+" : this.getDate(),                    // 日
	       "h+" : this.getHours(),                   // 小时
	       "m+" : this.getMinutes(),                 // 分
	       "s+" : this.getSeconds(),                 // 秒
	       "q+" : Math.floor((this.getMonth()+3)/3), // 季度
	       "S"  : this.getMilliseconds()             // 毫秒
	   }; 
	   if(/(y+)/.test(fmt)) {
	           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	   }
	    for(var k in o) {
	       if(new RegExp("("+ k +")").test(fmt)){
	            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	        }
	    }
	   return fmt; 
	}

});