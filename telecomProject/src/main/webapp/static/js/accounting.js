$(function(){
		
var clickNum = 0;

$('#tt').datagrid({  	
	
	onDblClickRow:function(rowIndex,rowData){
		
		 clickNum+=1;
		
         if(clickNum==1){
            moth();
         }else if(clickNum==2){
             day();            
         }else if(clickNum>2){
        	clickNum--;
        	
         }
	}
		
});
function moth(){
	//按月查询的数据
	$('#tt').datagrid({
		url:'',
	 columns:[[   
		 //:field对应的名称字段
		 {field:'1',title:'OS账号',width:100},  
	     {field:'2',title:'服务器IP',width:100},  
	     {field:'3',title:'年份',width:100},   
	     {field:'4',title:'账务账号',width:100},
	     {field:'5',title:'月份',width:100},	
	     {field:'6',title:'当月使用总时长',width:100}		
	
]]
	}); 
}
function day(){
	//:按日查询的数据
	$('#tt').datagrid({
		url:'',
	 columns:[[   
		 //:field对应的名称字段				
		 {field:'1',title:'OS账号',width:100},   
	     {field:'2',title:'服务器IP',width:100},   
	     {field:'3',title:'年份',width:100},   
	     {field:'4',title:'账务账号',width:100},
	     {field:'5',title:'月份',width:100,},  
	     {field:'5',title:'日期',width:100,}  	
]]
	});     
	
}
 
function year(){//按年查询
	$('#tt').datagrid({
		url:'',
	 columns:[[   
		 //:field对应的名称字段		
	 {field:'1',title:'账务账号',width:100},
     {field:'2',title:'OS账号',width:100},  
     {field:'3',title:'服务器IP',width:100},  
     {field:'4',title:'年份',width:100},   
     {field:'5',title:'当年使用时长',width:100}   
]]
	});     
}
$('#esc').click(function () {
	//返回	
	clickNum--;
	
    if(clickNum==1){
        moth();
    }else if(clickNum==0){
    	
    	year();    	
    }
});


});