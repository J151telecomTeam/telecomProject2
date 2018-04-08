package com.telecom.project.usermag.mapper;

import java.util.Map;

import com.telecom.project.utils.StringUtils;

/**
 * 用于拼接sql的bean
 * @author 
 *
 */
public class UserSqlProvider {

//	public String findByParams(Map<String,Object> params) {
//		Map map = (Map) params.get("params");
//		StringBuilder sb = new StringBuilder("SELECT id,b_name AS 'name',b_gender AS gender,b_indentity AS indentity,b_password AS 'password',b_phone AS 'phase',b_address AS address,b_postcode AS postcode,b_qq AS qq,b_account AS 'account',b_picture AS picture,b_status AS 'status',b_delete AS 'delete' from t_user where (1=1)");
//		if(!StringUtils.isEmpty(map.get("indentity"))) {
//			sb.append("and b_indentity like CONCAT('"+map.get("indentity")+"','%')");
//		}
//		if(!StringUtils.isEmpty(map.get("address"))) {
//			sb.append("and b_address = '"+map.get("address")+"'");
//			
//		}if(!StringUtils.isEmpty(map.get("status"))) {
//			sb.append("and b_status = '"+map.get("status")+"'");
//			
//		}if(!StringUtils.isEmpty(map.get("status"))) {
//			sb.append("and b_status = '"+map.get("status")+"'");
//		}
//		return sb.toString();
//	}
}
