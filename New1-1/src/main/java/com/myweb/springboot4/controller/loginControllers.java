package com.myweb.springboot4.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginControllers {
	//@DeleteMapping
	//@PutMapping
	
	//@GetMapping(value = "/user/login")
	@PostMapping(value = "/user/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						Map<String, Object>map,HttpSession session) {
		if(!StringUtils.isEmpty(username)&&"12345678".equals(password)) {
			// 防止表单重复提交，可以重定向到主页
			session.setAttribute("loginUser", username);
			return "redirect:/main";
		}else {
			map.put("msg", "用户名错误");
			return "/login";
		}
		
	}
}
