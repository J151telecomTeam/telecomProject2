$(function() {
	
	var queryUrl = "/telecomProject/bill/billMonthPage";
	
	$('#surePay').click(function(){
		var row = $('#tt').datagrid('getSelected');
		var id = row.id;
		var zwAccount = row.zwAccount;
		var price = $('#price').val();
		var payWay = $('#payWay').val();
		console.info(zwAccount);
		$.ajax({
			type:'PUT',
			url:'/telecomProject/bill/billUpdate',
			data:{
				id:id,
				zwAccount:zwAccount,
				price:price,
				payWay:payWay
			},
			success:function(msg){
				console.info(msg)
			}
		})
		$('#update').dialog('close');
	})
	
	$('#zhifu').click(function() {
		$('#update').dialog('open');// 打开窗体
		var row = $('#tt').datagrid('getSelected');
		$('#zwCard').html(row.zwAccount);
		
	})
	
	$('#query').click(function(){
		$('#tt').datagrid('reload',queryParams());
	});


	
	$('#tt').datagrid({
		url:queryUrl,
		method:"GET",
		queryParams:queryParams()
	});
	

	function queryParams() {

		var zwAccount = $('#zwAccount').val();
		var idcard = $('#idcard').val();
		var date = $('#attYearMonth').val();

		var data = {
			zwAccount:zwAccount,
			idCard:idcard,
			date:date
		};

		return data;
	}

	var clickNum = 0;
	$('#tt').datagrid({
		onDblClickRow : function(rowIndex, rowData) {
			if (clickNum == 0) {
				clickNum += 1;
				businessMonth();
			} else if (clickNum == 1) {
				clickNum += 1;
				server();
			}
		}
	});
	
	

	function businessMonth() {
		var row = $('#tt').datagrid('getSelected');
		$('#tt').datagrid({
			// 当月账务账号下的所有业务账号的具体信息
			url : '/telecomProject/bill/business',
			columns : [ [
			// :field对应的名称字段
				{
					field : 'ck',
					checkbox:true
				},
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
				field : 'runTime',
				title : '使用时长',
				width : 100
			}, {
				field : 'price',
				title : '当月费用',
				width : 100
			} ] ],
			method:"GET",
			queryParams:{
				zwAccount:row.zwAccount
			}
		});
	}
	
	
	function server() {
		var businessRow = $('#tt').datagrid('getSelected');
		$('#tt').datagrid({
			// 业务账号下面的具体信息
			url : '/telecomProject/bill/server',
			columns : [ [
			// :field对应的名称字段
				{
					field : 'ck',
					checkbox:true
				},
			{
				field : 'osAccount',
				title : 'OS账号',
				width : 100
			}, {
				field : 'loginTime',
				title : '登入时间',
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
				field : 'exitTime',
				title : '登出时间',
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
				title : '使用时长',
				width : 100
			},  {
				field : 'deal',
				title : '费用套餐',
				formatter: function(value,row,index){
					var ret = '';
					if (value == '1'){
						ret = '包月';
					} else if(value == '2'){
						ret = '时长';
					} else if(value == '3'){
						ret = '套餐';
					}
					return ret;
				},
				width : 100
			} ,{
				field : 'price',
				title : '费用',
				width : 100
			}] ],
		method:"GET",
		queryParams:{
			osAccount:businessRow.osAccount
		}
		});
	}

	function moth() {
		$('#tt').datagrid({
			// 业务账号下面的具体信息
			url : '',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'a',
				title : '客户名称',
				width : 100
			}, {
				field : 'b',
				title : '账务账号',
				width : 100
			}, {
				field : 'c',
				title : '费用',
				width : 100
			}, {
				field : 'd',
				title : '月份',
				width : 100
			}, {
				field : 'e',
				title : '支付方式',
				width : 100
			}, {
				field : 'e',
				title : '支付状态',
				width : 100
			} ] ]
		});
	}
	$('#esc').click(function() {
		// 返回
		clickNum -= 1;
		if (clickNum == 1) {
			day();
		} else if (clickNum == 2) {

		} else {
			moth();
		}
		if (clickNum < 0) {
			clickNum = 0;
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

$(function() {

	   $('#attYearMonth').datebox({
	       // 显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层
	       onShowPanel: function () {
	          // 触发click事件弹出月份层
	          span.trigger('click'); 
	          if (!tds)
	            // 延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔
	            setTimeout(function() { 
	                tds = p.find('div.calendar-menu-month-inner td');
	                tds.click(function(e) {
	                   // 禁止冒泡执行easyui给月份绑定的事件
	                   e.stopPropagation(); 
	                   // 得到年份
	                   var year = /\d{4}/.exec(span.html())[0] ,
	                   // 月份
	                   // 之前是这样的month = parseInt($(this).attr('abbr'), 10) + 1;
	                   month = parseInt($(this).attr('abbr'), 10);  

	         // 隐藏日期对象
	         $('#attYearMonth').datebox('hidePanel') 
	           // 设置日期的值
	           .datebox('setValue', year + '-' + month); 
	                        });
	                    }, 0);
	            },
	            // 配置parser，返回选择的日期
	            parser: function (s) {
	                if (!s) return new Date();
	                var arr = s.split('-');
	                return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);
	            },
	            // 配置formatter，只返回年月 之前是这样的d.getFullYear() + '-'
				// +(d.getMonth());
	            formatter: function (d) { 
	                var currentMonth = (d.getMonth()+1);
	                var currentMonthStr = currentMonth < 10 ? ('0' + currentMonth) : (currentMonth + '');
	                return d.getFullYear() + '-' + currentMonthStr; 
	            }
	        });

	        // 日期选择对象
	        var p = $('#attYearMonth').datebox('panel'), 
	        // 日期选择对象中月份
	        tds = false, 
	        // 显示月份层的触发控件
	        span = p.find('span.calendar-text'); 
	        var curr_time = new Date();

	        // 设置前当月
	        $("#attYearMonth").datebox("setValue", myformatter(curr_time));
	});
	function myformatter(date) {
	    // 获取年份
	    var y = date.getFullYear();
	    // 获取月份
	    var m = date.getMonth() + 1;
	    return y + '-' + m;
	}