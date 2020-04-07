package com.lincx_py.springboot.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lincx_py.springboot.pojo.Usermodel;

@Mapper
public interface Usermapper {
	@Select("SELECT * FROM users WHERE username = #{username}")
	public Usermodel SelectUserbyName(String username);
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	public Usermodel selectUserbyId(String id);
	
	@Insert("INSERT INTO users "
			+ "(id,username,password,face_image,fans_counts,follow_counts,receive_like_conuts)"
			+ " VALUES "
			+ "(#{id},#{username},#{password},#{face_image},#{fans_counts},#{follow_counts},#{receive_like_conuts})")
	public int InsertUser(Usermodel user);
	
	@Update("UPDATE users SET username=#{username},#password={password},face_image=#{face_image},fans_counts=#{fans_counts},follow_counts=#{follow_counts},receive_like_conuts=#{receive_like_conuts})")
	public int UpdateUser(Usermodel user);
	
	@Update("UPDATE users SET username=#{username} WHERE id=#{id}")
	public int UpdateUserName(String Id);
	
	@Update("UPDATE users SET password=#{password} WHERE username=#{username}")
	public int UpdateUserPassword(String name);
	
	@Update("UPDATE users SET face_image=#{face_image} WHERE username=#{username}")
	public int UpdateUserFace_ima(String name);
	
	@Update("UPDATE users SET fans_counts=#{fans_counts} WHERE username=#{username}")
	public int UpdateUserFans_counts(String name);
	
	@Update("UPDATE users SET follow_counts=#{follow_counts} WHERE username=#{username}")
	public int UpdateUserFollow_counts(String name);
	
	@Update("UPDATE users SET receive_like_conuts=#{receive_like_conuts} WHERE username=#{username}")
	public int UpdateUserRec_l_co(String name);
	
	@Delete("DELETE FROM users WHERE usename=#{username}")
	public int DeleteUserbyName(String username);
	
	@Delete("DELETE FROM users WHERE id=#{id}")
	public int DeleteUserbyId(String id);
}
