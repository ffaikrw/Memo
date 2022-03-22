package com.ffaikrw.memo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ffaikrw.memo.common.FileManagerService;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
	
	// 파일 경로를 접근할 수 있는 설정
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/images/**")
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH);
	}
	
	
}
