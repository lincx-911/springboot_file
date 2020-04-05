package com.myCache.springboot4;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.myCache.springboot4.mapper")
@SpringBootApplication
@EnableCaching
public class MyCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCacheApplication.class, args);
	}

}
