package com.myweb.springboot4.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/login2")
	public String hello() {
		return "hello world";
	}
	
	@GetMapping("/login1")
	public String success(Map<String, Object> map) {
		map.put("hello", "<h1>你好</h1>");
		map.put("users", Arrays.asList("zhansan","lisi","wangwu"));
		return "index";
	}
}
