package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.UsersHist;

import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class UsersHistDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer usersHistId;

	/**
	 * "fk to the users.user_id field" 
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
	 * "password should be encrypted" 
	 */
	private String password;

	/**
	 * "age in years@!& we don't want to store the user's dob" 
	 */
	private Integer age;

	/**
	 * "when did the user last log in?" 
	 */
	private Date lstLogdIn;

	/**
	 * "what action was performed on this record?" 
	 */
	private Integer actionTypeId;

	/**
	 * "when did this action happen?" 
	 */
	private Date evntTmestmp;

	/**
	 * "who did this action?&!@ fk to the users.user_id field" 
	 */
	private Integer evntOperId;

	/**
	 * default constructor
	 */
	public UsersHistDTO() {
		super();
	}

	public UsersHistDTO(Integer usersHistId, Integer userId, String username, String email, String password, Integer age, Date lstLogdIn, Integer actionTypeId, Date evntTmestmp, Integer evntOperId) {
		super();
		this.usersHistId = usersHistId;
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.lstLogdIn = lstLogdIn;
		this.actionTypeId = actionTypeId;
		this.evntTmestmp = evntTmestmp;
		this.evntOperId = evntOperId;
	}

	public Integer getUsersHistId() {
		return usersHistId;
	}

	public void setUsersHistId(Integer usersHistId) {
		this.usersHistId=usersHistId;
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

	public Integer getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(Integer actionTypeId) {
		this.actionTypeId=actionTypeId;
	}

	public Date getEvntTmestmp() {
		return evntTmestmp;
	}

	public void setEvntTmestmp(Date evntTmestmp) {
		this.evntTmestmp=evntTmestmp;
	}

	public Integer getEvntOperId() {
		return evntOperId;
	}

	public void setEvntOperId(Integer evntOperId) {
		this.evntOperId=evntOperId;
	}

	@Override
	public String toString() {
		return "UsersHistDTO [usersHistId=" + usersHistId + ", userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", age=" + age + ", lstLogdIn=" + lstLogdIn + ", actionTypeId=" + actionTypeId + ", evntTmestmp=" + evntTmestmp + ", evntOperId=" + evntOperId + "]";
	}

	public static UsersHistDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UsersHistDTO.class );
	}
	public UsersHist toEntity() {
		return new UsersHist(this.getUsersHistId(),this.getUserId(),this.getUsername(),this.getEmail(),this.getPassword(),this.getAge(),this.getLstLogdIn(),this.getActionTypeId(),this.getEvntTmestmp(),this.getEvntOperId());
	}
}
