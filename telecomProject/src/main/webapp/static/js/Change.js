$(function() {

	/**
	 * // * 默认数据列表的显示 //
	 */
	$('#tt').datagrid({
		url : "/telecomProject/change/page",
		method : "GET",
		//queryParams:queryParams()
	});

	/**
	 * 查询参数的封装
	 */
	function queryParams() {
		var name = $('#name').val();
		var ontime = $('#ontime').val();
		var endtime = $('#endtime').val();
		
		var data = {
			name:name,
			ontime:ontime,
			endtime:endtime
		};
		
		
		return data;
	}
	
	$('#seleteActiveDate').click(function () {
		$('#tt').datagrid({
			url : "/telecomProject/change/findByParams",
			method : "GET",
			queryParams:queryParams()
		});
	})
})

Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3), //季度 
       "S"  : this.getMilliseconds()             //毫秒 
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