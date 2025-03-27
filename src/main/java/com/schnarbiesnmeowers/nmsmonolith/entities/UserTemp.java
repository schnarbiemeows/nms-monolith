package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.UserTempDTO;
import jakarta.persistence.*;
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
@Table(name = "user_temp")
public class UserTemp implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "user_temp_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userTempId;

	/**
	 * 
	 */
	@Column(name = "username")
	private String username;

	/**
	 * 
	 */
	@Column(name = "email")
	private String email;

	/**
	 * 
	 */
	@Column(name = "phone")
	private String phone;

	/**
	 * 
	 */
	@Column(name = "first_name")
	private String firstName;

	/**
	 * 
	 */
	@Column(name = "last_name")
	private String lastName;

	/**
	 * 
	 */
	@Column(name = "age")
	private Integer age;

	/**
	 * 
	 */
	@Column(name = "actv")
	private boolean actv;

	/**
	 * 
	 */
	@Column(name = "authorizations")
	private String[] authorizations;

	/**
	 * 
	 */
	@Column(name = "user_not_locked")
	private boolean userNotLocked;

	/**
	 * 
	 */
	@Column(name = "created_date")
	private Date createdDate;

	/**
	 * 
	 */
	@Column(name = "join_date")
	private Date joinDate;

	/**
	 * 
	 */
	@Column(name = "last_login_date")
	private Date lastLoginDate;

	/**
	 * 
	 */
	@Column(name = "last_login_date_display")
	private Date lastLoginDateDisplay;

	/**
	 * 
	 */
	@Column(name = "password")
	private String password;

	/**
	 * 
	 */
	@Column(name = "profile_image")
	private String profileImage;

	/**
	 * 
	 */
	@Column(name = "roles")
	private String roles;

	/**
	 * 
	 */
	@Column(name = "user_identifier")
	private String userIdentifier;

	/**
	 * 
	 */
	@Column(name = "unique_id")
	private String uniqueId;

	/**
	 * default constructor
	 */
	public UserTemp() {
		super();
	}

	public UserTemp(Integer userTempId, String username, String email, String phone, String firstName, String lastName, Integer age, boolean actv, String[] authorizations, boolean userNotLocked, Date createdDate, Date joinDate, Date lastLoginDate, Date lastLoginDateDisplay, String password, String profileImage, String roles, String userIdentifier, String uniqueId) {
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
		return "UserTemp [userTempId=" + userTempId + ", username=" + username + ", email=" + email + ", phone=" + phone + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", actv=" + actv + ", authorizations=" + authorizations + ", userNotLocked=" + userNotLocked + ", createdDate=" + createdDate + ", joinDate=" + joinDate + ", lastLoginDate=" + lastLoginDate + ", lastLoginDateDisplay=" + lastLoginDateDisplay + ", password=" + password + ", profileImage=" + profileImage + ", roles=" + roles + ", userIdentifier=" + userIdentifier + ", uniqueId=" + uniqueId + "]";
	}

	public static UserTemp fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UserTemp.class );
	}
	public UserTempDTO toDTO() {
		return new UserTempDTO(this.getUserTempId(),this.getUsername(),this.getEmail(),this.getPhone(),this.getFirstName(),this.getLastName(),this.getAge(),this.getActv(),this.getAuthorizations(),this.getUserNotLocked(),this.getCreatedDate(),this.getJoinDate(),this.getLastLoginDate(),this.getLastLoginDateDisplay(),this.getPassword(),this.getProfileImage(),this.getRoles(),this.getUserIdentifier(),this.getUniqueId());
	}
}
