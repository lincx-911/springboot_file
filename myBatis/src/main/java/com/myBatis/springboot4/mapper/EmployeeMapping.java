package com.myBatis.springboot4.mapper;

import com.myBatis.springboot4.bean.Employee;

//@Mapper或者MapperScan将接口扫描到容器中
public interface EmployeeMapping {
	public Employee getEmpById(Integer id); 
		
	public void insertEmp(Employee employee);
	
}
