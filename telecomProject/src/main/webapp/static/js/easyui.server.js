$(function(){
	
	/**
	 * 默认服务器列表的显示
	 */
	$('#servertt').datagrid({
		url:"/telecomProject/server/page",
		method:"GET",
		queryParams:queryParams()
	});
	
	/**
	 * 参数的封装
	 */
	function queryParams(){
		var name = $('#name').val();
		var ip = $('#ip').val();
		var state = $('#state').val();
		var maintain = $('#maintain').val();

		var data = {
				name:name,
				ip:ip,
				state:state,
				maintain:maintain,
				};
		return data;
	}
	
	
	/**
	 * 真·模糊查询
	 */
	$('#con_server_execute').click(function(){
		    var data = {};
		    var form = $('#select_server').serializeArray();
		    $.each(form, function() {
		      data[this.name] = this.value;
		    });
		    console.info(data.state);
		$('#servertt').datagrid({
    		url:"/telecomProject/server/conPage",
    		data: [data],
    		method:"POST",
    		queryParams:{name:data.name,state:data.state}
    	});
		$('#select_server_dialog').dialog('close');
	});
	
	/**
	 * 取消模糊查询
	 */
	$('#con_server_nope').click(function(){
		$('#select_server_dialog').dialog('close');
	});
	
	
	/**
	 * 模糊查询
	 */
	$('#selectServer').click(function(){
		$('#select_server_dialog').dialog('open');
	});
	
	
	
	/**
	 * 启动
	 */
	$('#liveServer').click(function(){
		var rows = $('#servertt').datagrid('getSelections');
		var lenth = rows.length;
		if(lenth == 0){
				$.messager.show({
					title:'提示',
					msg:'请选择启动的服务器！',
					timeout:5000,
					showType:'slide'
				});
		}else if(lenth > 1){
				$.messager.show({
					title:'提示',
					msg:'一次只能启动一台服务器！',
					timeout:5000,
					showType:'slide'
				});
		}else{
			var row = $('#servertt').datagrid('getSelected');
			var url = "/telecomProject/server/open/" + row.id;
			var json = $.toJSON(row);
			$.ajax({
				   type: "POST",
				   url: url,
				   contentType:"application/json",
				   data: json,
				   success: function(msg){
					   $.messager.show({
							title:'提示',
							msg:msg.information,
							timeout:5000,
							showType:'slide'
						});
					   $('#servertt').datagrid('reload',queryParams());
				   }
				});
		}
		
	});
	
	
	/**
	 * 停用
	 */
	$('#stopServer').click(function(){
		var rows = $('#servertt').datagrid('getSelections');
		var lenth = rows.length;
		if(lenth == 0){
				$.messager.show({
					title:'提示',
					msg:'请选择停用的服务器！',
					timeout:5000,
					showType:'slide'
				});
		}else if(lenth > 1){
				$.messager.show({
					title:'提示',
					msg:'一次只能停用一台服务器！',
					timeout:5000,
					showType:'slide'
				});
		}else{
			var row = $('#servertt').datagrid('getSelected');
			var url = "/telecomProject/server/off/" + row.id;
			var json = $.toJSON(row);
			$.ajax({
				   type: "POST",
				   url: url,
				   contentType:"application/json",
				   data: json,
				   success: function(msg){
					   $.messager.show({
							title:'提示',
							msg:msg.information,
							timeout:5000,
							showType:'slide'
						});
					   $('#servertt').datagrid('reload',queryParams());
				   }
				});
		}
	});
	
	
	
	/**
	 * 真·修改服务器
	 */
	$('#update_server_execute').click(function(){
		var row = $('#servertt').datagrid('getSelected');
		$("#s_id").val(row.id);
		var url = "/telecomProject/server/update/" + row.id;
		$('#update_server').form('submit', {
			url: url,
			onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
			success:function(msg){
				var msg = eval('(' + msg + ')'); 
		    	if(msg.status){
		    		$('#add_server_dialog').dialog('close');
		    	}
				$.messager.show({
					title:'提示',
					msg:msg.information,
					timeout:5000,
					showType:'slide'
				});
			   $('#servertt').datagrid('reload',queryParams());
			}
		})
		$('#update_server_dialog').dialog('close');
	});
	
	/**
	 * 取消修改服务器
	 */
	$('#update_server_nope').click(function(){
		$('#update_server_dialog').dialog('close');
	});
	
	/**
	 * 修改服务器
	 */
	$('#updateServer').click(function(){
		var rows = $('#servertt').datagrid('getSelections');
		var lenth = rows.length;
		if(lenth == 0){
				$.messager.show({
					title:'提示',
					msg:'请选择修改的服务器！',
					timeout:5000,
					showType:'slide'
				});
		}else if(lenth > 1){
				$.messager.show({
					title:'提示',
					msg:'一次只能修改一台服务器！',
					timeout:5000,
					showType:'slide'
				});
		}else{
			$('#update_server_dialog').dialog('open');
		}
	});
	
	
	
	
	
	/**
	 * 删除&批量删除
	 */
	$('#deleteServer').click(function(){
		var rows = $('#servertt').datagrid('getSelections');
		var lenth = rows.length;
		if(lenth == 0){
			$.messager.show({
				title:'提示',
				msg:'请选择删除的服务器！',
				timeout:5000,
				showType:'slide'
			});
		}else if(lenth == 1){
			$.messager.confirm('警告', '要永久删除这条服务器吗?(真的很久!)', function(r){
				if (r){
					var row = $('#servertt').datagrid('getSelected');
					var json = $.toJSON(row);
					var url = "/telecomProject/server/" + row.id;
					$.ajax({
						   type: "DELETE",
						   url: url,
						   contentType:"application/json",
						   data: json,
						   success: function(msg){
							   $.messager.show({
									title:'提示',
									msg:msg.information,
									timeout:5000,
									showType:'slide'
								});
							   $('#servertt').datagrid('reload',queryParams());
						   }
						});
					}
				});
		}else{
			$.messager.confirm('警告', '要永久删除这些服务器吗?(真的很久!)', function(r){
				if (r){
					var json = $.toJSON(rows);
					var url = "/telecomProject/server/batch";
					$.ajax({
						   type: "DELETE",
						   url: url,
						   contentType:"application/json",
						   data: json,
						   success: function(msg){
							   $.messager.show({
									title:'提示',
									msg:msg.information,
									timeout:5000,
									showType:'slide'
								});
							   $('#servertt').datagrid('reload',queryParams());
						   }
						});
				}
			});
		}
	});
	
	
	/**
	 * 新增服务器
	 */
	$('#addServer').click(function(){
		$('#add_server_dialog').dialog('open');
	});
	
	/**
	 * 取消新增服务器
	 */
	$('#add_server_nope').click(function(){
		$('#add_server_dialog').dialog('close');
	});
	
	/**
	 * 真·新增服务器
	 */
	$('#add_server_execute').click(function(){
		$('#add_server').form('submit', {
			url:"/telecomProject/server/add",
			onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
			success:function(msg){
				var msg = eval('(' + msg + ')'); 
		    	if(msg.status){
		    		$('#add_server_dialog').dialog('close');
		    	}
				$.messager.show({
					title:'提示',
					msg:msg.information,
					timeout:5000,
					showType:'slide'
				});
			   $('#servertt').datagrid('reload',queryParams());
			}
		})
	});
		 
	
	
	
	
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
};