package com.zx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zx.pojo.Url;

public interface UrlMapper {
	@Select("select * from url where id in(select uid from role_url where rid=#{0})")
	List<Url> selUrl(int id);
	@Select("select * from url")
	List<Url> selAll();
}
