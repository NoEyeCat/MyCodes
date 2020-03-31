package com.zx.service;

import java.util.List;

import com.zx.pojo.Files;
import com.zx.pojo.Users;

public interface FilesService {
	/**
	 * 显示全部
	 * @return
	 */
	List<Files> show();
	
	/**
	 * 根据id修改资料的下载次数
	 * @param id
	 * @return
	 */
	int updCount(int id,Users user,String name);
}
