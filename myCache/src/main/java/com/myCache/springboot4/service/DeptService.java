package com.myCache.springboot4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

import com.myCache.springboot4.mapper.DeptMapper;
import com.myCache.springboot4.model.Department;

@CacheConfig(cacheNames = "dept",cacheManager ="redisCacheManager" )
@Service
public class DeptService {
	
	@Autowired
	DeptMapper deptMapper;
	
	@Qualifier("redisCacheManager")
	@Autowired
	RedisCacheManager redisCacheManager;
	  @Cacheable()
	  public Department getDeptById(Integer id){
	      System.out.println("查询部门"+id);
	      Department department = deptMapper.getDeptById(id);
	      return department;
	  }
	  @CacheEvict(beforeInvocation = true)
	  public void deleteDept(Integer id) {
		  System.out.println("删除部门"+id);
		  deptMapper.deleteDept(id);
	  }
	  @CachePut(key = "#result.id")
	  public Department updatDept(Department department) {
		  deptMapper.updateDept(department);
		  System.out.println("更新部门"+department.toString());
		  return department;
	  }
	  @Caching(
			  cacheable = {
					  @Cacheable(key = "#departmentName")
			  },
			  put = {
					  @CachePut(key = "#id")
			  }
			  
	 )
	  public Department getDaptByName(String name) {
		  Department department = deptMapper.getDaptByName(name);
		  return department;
	  }
	//使用缓存管理器得到缓存，进行api调用
	
//	public Department getDeptById(Integer id) {
//		System.out.println("查询部门"+id);
//		Department department = deptMapper.getDeptById(id);
//		
//		//获取某个缓存
//		Cache dept = deptCacheManager.getCache("dept");
//		dept.put("dept:1", department);
//		return department;
//		
//	}
	
}
