package com.zx.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/v2/*/**");
		//excludePathPatterns设置不拦截哪些资源
		registry.addInterceptor(new LoginInterceptor2()).addPathPatterns("/v2/*/**");
		//.excludePathPatterns("/vv/xxx/**");
	}
	
}
