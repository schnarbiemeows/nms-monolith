package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersDTO;
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
@Table(name = "users", uniqueConstraints={@UniqueConstraint( columnNames = {"username"}),@UniqueConstraint( columnNames = {"email"})})
public class Users implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	 * "user's phone number&!@ required for message notifications" 
	 */
	@Column(name = "phone")
	private String phone;

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
	 * "when did the user last log in?") 
	 */
	@Column(name = "lst_logd_in")
	private Date lstLogdIn;

	/**
	 * default constructor
	 */
	public Users() {
		super();
	}

	public Users(Integer userId, String username, String email, String phone, String password, Integer age, Date lstLogdIn) {
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
		return "Users [userId=" + userId + ", username=" + username + ", email=" + email + ", phone=" + phone + ", password=" + password + ", age=" + age + ", lstLogdIn=" + lstLogdIn + "]";
	}

	public static Users fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Users.class );
	}
	public UsersDTO toDTO() {
		return new UsersDTO(this.getUserId(),this.getUsername(),this.getEmail(),this.getPhone(),this.getPassword(),this.getAge(),this.getLstLogdIn());
	}
}
