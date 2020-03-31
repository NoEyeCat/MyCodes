package com.zx.service;

import java.io.IOException;
import java.util.List;

import com.zx.pojo.Log;
import com.zx.pojo.Page;
import com.zx.pojo.User;

public interface UserService {
	/**
	 * 付款方账号和密码不匹配状态码
	 * */
	int UNO_PWD_NOT_MATCH=1;
	/**
	 * 余额不足状态码
	 * */
	int ACC_COUNT_NOT_ENOUGH=2;
	/**
	 * 收款方账号和姓名不匹配状态码
	 * */
	int UNO_NAME_NOT_MATCH=3;
	/**
	 * 转账失败状态码
	 * */
	int ERROR=4;
	/**
	 * 转账成功状态码
	 * */
	int SUCCESS=5;
	/**
	 * @param iu 收款方
	 * @param ou 付款方
	 * @return	成功参数
	 * @throws IOException
	 */
	int ZZCount(User iu,User ou) throws IOException;
	
	/**
	 * 分页查看log日志
	 * @param p page存储的属性
	 * @return
	 */
	Page resUser(int pageSize,int pageNumber) throws IOException;
}
