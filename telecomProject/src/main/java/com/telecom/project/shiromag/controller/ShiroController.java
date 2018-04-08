package com.telecom.project.shiromag.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.telecom.project.beans.AdminBean;

@RequestMapping(value="/shiro")
@Controller
public class ShiroController {
	
	@RequestMapping(value="/logout")
	public String getLogout(HttpServletRequest request,HttpServletResponse response) {
		
		Subject currentAdmin = SecurityUtils.getSubject();
		
		currentAdmin.logout();
		
		return "login";
	}

	
	@RequestMapping(value="/login",method= {RequestMethod.POST})
	public String getLogin(AdminBean admin,HttpServletRequest request) {
		
		Subject currentAdmin = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(admin.getAccount(), admin.getPassword());
		
		try {
			currentAdmin.login(token);
			Session session = currentAdmin.getSession();
			session.setAttribute("adminName", admin.getName());
			return "redirect:/jsp/home/adminpage.jsp";
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("用户名或者密码错误");
			return "redirect:/login.jsp";
		}
	}
	
}
