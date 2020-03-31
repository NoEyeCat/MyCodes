package com.zx.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zx.pojo.Users;
import com.zx.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersService;
	
	@RequestMapping("register")
	public String register(Users user,MultipartFile file,HttpServletRequest req){
		String filename = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String path = req.getServletContext().getRealPath("images")+"/"+filename;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setPhoto(filename);
		int insUsers = usersService.insUsers(user);
		if (insUsers>0) {
			return "/success.jsp";
		}else {
			return "/index.jsp";
		}
		
	}
}
