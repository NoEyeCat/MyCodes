package com.zx.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zx.pojo.Users;
import com.zx.service.UsersService;

@Controller
public class UsersController {
	@Resource
	private UsersService usersServiceImpl;
	@RequestMapping("register")
	public String register(Users user,MultipartFile file,HttpServletRequest req){
		String fileName=UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String path=req.getServletContext().getRealPath("images")+"/"+fileName;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//最高只能取到webapps中的内容
		user.setPhoto(fileName);
		int index = usersServiceImpl.insRegister(user);
		if (index>0) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			return "redirect:/show";
		}else{
			return "redirect:/register.jsp";
		}
	}
}
