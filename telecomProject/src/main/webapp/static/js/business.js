  
$(function(){
	

	/**
	 * 默认数据列表的显示
	 */
	
	$('#tt').datagrid({	
		url:"/telecomProject/business/page",
		method:"GET",
		
		queryParams:queryParams()
		
	});
	
	
	

	
function queryParams(){	//findbyid页面数据封装	
	
	
	var account = $('#account').val();
	var osAccount = $('#osAccount').val();
	var servicName = $('#u_servicName').combobox('getValue');
	var type = $('#u_type').combobox('getValue');
	var indentity = $('#indentity').val();
	var status = $('#status').val();
	var data = {
		
			account:account,
			osAccount:osAccount,
			servicName:servicName,	
			type:type,
			indentity:indentity,
			status:status,
			};
	
	return data;
	}


	
	

/**
	 * 新增业务
	 */
	$('#addAccounting').click(function(){
		$('#add_Accounting').dialog('open');
		
		
		/*var url = "/telecomProject/business/server";
		$.getJSON(url, function(json){
		$('#servicid').combobox({
		data : json.rows,
		valueField:'servicid',
		textField:'serverName'
		});
		});
*/
	});
	
	/**
	 * 新增用户 确定
	 */
	$('#add_ok').click(function(){	
		
		$('#addAccount').form('submit', {			
			type:"POST",
			url:"/telecomProject/business/add",					
			onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
			success:function(data){
				var data = eval('(' + data + ')'); 
		    	if(data.status){
		    		$('#add_Accounting').dialog('close');
		    	}
				$.messager.show({
					title:'提示',
					msg:data.information,
					timeout:5000,
					showType:'slide'
				});
			   $('#tt').datagrid('reload',queryParams());
			}
		})
	});
	/**
	 * 修改业务
	 */
	$('#updateAccounting').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#update_Accounting').dialog('open');
				$('#u_id').attr('value',row.id);
				$('#u_osAccount').attr('value',row.osAccount);
				$('#u_account').attr('value',row.account);
				$('#u_type').attr('value',row.type);
				$('#u_servicName').attr('value',row.servicName);	
				$('#u_status').attr('value',row.status);
				$('#update_Accounting').form('validate');
				
			}else{
				$.messager.show({
					title:'提示',
					msg:'只能修改一条数据！',
					timeout:5000,
					showType:'slide'
				});
			}
		}else{
			$.messager.show({
				title:'提示',
				msg:'请选择修改的数据！',
				timeout:5000,
				showType:'slide'
			});
		}
	
	});
	
	/**
	 * 修改保存
	 */
	$('#update_ok').click(function(){
		var row = $('#tt').datagrid('getSelected')
		var url = "/telecomProject/business/update"+row.id;
		$('#update_users').form('submit', {   
		    url:url,   
		    onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
		    success:function(data){ 
		    	var data = eval('(' + data + ')'); 
		    	if(data.status){
		    		$('#update_Accounting').dialog('close');
		    	}
		    	 $.messager.show({
						title:'提示',
						msg:data.information,
						timeout:5000,
						showType:'slide'
				});
		    	 
				$('#tt').datagrid('reload',queryParams());
		    }   
		});  
	});
	
	
	/**
	 * 删除业务
	 */
	$('#deleteAccounting').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#u_id').attr('value',row.id);				
				$('#update_users').form('validate');
				$.messager.confirm('提示','是否删除?',function(r){
				    if (r){
				    	var row = $('#tt').datagrid('getSelected')
						var url = "/telecomProject/business/delete"+row.id;
						$('#update_users').form('submit', {   
						    url:url,   
						    onSubmit: function(){   
						        // do some check
						        // return false to prevent submit;
						    	return true;
						    },   
						    success:function(data){ 
						    	var data = eval('(' + data + ')'); 
						    	if(data.status){
						    		$('#tt').datagrid('reload',queryParams());
						    	}
						    	 $.messager.show({
										title:'提示',
										msg:data.information,
										timeout:5000,
										showType:'slide'
								});
						    	 
								
						    }   
						});  
				    }
				});
			}else{
				$.messager.show({
					title:'提示',
					msg:'只能删除一条数据！',
					timeout:5000,
					showType:'slide'
				});
			}
		}else{
			$.messager.show({
				title:'提示',
				msg:'请选择删除的数据！',
				timeout:5000,
				showType:'slide'
			});
		}
		
	});
	/**
	 * 暂停业务
	 */
	$('#stopAccounting').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#u_id').attr('value',row.id);			
				$('#update_users').form('validate');
				$.messager.confirm('提示','是否暂停业务?',function(r){
				    if (r){
				    	var row = $('#tt').datagrid('getSelected')
						var url = "/telecomProject/business/stop"+row.id;
						$('#update_users').form('submit', {   
						    url:url,   
						    Type:'PUT',
						    onSubmit: function(){   
						        // do some check
						        // return false to prevent submit;
						    	return true;
						    },   
						    success:function(data){ 
						    	var data = eval('(' + data + ')'); 
						    	if(data.status){
						    		$('#tt').datagrid('reload',queryParams());
						    	}
						    	 $.messager.show({
										title:'提示',
										msg:data.information,
										timeout:5000,
										showType:'slide'
								});
						    	 
								
						    }   
						});  
				    }
				});
			}else{
				$.messager.show({
					title:'提示',
					msg:'只能选中一条数据！',
					timeout:5000,
					showType:'slide'
				});
			}
		}else{
			$.messager.show({
				title:'提示',
				msg:'请选择需要暂停的数据！',
				timeout:5000,
				showType:'slide'
			});
		}
	});
	/**
	 * 激活业务
	 */
	$('#liveAccounting').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#u_id').attr('value',row.id);	
				$('#u_status').attr('value',row.status);
				$('#update_users').form('validate');
				$.messager.confirm('提示','是否激活业务?',function(r){
				    if (r){
				    	var row = $('#tt').datagrid('getSelected')
						var url = "/telecomProject/business/live"+row.id;
						$('#update_users').form('submit', {   
						    url:url,   
						    Type:'PUT',
						    onSubmit: function(){   
						        // do some check
						        // return false to prevent submit;
						    	return true;
						    },   
						    success:function(data){ 
						    	var data = eval('(' + data + ')'); 
						    	if(data.status){
						    		$('#tt').datagrid('reload',queryParams());
						    	}
						    	 $.messager.show({
										title:'提示',
										msg:data.information,
										timeout:5000,
										showType:'slide'
								});
						    	 
								
						    }   
						});  
				    }
				});
			}else{
				$.messager.show({
					title:'提示',
					msg:'只能选中一条数据！',
					timeout:5000,
					showType:'slide'
				});
			}
		}else{
			$.messager.show({
				title:'提示',
				msg:'请选择需要激活的业务！',
				timeout:5000,
				showType:'slide'
			});
		}
	});
	
	
	/**
	 * 查询业务
	 */
	$('#query').click(function(){
		$('#tt').datagrid('reload',queryParams());
		
	});
	
	
		
		
	
});


	
	