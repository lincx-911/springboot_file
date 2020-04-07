package com.lincx_py.springboot.service;

import com.lincx_py.springboot.pojo.Usermodel;


public interface Userservice {
	
	//判断用户名是否存在
	public boolean UsernameisExit(String username);
	//判断用户电话是否存在
	public boolean UseridisExit(String id);
	//保存用户
	public void Save(Usermodel user);
	//通过id得到用户
	public Usermodel getUserById(String id);
	//通过姓名得到用户
	public Usermodel getUserByname(String name);
}
