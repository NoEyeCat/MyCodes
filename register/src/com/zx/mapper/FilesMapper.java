package com.zx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zx.pojo.Files;

public interface FilesMapper {
	@Select("select * from file")
	List<Files> selAll();
	@Update("update file set count=count+1 where id=#{0}")
	int updById(int id);
}
