package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersHistDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "users_hist")
public class UsersHist implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "users_hist_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer usersHistId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "username" 
	 */
	@Column(name = "username")
	private String username;

	/**
	 * "email address" 
	 */
	@Column(name = "email")
	private String email;

	/**
	 * "password should be encrypted" 
	 */
	@Column(name = "password")
	private String password;

	/**
	 * "age in years@!& we don't want to store the user's dob" 
	 */
	@Column(name = "age")
	private Integer age;

	/**
	 * "when did the user last log in?" 
	 */
	@Column(name = "lst_logd_in")
	private Date lstLogdIn;

	/**
	 * "what action was performed on this record?" 
	 */
	@Column(name = "action_type_id")
	private Integer actionTypeId;

	/**
	 * "when did this action happen?" 
	 */
	@Column(name = "evnt_tmestmp")
	private Date evntTmestmp;

	/**
	 * "who did this action?&!@ fk to the users.user_id field" 
	 */
	@Column(name = "evnt_oper_id")
	private Integer evntOperId;

	/**
	 * default constructor
	 */
	public UsersHist() {
		super();
	}

	public UsersHist(Integer usersHistId, Integer userId, String username, String email, String password, Integer age, Date lstLogdIn, Integer actionTypeId, Date evntTmestmp, Integer evntOperId) {
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
		return "UsersHist [usersHistId=" + usersHistId + ", userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", age=" + age + ", lstLogdIn=" + lstLogdIn + ", actionTypeId=" + actionTypeId + ", evntTmestmp=" + evntTmestmp + ", evntOperId=" + evntOperId + "]";
	}

	public static UsersHist fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UsersHist.class );
	}
	public UsersHistDTO toDTO() {
		return new UsersHistDTO(this.getUsersHistId(),this.getUserId(),this.getUsername(),this.getEmail(),this.getPassword(),this.getAge(),this.getLstLogdIn(),this.getActionTypeId(),this.getEvntTmestmp(),this.getEvntOperId());
	}
}
