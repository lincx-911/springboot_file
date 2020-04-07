package com.lincx_py.springboot.service.impl;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

import com.lincx_py.springboot.dao.Usermapper;
import com.lincx_py.springboot.pojo.Usermodel;
import com.lincx_py.springboot.service.Userservice;
import com.lincx_py.springboot.utils.MD5Utils;

@Service
@CacheConfig(cacheNames = "user",cacheManager ="redisCacheManager" )
public class UserserviceImpl implements Userservice{
	
	
	@Autowired
	private Usermapper usermapper;
	
	@Qualifier("redisCacheManager")
	@Autowired
	RedisCacheManager redisCacheManager;
	
	@Override
	public boolean UsernameisExit(String username) {
		
		return false;
	}
	
	@Override
	public void Save(Usermodel user) {
		// TODO Auto-generated method stub
		try {
			user.setPassword(MD5Utils.getMD5String(user.getPassword()));
			String id=RandomStringUtils.randomAlphanumeric(10);
			while(UseridisExit(id)) {
				id = RandomStringUtils.randomAlphanumeric(10);
			}
			user.setId(id);
			user.setFace_image(null);
			user.setFans_counts(0);
			user.setFollow_counts(0);
			user.setReceive_like_conuts(0);
			usermapper.InsertUser(user);
			
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
	//@Cacheable()
	@Override
	public Usermodel getUserById(String id) {
		Usermodel usermodel = usermapper.selectUserbyId(id);
		System.out.println(usermodel);
		return usermodel;
	}
	//@Cacheable()
	@Override
	public Usermodel getUserByname(String username) {
		Usermodel usermodel = usermapper.SelectUserbyName(username);
		System.out.println(usermodel);
		return usermodel;
	}

	@Override
	public boolean UseridisExit(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
