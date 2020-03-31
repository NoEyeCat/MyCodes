package com.zx.service;

import java.io.IOException;


import com.zx.pojo.PageInfo;


public interface StudentService {
	PageInfo selStudents(String sname,String tname,String pageSizeStr,String pageNumberStr) throws IOException;
}	
