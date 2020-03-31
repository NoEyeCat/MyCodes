package com.zx.controller;



import java.io.File;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {
	@RequestMapping("download")
	public void download(String fileName,HttpServletResponse resp,HttpServletRequest req) throws IOException{
		//设置响应流中文件是恒下载
		resp.setHeader("content-Disposition", "attachment;filename="+fileName);
		//把二进制流放入到响应体中
		ServletOutputStream os = resp.getOutputStream();
		
		File files=new File(req.getServletContext().getRealPath("files"), fileName);
		byte[] bs= FileUtils.readFileToByteArray(files);
		os.write(bs);
		os.flush();
		os.close();
		}
}