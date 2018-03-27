$(function() {

	/**
	 * // * 默认数据列表的显示 //
	 */
	$('#tt').datagrid({
		url : "../users/page",
		method : "post",
		queryParams : queryParams()
	});

	/**
	 * 查询参数的封装
	 */
	function queryParams() {

		var userName = $('#userName').val();
		var loginName = $('#loginName').val();
		var startTime = $('#beginTime').val();
		var endTime = $('#endTime').val();
		var data = {
			userName : userName,
			loginName : loginName,
			startTime : startTime,
			endTime : endTime
		};
		return data;
	}

	/**
	 * 条件查询
	 */
	$('#query').click(function() {
		$('#tt').datagrid('reload', queryParams());
	});

	// 获取添加数据
	function addDatas() {
		var userName = $('#add_userName').val();
		var loginName = $('#add_loginName').val();
		var password = $('#add_password').val();
		var birthday = $('#add_birthday').val();
		var gender = $('input[name="gender"]:checked').val();
		var data = {
			userName : userName,
			loginName : loginName,
			password : password,
			birthday : birthday,
			gender : gender
		};
		return data;
	}
	// 添加按钮
	$('#add').click(function() {
		$('#add_user').window('open');
	});
	// 确定新增
	$('#ok').click(function() {
		if ($('#add_password').val() == $('#add_password2').val()) {
			// 新增
			$('#ok').click(function() {
				var url = "../users/add";
				var user = addDatas();
				$.ajax({
					type : "POST",
					url : url,
					data : user,
					success : function(msg) {
						var data = eval('(' + msg + ')');
						if (data) {
							// 提示
							$.messager.show({
								title : '消息提示',
								msg : '添加成功！',
								timeout : 3000,
								showType : 'slide'
							});
							$('#add_user').window('close');
						} else {
							// 提示
							$.messager.show({
								title : '消息提示',
								msg : '系统异常！',
								timeout : 3000,
								showType : 'slide'
							});
							$('#add_user').window('close');
						}

					}
				});
			});
		} else {
			// 提示
			$.messager.show({
				title : '消息提示',
				msg : '两次输入密码不一致！',
				timeout : 3000,
				showType : 'slide'
			});
		}
	})
	// 取消新增
	$('#not').click(function() {
		$('#add_user').window('close');
	})

})