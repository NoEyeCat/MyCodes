package com.zx.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zx.demo.pojo.JsonData;

@Controller
@PropertySource({"classpath:application.properties"})
public class FileController {
	
	//设置文件路径
	@Value("${web.file.path}")
	private String filePath;
	
	/**
	 * 利用插件进行跳转的API
	 * @return
	 */
	@RequestMapping("/api/v1/gopage")
	public Object index() {
		return "index";
	}
	
	/**
	 * 文件上传测试用API
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public Object upload(@RequestParam("head_images")MultipartFile file,HttpServletRequest req) {
		
		//file.isEmpty();判断文件是否为空
		//file.getSize();获取文件大小并进行限制操作
		
		
		String name = req.getParameter("username");
		System.out.println("用户名:"+name);
		
		//尝试获取文件路径
		/*
		 * String realPath =
		 * req.getServletContext().getRealPath("src/main/resources/static/images");
		 * System.out.println("（尝试）文件路径："+realPath);
		 */
		
		//获取文件名
		String fileName=file.getOriginalFilename();
		System.out.println("上传的文件名为："+fileName);
		
		//获取文件后缀名
		String sufFileName = fileName.substring(fileName.lastIndexOf("."));
		System.out.println("文件后缀名为："+sufFileName);
		
		//设置文件上传后路径
		fileName=UUID.randomUUID().toString()+sufFileName;
		System.out.println("转换后的名称："+fileName);
		System.out.println("文件上传路径为："+filePath);
		File dest= new File(filePath+fileName);
		
		//文件上传
		try {
			file.transferTo(dest);
			return new JsonData(0, fileName);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new JsonData(-1, "fail to save file");
	}
}

