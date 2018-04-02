$(function() {
	
	
	$('#remove').click(function() {
		var rows = $('#tt').datagrid('getSelections');
		var lenth = rows.length;
		if(lenth == 0){
			$.messager.show({
				title:'消息提示',
				msg:'请选择需要暂停的资费！',
				timeout:3000,
				showType:'slide'
			});
		}else{
			$.messager.confirm('友情提示', '你确定要暂停这些资费吗?', function(r){
				if (r){
					var json = $.toJSON(rows);
					var url = "/telecomProject/deal/stop1";
					$.ajax({
						   type: "PUT",
						   url: url,
						   contentType:"application/json",
						   data: json,
						   success: function(msg){
							   $.messager.show({
									title:'消息提示',
									msg:msg.information,
									timeout:3000,
									showType:'slide'
								});
							   $('#tt').datagrid('reload',queryParams());
						   }
						});
				}
			});
		}

	});
	

	$('#save').click(function() {
		var rows = $('#tt').datagrid('getSelections')
		var lenth = rows.length;
		if(lenth == 0){
			$.messager.show({
				title:'消息提示',
				msg:'请选择需要开通的资费！',
				timeout:3000,
				showType:'slide'
			});
		}else{
			$.messager.confirm('友情提示', '你确定要开通这些资费吗?', function(r){
				if (r){
					var json = $.toJSON(rows);
					var url = "/telecomProject/deal/stop";
					$.ajax({
						   type: "PUT",
						   url: url,
						   contentType:"application/json",
						   data: json,
						   success: function(msg){
							   $.messager.show({
									title:'消息提示',
									msg:msg.information,
									timeout:3000,
									showType:'slide'
								});
							   $('#tt').datagrid('reload',queryParams());
						   }
						});
				}
			});
		}

	});
	

	$('#delete').click(function() {
		var rows = $('#tt').datagrid('getSelections')
		var lenth = rows.length;
		if(lenth == 0){
			$.messager.show({
				title:'消息提示',
				msg:'请选择需要删除的资费！',
				timeout:3000,
				showType:'slide'
			});
		}else{
			$.messager.confirm('友情提示', '你确定需要删除这些资费吗?', function(r){
				if (r){
					var json = $.toJSON(rows);
					var url = "/telecomProject/deal/delete";
					$.ajax({
						   type: "DELETE",
						   url: url,
						   contentType:"application/json",
						   data: json,
						   success: function(msg){
							   $.messager.show({
									title:'消息提示',
									msg:msg.information,
									timeout:3000,
									showType:'slide'
								});
							   $('#tt').datagrid('reload',queryParams());
						   }
						});
				}
			});
		}

	});
	

	$('#update_deal_dd1').click(function(){
		var row = $('#tt').datagrid('getSelected');
		var id = row.id;
		var type = $('#type').val();
		var name = $('#updateName1').val();
		var cost = $('#updateCost2').val();
		var money = $('#updateMoney1').val();
		var msg = $('#updateMsg1').val();
		
		$.ajax({
			type:"PUT",
			url:'/telecomProject/deal/update',
			data:{
				id:id,
				type:type,
				name:name,
				cost:cost,
				money:money,
				msg:msg
			},
			success:function(msg){
				$.messager.show({
					title:'消息提示',
					msg:msg.information,
					timeout:5000,
					showType:'slide'
				});
			   $('#tt').datagrid('reload',queryParams());
		}
		})
		$('#update_deal1').dialog('close');
		
	})
	
	
	$('#update_deal_dd').click(function(){
		var row = $('#tt').datagrid('getSelected');
		var id = row.id;
		var type = $('#type').val();
		var name = $('#updateName').val();
		var cost = $('#updateCost1').val();
		var msg = $('#updateMsg').val();
		
		console.info(id+name+cost+msg);
		
		$.ajax({
			type:"PUT",
			url:'/telecomProject/deal/update',
			data:{
				id:id,
				type:type,
				name:name,
				cost:cost,
				msg:msg
			},
			success:function(msg){
				$.messager.show({
					title:'消息提示',
					msg:msg.information,
					timeout:5000,
					showType:'slide'
				});
			   $('#tt').datagrid('reload',queryParams());
		}
		})
		$('#update_deal').dialog('close');
		
	})
	
	
	$('#update').click(function() {
		
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var length1 = rows.length;
			if(length1 == 1){
				var dealType = $('#type').val();
				console.info(dealType);
				if(dealType == '1'){
					$('#updateCost').html('基本费用');
					$('#update_deal').dialog('open');
				}else if(dealType == '2'){
					$('#updateCost').html('单位费用');
					$('#update_deal').dialog('open');
				}else if(dealType == '3'){
					$('#update_deal1').dialog('open');
				}
			}else{
				$.messager.show({
					title:'消息提示',
					msg:'一次只能对一条数据进行修改操作！',
					timeout:3000,
					showType:'slide'
				});
			}
		}else{
			$.messager.show({
				title:'消息提示',
				msg:'请先选择需要修改的数据！',
				timeout:3000,
				showType:'slide'
			});
		}
		
	});

	$('#add_deal_y1').click(function() {

		var type = $('#type').val();
		var name = $('#dealName1').val();
		var cost = $('#dealCost1').val();
		var money = $('#dealMoney1').val();
		var duration = $('#dealDuration1').val();
		var msg = $('#dealMsg1').val();

		$.ajax({
			type : "POST",
			url : "/telecomProject/deal/save",
			data : {
				type : type,
				name : name,
				cost : cost,
				money:money,
				duration:duration,
				msg : msg
			},
			success : function(msg) {
				$.messager.show({
					title:'消息提示',
					msg:msg.information,
					timeout:5000,
					showType:'slide'
				});
			   $('#tt').datagrid('reload',queryParams());
			}
		})
		$('#add_deal1').dialog('close');
	})

	$('#add_deal_y').click(function() {

		var type = $('#type').val();
		var name = $('#dealName').val();
		var cost = $('#dealCost').val();
		var msg = $('#dealMsg').val();
		console.info(type + name + cost + msg);
		$.ajax({
			type : "POST",
			url : "/telecomProject/deal/save",
			data : {
				type : type,
				name : name,
				cost : cost,
				msg : msg
			},
			success : function(msg) {
				$.messager.show({
					title:'消息提示',
					msg:msg.information,
					timeout:5000,
					showType:'slide'
				});
			   $('#tt').datagrid('reload',queryParams());
			}
		})
		$('#add_deal').dialog('close');
	})

	$('#add').click(function() {

		var dealType = $('#type').val();
		if (dealType == 1) {
			$('#dealType').html('包月');
			$('#cost').html('基本费用:');
			$('#add_deal').dialog('open');
		} else if (dealType == 2) {
			$('#dealType').html('时长');
			$('#cost').html('单位费用:');
			$('#add_deal').dialog('open');
		} else if (dealType == 3) {
			$('#dealType1').html('套餐');
			$('#add_deal1').dialog('open');
		}

	});

	$('#tt').datagrid({
		url : '/telecomProject/deal/type',
		method : "GET",
		queryParams : queryParams()
	});

	function queryParams() {
		var type = $('#type').val();
		var data = {
			type : type
		};
		return data;
	}

	$('#query').click(function() {
		var num = $('#type').combobox('getValue');
		if (num == 1) {
			month();
		}
		if (num == 2) {
			hour();
		}
		if (num == 3) {
			set();
		}
	});

	function month() {// 包月
		$('#tt').datagrid({
			// 包月资费的数据表格
			url : '/telecomProject/deal/type',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'ck',
				checkbox : true
			}, {
				field : 'name',
				title : '资费名称',
				width : 100
			}, {
				field : 'type',
				title : '资费类型',
				formatter : function(value, row, index) {
					var ret = '';
					if (value == '1') {
						ret = '包月';
					} else if (value == '2') {
						ret = '时长';
					} else if (value == '3') {
						ret = '套餐';
					}
					return ret;
				},
				width : 100
			}, {
				field : 'cost',
				title : '基本费用',
				width : 100
			}, {
				field : 'msg',
				title : '资费说明',
				width : 100
			}, {
				field : 'stop',
				title : '状态',
				formatter : function(value, row, index) {
					var ret = '';
					if (value == '1') {
						ret = '开通';
					} else if (value == '0') {
						ret = '暂停';
					}
					return ret;
				},
				width : 100
			} ] ],
			method : "GET",
			queryParams : {
				type : $('#type').val()
			}
		});
	}

	function hour() {// 计时
		$('#tt').datagrid({
			// 计时资费的数据表格
			url : '/telecomProject/deal/type',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'ck',
				checkbox : true
			}, {
				field : 'name',
				title : '资费名称',
				width : 100
			}, {
				field : 'type',
				title : '资费类型',
				formatter : function(value, row, index) {
					var ret = '';
					if (value == '1') {
						ret = '包月';
					} else if (value == '2') {
						ret = '时长';
					} else if (value == '3') {
						ret = '套餐';
					}
					return ret;
				},
				width : 100
			}, {
				field : 'money',
				title : '单位费用',
				width : 100
			}, {
				field : 'msg',
				title : '资费说明',
				width : 100
			}, {
				field : 'stop',
				title : '状态',
				formatter : function(value, row, index) {
					var ret = '';
					if (value == '1') {
						ret = '开通';
					} else if (value == '0') {
						ret = '暂停';
					}
					return ret;
				},
				width : 100
			} ] ],
			method : "GET",
			queryParams : {
				type : $('#type').val()
			}
		});
	}

	function set() {// 套餐
		$('#tt').datagrid({
			// 套餐资费的数据表格
			url : '/telecomProject/deal/type',
			columns : [ [
			// :field对应的名称字段
			{
				field : 'ck',
				checkbox : true
			}, {
				field : 'name',
				title : '资费名称',
				width : 100
			}, {
				field : 'type',
				title : '资费类型',
				formatter : function(value, row, index) {
					var ret = '';
					if (value == '1') {
						ret = '包月';
					} else if (value == '2') {
						ret = '时长';
					} else if (value == '3') {
						ret = '套餐';
					}
					return ret;
				},
				width : 100
			}, {
				field : 'cost',
				title : '基本费用',
				width : 100
			}, {
				field : 'money',
				title : '单位费用',
				width : 100
			}, {
				field : 'msg',
				title : '资费说明',
				width : 100
			}, {
				field : 'stop',
				title : '状态',
				formatter : function(value, row, index) {
					var ret = '';
					if (value == '1') {
						ret = '开通';
					} else if (value == '0') {
						ret = '暂停';
					}
					return ret;
				},
				width : 100
			} ] ],
			method : "GET",
			queryParams : {
				type : $('#type').val()
			}
		});
	}

	/*
	 * $('#add').click(function() {// 添加资费窗口 $('#add_deal').dialog('open');//
	 * 打开添加窗体 });
	 */
	/*
	 * $('#add_deal_y').click(function() { $('#add_deal').dialog('close');//
	 * 关闭窗口 });
	 */


	$('#update_deal_y').click(function() {
		$('#update_deal').dialog('close');// 关闭窗口
	});

	

});