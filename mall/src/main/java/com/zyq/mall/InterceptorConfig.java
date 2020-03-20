package com.zyq.mall;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by zhangyiqi
 * 拦截器，对http请求进行拦截，除了过滤的这些（excludePathPatterns）
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserLoginInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/error", "/user/login", "/user/register", "/categories", "/products", "/products/*");
	}
}
