package com.myBatis.springboot4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myBatis.springboot4.bean.Department;
import com.myBatis.springboot4.bean.Employee;
import com.myBatis.springboot4.mapper.DepartmentMapper;
import com.myBatis.springboot4.mapper.EmployeeMapping;

@RestController
public class DeptController {
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapping employeeMapping;
	
	@GetMapping("/dept/{id}")
	public Department getDepartment(@PathVariable("id") Integer id) {
		return departmentMapper.getDeptById(id);
	}
	
	@GetMapping("/dept")
	public Department insertDepartment (Department department) {
		departmentMapper.insertDept(department);
		return department;
	}
	
	@GetMapping("/emp/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return employeeMapping.getEmpById(id);
	}
	
}
