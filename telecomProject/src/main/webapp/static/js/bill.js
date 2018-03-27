$(function(){
	
var clickNum = 0;
$('#tt').datagrid({  	
	onDblClickRow:function(rowIndex,rowData){
		 if(clickNum==0){
             clickNum+=1;
             day();  
	}else if(clickNum==1){
        clickNum+=1;
        year();
	}	
	}
});
//支付
$('#zhifu').click(function(){	
	$('#update').dialog('open');//打开窗体
	
})
$('#update_users').click(function(){
	$('#update').dialog('close');

});
function day(){
	$('#tt').datagrid({
		//当月账务账号下的所有业务账号的具体信息
		url:'',
	 columns:[[   
		 //:field对应的名称字段
	 {field:'a',title:'OS账号',width:100},   
	 {field:'b',title:'服务器信息',width:100},   
	 {field:'c',title:'时长(单位：时分秒)',width:100},   
	 {field:'d',title:'费用',width:100},
	 {field:'e',title:'费用套餐',width:100}  	
	]]
	}); 
}
function year(){
	$('#tt').datagrid({
		//业务账号下面的具体信息
		url:'',
	 columns:[[   
		 //:field对应的名称字段				
	 {field:'a',title:'服务器信息',width:100},  
	 {field:'b',title:'登入时间',width:100},  
	 {field:'c',title:'登出时间',width:100},   
	 {field:'d',title:'时长（单位：秒）',width:100},
	 {field:'e',title:'费用',width:100},
	 {field:'e',title:'费用套餐',width:100}  	
	]]
	});    
}

function moth(){
	$('#tt').datagrid({
		//业务账号下面的具体信息
		url:'',
	 columns:[[   
		 //:field对应的名称字段				
	 {field:'a',title:'客户名称',width:100},  
	 {field:'b',title:'账务账号',width:100},  
	 {field:'c',title:'费用',width:100},   
	 {field:'d',title:'月份',width:100},
	 {field:'e',title:'支付方式',width:100},
	 {field:'e',title:'支付状态',width:100}  	
	]]
	}); 
}
$('#esc').click(function () {
	//返回
    clickNum-=1;
    if(clickNum==1){
    	day();
    }else if(clickNum==2){
    	
    }else{
    	moth();
    }
    if(clickNum<0){
        clickNum=0;
    }
});

});