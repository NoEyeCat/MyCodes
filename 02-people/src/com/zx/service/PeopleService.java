package com.zx.service;

import java.io.IOException;
import java.util.List;

import com.zx.pojo.People;

/**
 * 在数据访问层和控制器中处理异常，service只抛出异常
 * 
 * 
 * @author zhang
 *
 */
public interface PeopleService {
	/**
	 * 搜索全部
	 * @return people对象
	 */
	List<People> selAll()throws IOException;
}
