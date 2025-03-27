package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Users;
import jakarta.validation.constraints.*;
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
public class UsersDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer userId;

	/**
	 * 'unique username' 
	 */
	private String username;

	/**
	 * 'unique email address' 
	 */
	private String email;

	/**
	 * 'password should be encrypted' 
	 */
	private String password;

	/**
	 * 'age in years@!& we don''t want to store the user''s dob' 
	 */
	private Integer age;

	/**
	 * 'when did the user last log in?' 
	 */
	private Date lstLogdIn;

	/**
	 * 'user''s phone number&!@ required for message notifications' 
	 */
	private String phone;

	/**
	 * 
	 */
	private boolean actv;

	/**
	 * 
	 */
	private String[] authorizations;

	/**
	 * 
	 */
	private String firstName;

	/**
	 * 
	 */
	private String lastName;

	/**
	 * 
	 */
	private boolean userNotLocked;

	/**
	 * 
	 */
	private Date joinDate;

	/**
	 * 
	 */
	private Date lastLoginDateDisplay;

	/**
	 * 
	 */
	private String profileImage;

	/**
	 * 
	 */
	private String roles;

	/**
	 * 
	 */
	private String userIdentifier;

	/**
	 * default constructor
	 */
	public UsersDTO() {
		super();
	}

	public UsersDTO(Integer userId, String username, String email, String password, Integer age, Date lstLogdIn, String phone, boolean actv, String[] authorizations, String firstName, String lastName, boolean userNotLocked, Date joinDate, Date lastLoginDateDisplay, String profileImage, String roles, String userIdentifier) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.age = age;
		this.lstLogdIn = lstLogdIn;
		this.phone = phone;
		this.actv = actv;
		this.authorizations = authorizations;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userNotLocked = userNotLocked;
		this.joinDate = joinDate;
		this.lastLoginDateDisplay = lastLoginDateDisplay;
		this.profileImage = profileImage;
		this.roles = roles;
		this.userIdentifier = userIdentifier;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone=phone;
	}

	public boolean getActv() {
		return actv;
	}

	public void setActv(boolean actv) {
		this.actv=actv;
	}

	public String[] getAuthorizations() {
		return authorizations;
	}

	public void setAuthorizations(String[] authorizations) {
		this.authorizations=authorizations;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName=lastName;
	}

	public boolean getUserNotLocked() {
		return userNotLocked;
	}

	public void setUserNotLocked(boolean userNotLocked) {
		this.userNotLocked=userNotLocked;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate=joinDate;
	}

	public Date getLastLoginDateDisplay() {
		return lastLoginDateDisplay;
	}

	public void setLastLoginDateDisplay(Date lastLoginDateDisplay) {
		this.lastLoginDateDisplay=lastLoginDateDisplay;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage=profileImage;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles=roles;
	}

	public String getUserIdentifier() {
		return userIdentifier;
	}

	public void setUserIdentifier(String userIdentifier) {
		this.userIdentifier=userIdentifier;
	}

	@Override
	public String toString() {
		return "UsersDTO [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", age=" + age + ", lstLogdIn=" + lstLogdIn + ", phone=" + phone + ", actv=" + actv + ", authorizations=" + authorizations + ", firstName=" + firstName + ", lastName=" + lastName + ", userNotLocked=" + userNotLocked + ", joinDate=" + joinDate + ", lastLoginDateDisplay=" + lastLoginDateDisplay + ", profileImage=" + profileImage + ", roles=" + roles + ", userIdentifier=" + userIdentifier + "]";
	}

	public static UsersDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UsersDTO.class );
	}
	public Users toEntity() {
		return new Users(this.getUserId(),this.getUsername(),this.getEmail(),this.getPassword(),this.getAge(),this.getLstLogdIn(),this.getPhone(),this.getActv(),this.getAuthorizations(),this.getFirstName(),this.getLastName(),this.getUserNotLocked(),this.getJoinDate(),this.getLastLoginDateDisplay(),this.getProfileImage(),this.getRoles(),this.getUserIdentifier());
	}
}
