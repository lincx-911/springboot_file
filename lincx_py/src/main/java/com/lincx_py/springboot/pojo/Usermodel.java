package com.lincx_py.springboot.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "用户对象",description = "这是用户对象")
public class Usermodel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(hidden = true)//隐藏
	private String id;//用电话号码表示
	
	@ApiModelProperty(value = "用户名", name = "username",example = "lincx_py",required = true)
	private String username;
	@ApiModelProperty(value = "密码", name = "password",example = "123456",required = true)
	private String password;
	
	@ApiModelProperty(hidden = true)//隐藏
	private String face_image;
	
	@ApiModelProperty(hidden = true)//隐藏
	private Integer fans_counts;
	
	@ApiModelProperty(hidden = true)//隐藏
	private Integer follow_counts;
	
	@ApiModelProperty(hidden = true)//隐藏
	private Integer receive_like_conuts;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFace_image() {
		return face_image;
	}
	public void setFace_image(String face_image) {
		this.face_image = face_image;
	}
	public Integer getFans_counts() {
		return fans_counts;
	}
	public void setFans_counts(Integer fans_counts) {
		this.fans_counts = fans_counts;
	}
	public Integer getFollow_counts() {
		return follow_counts;
	}
	public void setFollow_counts(Integer follow_counts) {
		this.follow_counts = follow_counts;
	}
	public Integer getReceive_like_conuts() {
		return receive_like_conuts;
	}
	public void setReceive_like_conuts(Integer receive_like_conuts) {
		this.receive_like_conuts = receive_like_conuts;
	}
	
}
