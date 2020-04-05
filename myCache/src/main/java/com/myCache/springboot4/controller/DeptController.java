package com.myCache.springboot4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myCache.springboot4.model.Department;
import com.myCache.springboot4.service.DeptService;

@RestController
public class DeptController {
	   @Autowired
	    DeptService deptService;
	   
	    @GetMapping("/dept/{id}")
	    public Department getDept(@PathVariable("id") Integer id){
	        return deptService.getDeptById(id);
	    }
	    @GetMapping("/dept")
	    public Department updateDept(Department department) {
	    	return deptService.updatDept(department);
	    }
	    @GetMapping("/deledept")
	    public void deleteDept(Integer id) {
	    	deptService.deleteDept(id);
	    }
	    @GetMapping("/dept/searchname/{name}")
	    public Department getDaptByName(String name) {
	    	return deptService.getDaptByName(name);
	    }
	    
	
}
