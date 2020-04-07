package com.lincx_py.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lincx_py.springboot.pojo.Usermodel;
import com.lincx_py.springboot.service.impl.UserserviceImpl;
import com.lincx_py.springboot.utils.CovertoJson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "用户注册登录的接口", tags = {"注册和登录的controller"})
public class usercontroller {
	
	@Autowired
	private UserserviceImpl userservice;
	
	@ApiOperation(value = "用户注册",notes = "用户注册的接口")
	@PostMapping("/regist")
	public String regist(@RequestBody Usermodel user) throws JsonProcessingException {
		String username = user.getUsername();
		String userpassword = user.getPassword();
		CovertoJson msgCovertoJson = new CovertoJson();
		if(username.isEmpty()||userpassword.isEmpty()) {
			msgCovertoJson.setData(null);
			msgCovertoJson.setMsg("用户名或者密码不能为空");
			msgCovertoJson.setStatus(500);
			return CovertoJson.ObjestrtoJson(msgCovertoJson);
		}
		if(userservice.getUserByname(username)!=null) {
			msgCovertoJson.setData(null);
			msgCovertoJson.setMsg("用户名已存在");
			msgCovertoJson.setStatus(500);
			return CovertoJson.ObjestrtoJson(msgCovertoJson); 
		}
		userservice.Save(user);
		user.setPassword(null);
		msgCovertoJson.setStatus(200);
		msgCovertoJson.setMsg("注册成功");
		msgCovertoJson.setData(user);
		return CovertoJson.ObjestrtoJson(msgCovertoJson);
	}

}
