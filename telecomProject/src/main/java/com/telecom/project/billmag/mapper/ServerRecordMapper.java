package com.telecom.project.billmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.telecom.project.beans.ServiceRecordBean;

public interface ServerRecordMapper {
	
	/**
	 * 模糊查询和所有查询
	 * @return
	 */
	public List<ServiceRecordBean> findServiceRecordByCon(@Param("bean")ServiceRecordBean bean);
	
	/**
	 * OS账号查询业务下面服务器信息
	 * @param os
	 * @return
	 */
	public ServiceRecordBean findServiceRecordByOS(@Param("os")String os);
	
	/**
	 * OS账号查询所有服务器信息
	 * @param os
	 * @return
	 */
	@ResultMap(value = "ServiceRecordMap")
	@Select(value = { "select s_id,s_ip,s_os_account,s_login_time,s_exit_time,s_run_time,s_price,s_deal_id "
			+ "from t_server_use_money where s_os_account = #{os}" })
	public List<ServiceRecordBean> findServiceRecordAllByOs(@Param("os")String os);
	
	
	
}
