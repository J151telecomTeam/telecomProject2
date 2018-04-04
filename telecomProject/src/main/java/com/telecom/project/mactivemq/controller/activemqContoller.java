package com.telecom.project.mactivemq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/activemq")
public class activemqContoller {
	
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ResponseBody
	public void test(){
		System.out.println("?????");
	}
}
