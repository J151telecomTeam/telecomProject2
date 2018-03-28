package com.telecom.project.servermag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.ServerBean;
import com.telecom.project.beans.ServerUseMoneyBean;

/**
 * 书写mybatis注解与sql语句
 * 
 * @author
 *
 */
public interface ServerMapper {

	/**
	 * 用户查服务器
	 * 
	 * @param id
	 * @return
	 */
	@ResultMap(value = "serverMap")
	@Select(value = {
			"select s.s_id from" + " t_service s left join t_service_account sa on sa.s_s_id = s.s_id left join"
					+ " t_user u on sa.s_u_id = u.u_id where u.u_id = #{id}" })
	public List<ServerBean> findServerByUser(long id);

	/**
	 * 查询所有服务器分页
	 * 
	 * @param page
	 * @return
	 */
	@ResultMap(value = "serverMap")
	@Select(value = { "select s_id,s_name,s_ip,s_state,s_maintain from t_service limit #{page.index},#{page.rows}" })
	public List<ServerBean> findAllServerPage(@Param("page") PageBean page);

	/**
	 * 查所有服务器
	 * 
	 * @return
	 */
	@ResultMap(value = "serverMap")
	@Select(value = { "select s_name from t_service where s_maintain = '正常'" })
	public List<ServerBean> findAllServer();

	/**
	 * 多参数，完成分页查询
	 * 
	 * @param page
	 *            分页对象
	 * @param params
	 *            参数对象
	 * @return
	 */
	public List<ServerBean> findByParams2PageBean(@Param("map") Map map);

	/**
	 * id查
	 * 
	 * @param id
	 * @return
	 */
	@ResultMap(value = "serverMap")
	@Select(value = { "select s_id,s_name,s_ip,s_state,s_maintain from t_service where s_id = #{id}" })
	public ServerBean findServerId(long id);

	/**
	 * 带条件查条数
	 * 
	 * @param map
	 * @return
	 */
	public long findServerByPage(@Param("map") Map map);

	/**
	 * 资费查服务器
	 * @param id
	 * @return
	 */
	@ResultMap(value = "serverMap")
	@Select(value = {
			"select s.s_id from" + " t_service s left join t_service_account sa on sa.s_s_id = s.s_id left join"
					+ " t_deal d on sa.s_d_id = d.d_id where d.d_id = #{id}" })
	public List<ServerBean> findServerByDeal(long id);


}
