package com.zx.service;

import java.util.List;

import com.zx.pojo.Pic;

public interface PicService {
	int insPic(Pic pic);	
	
	List<Pic> show();
	
	int delPic(int id);
}
