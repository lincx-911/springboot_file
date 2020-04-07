package com.lincx_py.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.lincx_py.springboot.dao")
@EnableCaching
@EnableSwagger2
public class LincxPyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LincxPyApplication.class, args);
	}

}
