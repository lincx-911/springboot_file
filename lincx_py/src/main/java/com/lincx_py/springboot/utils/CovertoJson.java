package com.lincx_py.springboot.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CovertoJson {
	//响应业务状态
	private Integer status;
	
	//响应信息
	private String msg;
	
	//响应数据
	private Object data;
	
	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static String ObjestrtoJson(Object object) throws JsonProcessingException {
		
		return mapper.writeValueAsString(object);
	}
	
	public static <T>T JsontoBean(String data,Class<T> beanType) throws JsonMappingException, JsonProcessingException{
		T t = mapper.readValue(data, beanType);
		return t;
	}
	
	public static  <T>List<T> JsonToList(String data, Class<T> beanType) throws JsonMappingException, JsonProcessingException{
		
		JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, beanType);
		List<T> list = mapper.readValue(data, javaType);
		return list;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
