package com.myJdbc.springboot4.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloJdbc {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@ResponseBody
	@RequestMapping("/map")
	public Map<String, Object> map() {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
		return list.get(0);
	}
}
