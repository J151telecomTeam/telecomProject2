$(function(){
	
	
	$('#admin').click(function(){
		
		console.info(123);
		
		var adminName = $('#username1').val();
		var password = $('#password').val();
		
		$('#login').form('submit',{
			url:'/telecomProject/shiro/login',
			onSubmit: function(){   
		    	return true;
		    }
		})
		
	})
	
	
});