package com.myCache.springboot4.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myCache.springboot4.model.Department;

@Mapper
public interface DeptMapper {
	@Select("SELECT * FROM department WHERE id = #{id}")
	public Department getDeptById(Integer id);
	
	@Insert("INSERT INTO department(id,departmentNmae) VALUES (#{id},#{departmentName})")
	public void insertDept(Department department);
	
	@Update("UPDATE department SET id=#{id},departmentName=#{departmentName}")
	public void updateDept(Department department);
	
	@Delete("DELETE FROM department WHERE id=#{id}")
	public void deleteDept(Integer id);
	
	@Select("SELECT * FROM department WHERE departmentNmae = #{departmentNmae}")
	public Department getDaptByName(String name);
}
