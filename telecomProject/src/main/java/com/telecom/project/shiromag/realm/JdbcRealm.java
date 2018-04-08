package com.telecom.project.shiromag.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.telecom.project.beans.AdminBean;
import com.telecom.project.shiromag.service.IShiroService;

public class JdbcRealm extends AuthorizingRealm{

	@Resource
	private IShiroService shiroServiceImpl;
	
	/**
	 * 为当前用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String adminName = (String)principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(shiroServiceImpl.findRoleName(adminName));
		authorizationInfo.setStringPermissions(shiroServiceImpl.findPermission(adminName));
		return authorizationInfo;
	}

	/**
	 * 验证当前登陆的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String adminName = (String)token.getPrincipal();
		
		AdminBean admin = shiroServiceImpl.findAdminByName(adminName);
		
		if(admin != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(admin.getAccount(),admin.getPassword(),"ww");
			return authcInfo;
		}
		
		return null;
	}

}
