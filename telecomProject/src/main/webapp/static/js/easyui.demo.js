$(function(){

	/**
	 * 默认数据列表的显示
	 */
	$('#tt').datagrid({
		url:"users/page",
		method:"GET",
		queryParams:queryParams()
	});
	
	
	
	/**
	 * 新增服务器
	 */
	$('#addserver').click(function(){
		$('#add_server').dialog('open');
	});
	/**
	 * 修改服务器
	 */
	$('#updateserver').click(function(){
		$('#update_server').dialog('open');
	});
	
	/**
	 * 删除服务器
	 */
	$('#deleteserver').click(function(){
		$.messager.confirm('提示','是否删除服务器?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	/**
	 * 暂停服务器
	 */
	$('#stopserver').click(function(){
		
		$.messager.confirm('提示','是否暂停服务器?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	/**
	 * 激活服务器
	 */
	$('#liveserver').click(function(){

		$.messager.confirm('提示','是否激活服务器?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	/**
	 * 查询服务器
	 */
	$('#selectserver').click(function(){
		$('#select_server').dialog('open');
	});
	
	
	/**
	 * 新增用户
	 */
	$('#adduser').click(function(){
		$('#add_user').dialog('open');
	});
	/**
	 * 修改用户
	 */
	$('#updateuser').click(function(){
		$('#update_user').dialog('open');
	});
	
	/**
	 * 删除用户
	 */
	$('#deleteuser').click(function(){
		$.messager.confirm('提示','是否删除用户?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	/**
	 * 暂停用户
	 */
	$('#stopuser').click(function(){
		$.messager.confirm('提示','是否暂停用户?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	/**
	 * 激活用户
	 */
	$('#liveuser').click(function(){
		$.messager.confirm('提示','是否删除用户?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	
	/**
	 *  查询详细用户 
	 */
	
	/**
	 * 查询用户
	 */
	$('#selectuser').click(function(){
		$('#select_user').dialog('open');
	});
	
	
	/**
	 * 查询操作日志
	 */
	$('#seleteActiveDate').click(function(){
		$('#select_ActiveDate').dialog('open');
	});
	
	
	/**
	 * 查询登陆日志
	 */
	$('#seleteloginDate').click(function(){
		$('#select_loginDate').dialog('open');
	});
	
	
	/**
	 * 新增业务
	 */
	$('#addAccounting').click(function(){
		$('#add_Accounting').dialog('open');
	});
	/**
	 * 修改业务
	 */
	$('#updateAccounting').click(function(){
		$('#update_Accounting').dialog('open');
	});
	
	/**
	 * 删除业务
	 */
	$('#deleteAccounting').click(function(){
		$.messager.confirm('提示','是否删除业务?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	/**
	 * 暂停业务
	 */
	$('#stopAccounting').click(function(){
		$.messager.confirm('提示','是否暂停业务?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	/**
	 * 激活业务
	 */
	$('#liveAccounting').click(function(){
		$.messager.confirm('提示','是否激活业务?',function(r){
		    if (r){
				alert('是');
				alert('否')
		    }
		});
	});
	
	
	/**
	 * 查询业务
	 */
	$('#selectAccounting').click(function(){
		$('#select_Accounting').dialog('open');
	});
	
	
	
	
	
	$('#delete').click(function(){
		var rows = $('#tt').datagrid('getSelections')
		var row = $('#tt').datagrid('getSelected')
		var lenth = rows.length;
		if(lenth == 0){
			$.messager.show({
				title:'提示',
				msg:'请选择删除的数据！',
				timeout:5000,
				showType:'slide'
			});
		}else{
			$.messager.confirm('警告', '要永久删除这条数据吗?(真的很久!)', function(r){
				if (r){
					var json = $.toJSON(rows);
					var url = "users/" + row.id;
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
							   $('#tt').datagrid('reload',queryParams());
						   }
						});
				}
			});
		}
	});

	
	/**
	 * 修改
	 */
	$('#update').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#update_users_dialog').dialog('open');
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
	$('#update_users').click(function(){
		var row = $('#tt').datagrid('getSelected')
		var url = "users/"+row.id;
		$('#update_user').form('submit', {   
		    url:url,   
		    onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
		    success:function(data){ 
		    	var data = eval('(' + data + ')'); 
		    	if(data.status){
		    		$('#update_users_dialog').dialog('close');
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
	 * 查询参数的封装
	 */
	function queryParams(){
		var name = $('#name').val();
		var login = $('#login').val();
		var gender = $('#gender').val();
		var birthday = $('#birthday').val();
		var createTime = $('#createTime').val();
		
		var data = {
				name:name,
				login:login,
				gender:gender,
				birthday:birthday,
				createTime:createTime
				};
		return data;
	}
	
	/**
	 * 条件查询功能
	 */
	$('#selete').click(function(){
		$('#find_users_dialog').dialog('open');
	});
	
	/**
	 * 条件查询
	 */
	$('#find_users').click(function(){
		$('#find_user').form('submit', {
			type:"POST",
			url:"users/findUser",
			onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
		    queryParams:queryParams()
		})
	})
	/**
	 * 添加用户
	 */
	$('#add_users').click(function(){
		$('#add_user').form('submit', {
			type:"POST",
			url:"users/add",
			onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
			success:function(msg){
				var msg = eval('(' + msg + ')'); 
		    	if(msg.status){
		    		$('#add_users_dialog').dialog('close');
		    	}
				$.messager.show({
					title:'提示',
					msg:msg.information,
					timeout:5000,
					showType:'slide'
				});
			   $('#tt').datagrid('reload',queryParams());
			}
		})
	})
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