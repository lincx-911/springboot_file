package com.myweb.springboot4.component;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

//给容器中加入我们自己定义的ErrorAttributes
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{

	//返回的map就是页面和json能获取的所有字段
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		// TODO Auto-generated method stub
		Map<String, Object> map=super.getErrorAttributes(webRequest, includeStackTrace);
		map.put("company", "myweb");
		
		//我们的一场处理器携带的数据
		Map<String, Object> ext = (Map<String, Object>)webRequest.getAttribute("ext", 0);
		map.put("ext", ext);
		return map;
	}

	
}
