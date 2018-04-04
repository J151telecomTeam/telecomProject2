$(function(){

	/**
	 * 默认数据列表的显示
	 */
	$('#power_tt').datagrid({
		url:"power/findAllPage",
		method:"GET",
		queryParams:queryParams()
	});
	
function queryParams(){
	
		
		var name = $('#name').val();
		var founder=$('#founder').val(); 

		
		
		var data = {
				name:name,
				founder:founder,				
				
				};
		
		return data;
	}
	
	/**
	 * 所有查询功能
	 */
	$('#query').click(function(){
		$('#power_tt').datagrid('reload',queryParams());
	});
	/**
	 * 新增
	 */
	$('#add').click(function(){
		$('#add_power_dialog').dialog('open');
	});
	
	
	
	
	$('#delete').click(function(){
		var rows = $('#power_tt').datagrid('getSelections')
		var row = $('#power_tt').datagrid('getSelected')
		var lenth = rows.length;
		if(lenth == 0){
			$.messager.show({
				title:'提示',
				msg:'请选择删除的数据！',
				timeout:5000,
				showType:'slide'
			});
		}else{
			$.messager.confirm('警告', '要永久删除这些数据吗?', function(r){
				if (r){
					var json = $.toJSON(rows);
					var url = "power/deleteBatchPowerBean" ;
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
							   $('#power_tt').datagrid('reload',queryParams());
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
		var rows = $('#power_tt').datagrid('getSelections');
		var row = $('#power_tt').datagrid('getSelected')
		if(row){
			var lenth = rows.length;
			if(lenth == 1){
				$('#update_power_dialog').dialog('open');
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
	$('#updatepowers').click(function(){
		var row = $('#power_tt').datagrid('getSelected')
		var url = "power/updatePowerBean/" + row.id;
		$('#update_p_power').form('submit', {   
			type:"POST",
		    url:url,   
		    onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
		    success:function(data){ 
		    	var data = eval('(' + data + ')'); 
		    	if(data.status){
		    		$('#update_power_dialog').dialog('close');
		    	}
		    	 $.messager.show({
						title:'提示',
						msg:data.information,
						timeout:5000,
						showType:'slide'
				});
		    	 
				$('#power_tt').datagrid('reload',queryParams());
		    }   
		});  
	});
	

	
	/**
	 * 条件查询功能
	 */
	
	
	/**
	 * 条件查询
	 */

	/**
	 * 添加权限
	 */
	$('#add_power').click(function(){
		$('#add_a_power').form('submit', {
			type:"POST",
			url:"power/addPowerBean",
			onSubmit: function(){   
		        // do some check
		        // return false to prevent submit;
		    	return true;
		    },   
			success:function(msg){
				var msg = eval('(' + msg + ')'); 
		    	if(msg.status){
		    		$('#power_tt').datagrid('reload',queryParams());
		    		$('#add_power_dialog').dialog('close');
		    	}
				$.messager.show({
					title:'提示',
					msg:msg.information,
					timeout:5000,
					showType:'slide'
				});
			   
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