package com.telecom.project.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.telecom.project.beans.InfoVo;

  
@RequestMapping(value="files")
@Controller  
public class UploadExcelController{  
    
    @RequestMapping(value = "/excel", method = RequestMethod.POST)  
    @ResponseBody  
    public String doUploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {  
  
        if (!file.isEmpty()) {  
            try {  
                // 这里将上传得到的文件保存指定目录下  
                FileUtils.copyInputStreamToFile(file.getInputStream(),  
                        new File("d:\\upload\\file\\", System.currentTimeMillis() + file.getOriginalFilename()));  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        InputStream in = null;  
        List<List<Object>> listob = null;  
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());  
        // 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
        for (int i = 0; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);  
            InfoVo vo = new InfoVo();  
            vo.setCode(String.valueOf(lo.get(0)));  
            vo.setName(String.valueOf(lo.get(1)));  
            vo.setDate(String.valueOf(lo.get(2)));  
            vo.setMoney(String.valueOf(lo.get(3)));  
            System.out.println("打印信息-->机构:" + vo.getCode() + "  名称：" + vo.getName() + "   时间：" + vo.getDate() + "   资产："  
                    + vo.getMoney());  
        }  
  
        return "success"; // 上传成功则跳转至此success的信息  
    } 
}