package com.zx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.zx.pojo.Pic;

public interface PicMapper {
	/**
	 * 新增图片功能
	 * @param pic
	 * @return
	 */
	int insPic(Pic pic);
	
	/**
	 * 显示全部功能
	 * @return
	 */
	@Select("select * from pic")
	List<Pic> selAll();
	
	/**
	 * 删除指定图片
	 * @param id
	 * @return
	 */
	@Delete("delete from pic where id=#{0}")
	int delPic(int id);
}
