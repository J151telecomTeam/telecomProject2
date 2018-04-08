package com.telecom.project.usermag.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.telecom.project.beans.Messager;
import com.telecom.project.beans.UserBean;
import com.telecom.project.usermag.operationservice.IOperationUserService;
import com.telecom.project.utils.ImportExcelUtil;

/**
 * 用于文件 上传功能
 * @author Administrator
 *
 */
@RequestMapping("/users")
@Controller
public class UserexcelController {

    
    
	
	@Resource
	private IOperationUserService operationUserServiceImpl;
	

	  @RequestMapping(value = "/excel", method = RequestMethod.POST)  
	    @ResponseBody  
	    public  String doUploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {  
	    	Messager msg = new Messager(true, "操作成功！");
	        if (!file.isEmpty()) {  
	            try {  
	                // 这里将上传得到的文件保存指定目录下  
	                FileUtils.copyInputStreamToFile(file.getInputStream(),  
	                        new File("e:\\upload\\file\\", System.currentTimeMillis() + file.getOriginalFilename()));  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        InputStream in = null;  
	        List<List<Object>> listob = null;  
	        in = file.getInputStream();  
	        listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());  
	        // 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
	        String luss="";
	        for (int i = 0; i < listob.size(); i++) {  
	            List<Object> lo = listob.get(i);  
	            UserBean user =new UserBean();
	            user.setName(String.valueOf(lo.get(0)));
	            user.setGender(String.valueOf(lo.get(1)));
	            user.setIndentity(String.valueOf(lo.get(2)));
	            user.setPassword(String.valueOf(lo.get(3)));
	            user.setPhone(String.valueOf(lo.get(4)));
	            user.setAddress(String.valueOf(lo.get(5)));
	            user.setPostcode(String.valueOf(lo.get(6)));
	            user.setQq(String.valueOf(lo.get(7)));
	            user.setAccount(String.valueOf(lo.get(8)));
	            user.setPicture(String.valueOf(lo.get(9)));
	            user.setStatus(String.valueOf(lo.get(10)));
	            System.out.println(user);
	         
	            operationUserServiceImpl.saveUserBean(user);	          
	        }
	  
			return "添加成功，请重新刷新页面！！！";  
	       
	       // 上传成功则跳转至此success的信息  
	    } 
	
	  
	
}
