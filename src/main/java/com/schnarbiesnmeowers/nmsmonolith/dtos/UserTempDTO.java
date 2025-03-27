package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.UserTemp;
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
public class UserTempDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer userTempId;

	/**
	 * 
	 */
	private String username;

	/**
	 * 
	 */
	private String email;

	/**
	 * 
	 */
	private String phone;

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
	private Integer age;

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
	private boolean userNotLocked;

	/**
	 * 
	 */
	private Date createdDate;

	/**
	 * 
	 */
	private Date joinDate;

	/**
	 * 
	 */
	private Date lastLoginDate;

	/**
	 * 
	 */
	private Date lastLoginDateDisplay;

	/**
	 * 
	 */
	private String password;

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
	 * 
	 */
	private String uniqueId;

	/**
	 * default constructor
	 */
	public UserTempDTO() {
		super();
	}

	public UserTempDTO(Integer userTempId, String username, String email, String phone, String firstName, String lastName, Integer age, boolean actv, String[] authorizations, boolean userNotLocked, Date createdDate, Date joinDate, Date lastLoginDate, Date lastLoginDateDisplay, String password, String profileImage, String roles, String userIdentifier, String uniqueId) {
		super();
		this.userTempId = userTempId;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.actv = actv;
		this.authorizations = authorizations;
		this.userNotLocked = userNotLocked;
		this.createdDate = createdDate;
		this.joinDate = joinDate;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginDateDisplay = lastLoginDateDisplay;
		this.password = password;
		this.profileImage = profileImage;
		this.roles = roles;
		this.userIdentifier = userIdentifier;
		this.uniqueId = uniqueId;
	}

	public Integer getUserTempId() {
		return userTempId;
	}

	public void setUserTempId(Integer userTempId) {
		this.userTempId=userTempId;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age=age;
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

	public boolean getUserNotLocked() {
		return userNotLocked;
	}

	public void setUserNotLocked(boolean userNotLocked) {
		this.userNotLocked=userNotLocked;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate=createdDate;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate=joinDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate=lastLoginDate;
	}

	public Date getLastLoginDateDisplay() {
		return lastLoginDateDisplay;
	}

	public void setLastLoginDateDisplay(Date lastLoginDateDisplay) {
		this.lastLoginDateDisplay=lastLoginDateDisplay;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password=password;
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

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId=uniqueId;
	}

	@Override
	public String toString() {
		return "UserTempDTO [userTempId=" + userTempId + ", username=" + username + ", email=" + email + ", phone=" + phone + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", actv=" + actv + ", authorizations=" + authorizations + ", userNotLocked=" + userNotLocked + ", createdDate=" + createdDate + ", joinDate=" + joinDate + ", lastLoginDate=" + lastLoginDate + ", lastLoginDateDisplay=" + lastLoginDateDisplay + ", password=" + password + ", profileImage=" + profileImage + ", roles=" + roles + ", userIdentifier=" + userIdentifier + ", uniqueId=" + uniqueId + "]";
	}

	public static UserTempDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UserTempDTO.class );
	}
	public UserTemp toEntity() {
		return new UserTemp(this.getUserTempId(),this.getUsername(),this.getEmail(),this.getPhone(),this.getFirstName(),this.getLastName(),this.getAge(),this.getActv(),this.getAuthorizations(),this.getUserNotLocked(),this.getCreatedDate(),this.getJoinDate(),this.getLastLoginDate(),this.getLastLoginDateDisplay(),this.getPassword(),this.getProfileImage(),this.getRoles(),this.getUserIdentifier(),this.getUniqueId());
	}
}
