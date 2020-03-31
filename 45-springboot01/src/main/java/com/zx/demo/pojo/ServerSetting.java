package com.zx.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//服务器配置
@Component
@PropertySource({"classpath:application.properties"})
//配置所有需要注入的属性前缀 这种注入方式不需要写value注解(即使没有写前缀)  而是通过名称进行映射
@ConfigurationProperties(prefix = "test")
public class ServerSetting {
	//服务器名称
	/* @Value("${name}") */
	private String name;
	//域名地址
	/* @Value("${domain}") */
	private String domain;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
}
