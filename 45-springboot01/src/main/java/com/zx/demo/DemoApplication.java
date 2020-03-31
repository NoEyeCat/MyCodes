package com.zx.demo;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		}
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//设置单个文件容量最大上传限制
		//只是换了个方法，
		factory.setMaxFileSize(DataSize.of(10, DataUnit.MEGABYTES));
		//设置总启动大小
		factory.setMaxRequestSize(DataSize.of(1, DataUnit.GIGABYTES));
		return factory.createMultipartConfig();
	}
	
	
	
}
