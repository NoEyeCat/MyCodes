package com.zx.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zx.pojo.Pic;
import com.zx.service.PicService;

@Controller
public class PicController {
	@Resource
	private PicService picServiceImpl;
	@RequestMapping("insert")
	public String insert(MultipartFile file,HttpServletRequest req){
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(req.getServletContext().getRealPath("images"),file.getOriginalFilename()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pic pic=new Pic();
		pic.setPath(file.getOriginalFilename());
		int insPic = picServiceImpl.insPic(pic);
		if (insPic>0) {
			return "show";
		}else {
			return "/add.jsp";
		}
	}
	@RequestMapping("show")
	public String show(Model model){
		model.addAttribute("list", picServiceImpl.show());
		return "/main.jsp";
	}
	@RequestMapping("delete")
	public String delete(int id,Model model){
		int delPic = picServiceImpl.delPic(id);
		if (delPic>0) {
			model.addAttribute("opper", "删除成功");
			return "show";
		}else{
			model.addAttribute("opper", "删除失败");
			return "show";
		}
	}
}
