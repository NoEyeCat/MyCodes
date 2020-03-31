package com.zx.service;

import java.util.List;

import com.zx.pojo.Url;

public interface UrlService {
	List<Url> selByRid(int rid);
	
	List<Url> show();
}
