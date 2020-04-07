package com.lincx_py.springboot.utils;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;


//使用MD5加密
public class MD5Utils {
	public static String getMD5String(String strValue) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		String newValueString = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
		return newValueString;
	}

}
