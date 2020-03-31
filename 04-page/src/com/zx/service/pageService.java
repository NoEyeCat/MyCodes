package com.zx.service;

import java.io.IOException;
import java.util.List;

import com.zx.pojo.People;
import com.zx.pojo.pageInfo;

public interface pageService {
	/**
	 * 
	 * 分页显示
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 * @throws IOException
	 */
	pageInfo page(int pageSize,int pageNumber) throws IOException;
}
