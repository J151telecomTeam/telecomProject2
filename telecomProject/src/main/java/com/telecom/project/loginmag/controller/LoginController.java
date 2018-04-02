package com.telecom.project.loginmag.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {

	@RequestMapping(value = "/login", method = { RequestMethod.POST }, produces = { "application/json;charset=utf-8" })
	public String userLogin(String username, String password) {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

		SecurityManager sm = factory.getInstance();  
        SecurityUtils.setSecurityManager(sm); 
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();

		// 测试当前的用户是否已经被认证，即是否已经登陆
		// 调用Subject的isAuthenticated
		if (!currentUser.isAuthenticated()) {
			// 把用户名和密码封装为UsernamePasswordToken 对象
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			System.out.println(token);
			try {
				// 执行登陆
				currentUser.login(token);
			} catch (AuthenticationException ae) {
				System.out.println("登录失败--->" + ae.getMessage());
			}
		}

		return "success";
	}

}
