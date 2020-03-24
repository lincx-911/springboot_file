package com.myweb.springboot4.config;

//import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myweb.springboot4.component.LoginHandleIntercetor;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{
	
	public void addVieWControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	@Bean//注册组件在容器中
	public WebMvcConfigurer webMvcConfigurer() {
		WebMvcConfigurer wmcConfigurer = new WebMvcConfigurer() {
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("index");
				registry.addViewController("/login").setViewName("login");
				registry.addViewController("/main").setViewName("databoard");
			}
			
			//注册拦截器
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new LoginHandleIntercetor()).addPathPatterns("/**")
				.excludePathPatterns("/login","/","/user/login").excludePathPatterns("/assets/**");
			}

//			@Override
//			public void addResourceHandlers(ResourceHandlerRegistry registry) {
//				// TODO Auto-generated method stub
//
//				//addResourceHandler请求路径
//				//addResourceLocations 在项目中的资源路径
//				//setCacheControl 设置静态资源缓存时间
//				registry.addResourceHandler("classpath:/static/").setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
//				
//				WebMvcConfigurer.super.addResourceHandlers(registry);
//			}
			
		
		};
		return wmcConfigurer;
	}
}
