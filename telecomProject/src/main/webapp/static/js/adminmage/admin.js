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
	 * 新增
	 */
	$('#add').click(function(){
		$('#add_users_dialog').dialog('open');
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