package com.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.NonNull;

@Configuration
public class WebCorsFilter implements WebMvcConfigurer{
	
	//@Override
	public void addCorsMapping(@NonNull CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods(CorsConfiguration.ALL)
		.allowedOrigins(CorsConfiguration.ALL);
	}
	

}


