$(function(){
	$('#query').click(function (){
		var num=$('#cc').combobox('getValue');
		console.info(num);
		if(num==0){
			day();
		}if(num==1){
			hour();
		}if(num==2){
			set();
		}							
	});
	
	
	
function day(){//包月
		$('#tt').datagrid({
			//包月资费的数据表格
			url:'',
		 columns:[[   
			 //:field对应的名称字段
		 {field:'a',title:'业务账号',width:100},   
		 {field:'b',title:'资费名称',width:100},   
		 {field:'c',title:'资费类型',width:100},   
		 {field:'d',title:'基本费用(RMB)',width:100},
		 {field:'e',title:'资费说明',width:100}  	
		]]
		}); 						
	}	
	
function hour(){//计时
		$('#tt').datagrid({
			//计时资费的数据表格
			url:'',
		 columns:[[   
			 //:field对应的名称字段
		 {field:'a',title:'业务账号',width:100},   
		 {field:'b',title:'资费名称',width:100},   
		 {field:'c',title:'资费类型',width:100},   
		 {field:'d',title:'单位费用(RMB/小时)',width:100},
		 {field:'e',title:'资费说明',width:100}  	
		]]
		}); 						
	}		
	
function set(){//套餐
	$('#tt').datagrid({
		//套餐资费的数据表格
		url:'',
	 columns:[[   
		 //:field对应的名称字段
	 {field:'a',title:'业务账号',width:100},   
	 {field:'b',title:'资费名称',width:100},   
	 {field:'c',title:'资费类型',width:100},   
	 {field:'d',title:'基本时长(小时)',width:100},
	 {field:'d',title:'基本费用(RMB)',width:100},
	 {field:'d',title:'单位费用(RMB/小时)',width:100},
	 {field:'e',title:'资费说明',width:100}  	
	]]
	}); 						
}			
	
$('#add').click(function (){//添加资费窗口
	$('#add_deal').dialog('open');//打开添加窗体	
	});
$('#add_deal_y').click(function (){
	$('#add_deal').dialog('close');//关闭窗口
});	



$('#update').click(function (){//修改资费窗口
	$('#update_deal').dialog('open');//打开修改窗体	
});

$('#update_deal_y').click(function (){
	$('#update_deal').dialog('close');//关闭窗口
});		


$('#delete').click(function(){
	$.messager.confirm('友情提示', '你确定需要删除这些数据么?',function(r){   
	    if (r){   
	      
	    }   
	});  
	
	
});
	
$('#save').click(function(){
	$.messager.confirm('友情提示', '是否确定开通资费?',function(r){   
	    if (r){   
	      
	    }   
	});  
	
	
});
$('#remove').click(function(){
	$.messager.confirm('友情提示', '是否确定暂停资费?',function(r){   
	    if (r){   
	      
	    }   
	});  
	
	
});
});