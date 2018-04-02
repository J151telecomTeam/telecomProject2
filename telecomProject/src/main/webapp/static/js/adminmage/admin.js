$(function(){



	/**
	 * 默认数据
	 */

	$('#tt').datagrid({
		url:"admins/page",
		method:"GET",
		queryParams:queryParams()
	});


	/**
	 * 查询参数的封装
	 */
	function queryParams(){

		var adminName = $('#adminName').val();
		var roleName = $('#roleName').val();
		var data = {
				adminName:adminName,
				roleName:roleName
		};
		return data;
	}
	
	
	/**
	 * 根据条件查询
	 */
	$('#query').click(function(){
		$('#tt').datagrid('reload',queryParams());
	});
	

	/**
	 * 新增
	 */
	$('#add').click(function(){
		$('#add_controllers_dialog').dialog('open');
	});

	/**
	 * 新增保存 
	 */
$('#add_controllers').click(function(){
		var name = $('#a_name').val();
		var account = $('#a_account').val();
		var password = $('#a_password').val();
		var tel = $('#a_tel').val();
		var mail = $('#a_mail').val();
		var role = $('#a_r_id').val();
		var customers= {
				name:name,
				account:account,
				password:password,
				tel:tel,
				mail:mail,
				role:role
		};
		console.info(customers);
		var json = $.toJSON(customers);
		var url = "admins/add";
		$.ajax({
			   type: "POST",
			   url: url,
			   contentType:"application/json",
			   data: json,
			   success: function(msg){
				   $.messager.show({
						title:'消息提示',
						msg:msg.information,
						timeout:5000,
						showType:'slide'
					});
				   $('#tt').datagrid('reload',queryParams());// 重新加载数据
				   $('add_controllers_dialog').dialog('close');
			   }
			});
	});
	
	/**
	 * 修改
	 */
	$('#update').click(function(){
		var rows = $('#tt').datagrid('getSelections');
		var row = $('#tt').datagrid('getSelected')//返回的第1行记录
		if(row){//如果选中了数据，就进入if语句
			var lenth = rows.length;
			console.info(rows.length);
			if(lenth == 1){
				$('#update_controllers_dialog').dialog('open');//打开修改窗体
				$('#b_administrator_id').attr('value',row.id);
				$('#b_name').attr('value',row.name);
				$('#b_account').attr('value',row.account);
				$('#b_password').attr('value',row.password);
				$('#b_tel').attr('value', row.tel);
				$('#b_mail').attr('value',row.mail);
				$('#b_r_id').combobox('select',row.role.id);
				$('#update_controller').form('validate');
				console.info(row.name);
				console.info(row.account);
				console.info(row.role);
			}else{
				$.messager.show({
					title:'消息提示',
					msg:'每次只能修改一条数据！',
					timeout:5000,
					showType:'slide'
				});
			}
		}else{
			$.messager.show({
				title:'消息提示',
				msg:'请选择需要修改的数据！',
				timeout:5000,
				showType:'slide'
			});
		}
	});

	/**
	 * 修改保存
	 */
	$('#update_controllers').click(function(){
		var row = $('#tt').datagrid('getSelected')
		//	alert(row.id);
		var url = "admins/"+row.id;
		$('#update_controller').form('submit', {   
			url:url,   
			onSubmit: function(){   
				// do some check   
				// return false to prevent submit; 
				return true;
			},   
			success:function(data){ 
				var data = eval('(' + data + ')'); 
				if(data.status){
					$('#update_controllers_dialog').dialog('close');
				}
				$.messager.show({
					title:'消息提示',
					msg:data.information,
					timeout:5000,
					showType:'slide'
				});

				$('#tt').datagrid('reload',queryParams());// 重新加载数据
			}   
		});  
	});

	/**
	 * 批量删除
	 */
	$('#delete').click(function(){
		// 返回的是：所选择数据的数组
		var rows = $('#tt').datagrid('getSelections')
		var lenth = rows.length;
		if(lenth == 0){// 没有选择任何需要被删除的数据
			$.messager.show({
				title:'消息提示',
				msg:'请选择需要删除的数据！',
				timeout:5000,
				showType:'slide'
			});
		}else{// 已经选择了，需要被删除的数据
			$.messager.confirm('友情提示', '你确定需要删除这些数据么?', function(r){
				if (r){
					var json = $.toJSON(rows);
					var url = "admins/batch";
					$.ajax({
						type: "DELETE",
						url: url,
						contentType:"application/json",
						data: json,
						success: function(msg){
							$.messager.show({
								title:'消息提示',
								msg:msg.information,
								timeout:5000,
								showType:'slide'
							});
							$('#tt').datagrid('reload',queryParams());// 重新加载数据
						}
					});
				}
			});
		}
	});

});
