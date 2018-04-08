$(function(){

	/**
	 * 默认数据列表的显示
	 */
	
	$('#tt').datagrid({	
		url:"/telecomProject/user/page",
		method:"GET",
		queryParams:queryParams()
		
	});
	
	 //查询参数的封装
	function queryParams(){		
		var name = $('#name').val();
		var gender = $('#gender').val();
		var indentity = $('#indentity').val();
		var phone = $('#phone').val();
		var address = $('#address').val();
		var postcode = $('#postcode').val();
		var qq = $('#qq').val();
		var account = $('#account').val();
		var status=$("#status").val();
		var data = {
				name:name,
				gender:gender,
				indentity:indentity,
				phone:phone,
				address:address,
				postcode:postcode,
				qq:qq,
				account:account,
	           	status:status,
				};
		
		return data;
		
	}

	$('#add_odd').click(function(){
		$('#formmm').submit();
		  $('#tt').datagrid('reload',queryParams());
		
	})
	
	
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
	 * 新增用户 确定
	 */
	$('#ok').click(function(){
		$('#addusers').form('submit', {
			type:"POST",
			url:"/telecomProject/user/add",
			onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
			success:function(data){
				var data = eval('(' + data + ')'); 
		    	if(data.status){
		    		$('#add_user').dialog('close');
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
	 * 修改用户
	 */
	$('#updateuser').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#update_user').dialog('open');
				$('#u_id').attr('value',row.id);
				$('#u_name').attr('value',row.name);
				$('#u_password').attr('value',row.password);
				$('#u_gender').attr('value',row.gender);
				$('#u_indentity').attr('value',row.indentity);
				$('#u_phone').attr('value',row.phone);
				$('#u_account').attr('value',row.account);
				$('#u_status').attr('value',row.status);
				$('#u_postcode').attr('value',row.postcode);
				$('#u_qq').attr('value',row.qq);
				$('#u_address').attr('value',row.address);
				$('#update_users').form('validate');				
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
		var url = "/telecomProject/user/update";
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
		    		$('#update_user').dialog('close');
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
	 * 删除用户
	 */
	$('#deleteuser').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#u_id').attr('value',row.id);				
				$('#update_users').form('validate');
				$.messager.confirm('提示','是否删除用户?',function(r){
				    if (r){
				    	var row = $('#tt').datagrid('getSelected')
						var url = "/telecomProject/user/delete"+row.id;
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
	 * 暂停用户
	 */
	$('#stopuser').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#u_id').attr('value',row.id);
				
				$('#update_users').form('validate');
				$.messager.confirm('提示','是否暂停用户?',function(r){
				    if (r){
				    	var row = $('#tt').datagrid('getSelected')
						var url = "/telecomProject/user/stopuser"+row.id;
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
					msg:'只能停用一条数据！',
					timeout:5000,
					showType:'slide'
				});
			}
		}else{
			$.messager.show({
				title:'提示',
				msg:'请选择停用的数据！',
				timeout:5000,
				showType:'slide'
			});
		}
		
	});
	/**
	 * 激活用户
	 */
	$('#liveuser').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#u_id').attr('value',row.id);				
				$('#update_users').form('validate');
				$.messager.confirm('提示','是否激活用户?',function(r){
				    if (r){
				    	var row = $('#tt').datagrid('getSelected')
						var url = "/telecomProject/user/liveuser"+row.id;
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
					msg:'只能选中一条数据！',
					timeout:5000,
					showType:'slide'
				});
			}
		}else{
			$.messager.show({
				title:'提示',
				msg:'请选择需要激活的数据！',
				timeout:5000,
				showType:'slide'
			});
		}
		
	});
	
	/**
	 *  查询详细用户 
	 */
	
	/**
	 * 查询用户
	 */
	$('#query').click(function(){
		$('#tt').datagrid('reload',queryParams());		
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
});

  $('#seleteUserById').click(function(){
	  
	  window.location.href="/telecomProject/jsp/userManagement/userfindbyId.jsp"
	  
	  
  })
function queryByid(){	//findbyid页面数据封装	
	var ServerName = $('#ServerName').val();
	var type = $('#type').val();
	var maintain = $('#maintain').val();
	var state = $('#state').val();
	
	var datas = {
			ServerName:ServerName,
			type:type,
			maintain:maintain,
			state:state,					
			};
	
	return datas;
	
	}

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