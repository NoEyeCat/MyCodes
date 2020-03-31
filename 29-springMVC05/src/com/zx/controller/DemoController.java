package com.zx.controller;




import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class DemoController {
	
	@RequestMapping("upload")
	public String upload(MultipartFile fileName,String name) throws IOException{
		System.out.println("name:"+name);
		String filename = fileName.getOriginalFilename();
		String suffix = filename.substring(filename.lastIndexOf("."));
		String uuid = UUID.randomUUID().toString();
		FileUtils.copyInputStreamToFile(fileName.getInputStream(), new File("E:/"+uuid+suffix));
		return "/index.jsp";
	}
}