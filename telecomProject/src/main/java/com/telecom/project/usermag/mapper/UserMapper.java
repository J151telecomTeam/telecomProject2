package com.telecom.project.usermag.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.telecom.project.beans.PageBean;
import com.telecom.project.beans.UserBean;

/**
 * 书写mybatis注解与sql语句
 * @author 
 *
 */
public interface UserMapper {
	

	/**
	 * 服务器查用户
	 * @param id
	 * @return
	 */
	@Results({@Result(id = true, property = "id", column = "u_id", javaType = Long.class),
		@Result(property="name", column="u_name", javaType=String.class),
		@Result(property="gender", column="u_gender" ,javaType=String.class),
		@Result(property="indentity", column="u_indentity", javaType=String.class),
		@Result(property="password", column="u_password", javaType=String.class),	
		@Result(property="phone", column="u_phone", javaType=String.class),	
		@Result(property="address", column="u_address", javaType=String.class),	
		@Result(property="postcode", column="u_postcode", javaType=String.class),	
		@Result(property="qq", column="u_qq", javaType=String.class),	
		@Result(property="account", column="u_account", javaType=String.class),	
		@Result(property="picture", column="u_picture", javaType=String.class),	
		@Result(property="status", column="u_status", javaType=String.class),		
	})
	@Select(value= {"SELECT u.`u_id`,u.`u_name`,u.`u_gender`,u.`u_indentity`,u.`u_password`,u.`u_phone`,u.`u_address`,u.`u_postcode`,u.`u_qq`,u.`u_account`,u.`u_picture`,u.`u_status`,u.`u_delete` FROM t_service s LEFT JOIN t_service_account sa ON sa.s_s_id = s.s_id LEFT JOIN t_user u ON sa.s_u_id = u.u_id where s_id=#{id};"})
	public List<UserBean> findUserByService(@Param("id")long id);
	
	/**
	 * 账号查用户
	 * @param account
	 * @return
	 */
	@Results({@Result(id = true, property = "id", column = "u_id", javaType = Long.class),
		@Result(property="name", column="u_name", javaType=String.class),
		@Result(property="gender", column="u_gender" ,javaType=String.class),
		@Result(property="indentity", column="u_indentity", javaType=String.class),
		@Result(property="password", column="u_password", javaType=String.class),	
		@Result(property="phone", column="u_phone", javaType=String.class),	
		@Result(property="address", column="u_address", javaType=String.class),	
		@Result(property="postcode", column="u_postcode", javaType=String.class),	
		@Result(property="qq", column="u_qq", javaType=String.class),	
		@Result(property="account", column="u_account", javaType=String.class),	
		@Result(property="picture", column="u_picture", javaType=String.class),	
		@Result(property="status", column="u_status", javaType=String.class),	
	})
	@Select(value= {"select * from t_user where u_account=#{account};"})
	public UserBean findUserByAccount(@Param("account")String account);
	/**
	 * 根据登陆的账务账号和密码查询用户对象
	 * @param account
	 * @param password
	 * @return
	 */
	@Results({@Result(id = true, property = "id", column = "u_id", javaType = Long.class),
		@Result(property="name", column="u_name", javaType=String.class),
		@Result(property="gender", column="u_gender" ,javaType=String.class),
		@Result(property="indentity", column="u_indentity", javaType=String.class),
		@Result(property="password", column="u_password", javaType=String.class),	
		@Result(property="phone", column="u_phone", javaType=String.class),	
		@Result(property="address", column="u_address", javaType=String.class),	
		@Result(property="postcode", column="u_postcode", javaType=String.class),	
		@Result(property="qq", column="u_qq", javaType=String.class),	
		@Result(property="account", column="u_account", javaType=String.class),	
		@Result(property="picture", column="u_picture", javaType=String.class),	
		@Result(property="status", column="u_status", javaType=String.class),		
	})
	@Select(value= {"select * from t_user where u_name=#{name} and u_password=#{password};"})
	public UserBean findByAccountAndPassword(@Param("name")String account,@Param("password")String password);
	
	/**
	 * 根据条件完成分页统计
	 * @param params
	 * @return
	 */
	
	public long countByParams2PageBean(@Param("params")Map params);
	/**
	 * 根据条件完成分页数据的具体查询
	 * @param page
	 * @param params
	 * @return
	 */
	public List<UserBean> findByParams2PageBean(@Param("params")Map params);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	@Results({@Result(id = true, property = "id", column = "u_id", javaType = Long.class),
		@Result(property="name", column="u_name", javaType=String.class),
		@Result(property="gender", column="u_gender" ,javaType=String.class),
		@Result(property="indentity", column="u_indentity", javaType=String.class),
		@Result(property="password", column="u_password", javaType=String.class),	
		@Result(property="phone", column="u_phone", javaType=String.class),	
		@Result(property="address", column="u_address", javaType=String.class),	
		@Result(property="postcode", column="u_postcode", javaType=String.class),	
		@Result(property="qq", column="u_qq", javaType=String.class),	
		@Result(property="account", column="u_account", javaType=String.class),	
		@Result(property="picture", column="u_picture", javaType=String.class),	
		@Result(property="status", column="u_status", javaType=String.class),	
	})
	@Select(value = { "	SELECT u.`u_id`,u.`u_name`,u.`u_gender`,u.`u_indentity`,u.`u_password`,u.`u_phone`,u.`u_address`,u.`u_postcode`,u.`u_qq`,u.`u_account`,u.`u_picture`,u.`u_status`,u.`u_delete` FROM t_user u WHERE u_id = #{id}" })
	public UserBean findByid(@Param("id")long id);
	/**
	 *  查询所有
	 * @param page
	 * @return
	 */
	@Results({@Result(id = true, property = "id", column = "u_id", javaType = Long.class),
		@Result(property="name", column="u_name", javaType=String.class),
		@Result(property="gender", column="u_gender" ,javaType=String.class),
		@Result(property="indentity", column="u_indentity", javaType=String.class),
		@Result(property="password", column="u_password", javaType=String.class),	
		@Result(property="phone", column="u_phone", javaType=String.class),	
		@Result(property="address", column="u_address", javaType=String.class),	
		@Result(property="postcode", column="u_postcode", javaType=String.class),	
		@Result(property="qq", column="u_qq", javaType=String.class),	
		@Result(property="account", column="u_account", javaType=String.class),	
		@Result(property="picture", column="u_picture", javaType=String.class),	
		@Result(property="status", column="u_status", javaType=String.class),	
	})
	@Select(value = {"SELECT* FROM t_user LIMIT 1,2"})
	public List<UserBean>findAll(@Param("page") PageBean page);
}
