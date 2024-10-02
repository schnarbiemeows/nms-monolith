package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Users;

import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class UsersDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer userId;

	/**
	 * "username" 
	 */
	private String username;

	/**
	 * "email address" 
	 */
	private String email;

	/**
	 * "user's phone number&!@ required for message notifications" 
	 */
	private String phone;

	/**
	 * "password should be encrypted" 
	 */
	private String password;

	/**
	 * "age in years@!& we don't want to store the user's dob" 
	 */
	private Integer age;

	/**
	 * "when did the user last log in?") 
	 */
	private Date lstLogdIn;

	/**
	 * default constructor
	 */
	public UsersDTO() {
		super();
	}

	public UsersDTO(Integer userId, String username, String email, String phone, String password, Integer age, Date lstLogdIn) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.age = age;
		this.lstLogdIn = lstLogdIn;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username=username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone=phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age=age;
	}

	public Date getLstLogdIn() {
		return lstLogdIn;
	}

	public void setLstLogdIn(Date lstLogdIn) {
		this.lstLogdIn=lstLogdIn;
	}

	@Override
	public String toString() {
		return "UsersDTO [userId=" + userId + ", username=" + username + ", email=" + email + ", phone=" + phone + ", password=" + password + ", age=" + age + ", lstLogdIn=" + lstLogdIn + "]";
	}

	public static UsersDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UsersDTO.class );
	}
	public Users toEntity() {
		return new Users(this.getUserId(),this.getUsername(),this.getEmail(),this.getPhone(),this.getPassword(),this.getAge(),this.getLstLogdIn());
	}
}
