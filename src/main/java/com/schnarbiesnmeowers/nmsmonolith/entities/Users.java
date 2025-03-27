package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.UsersDTO;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;

	/**
	 * 'unique username' 
	 */
	@Column(name = "username")
	private String username;

	/**
	 * 'unique email address' 
	 */
	@Column(name = "email")
	private String email;

	/**
	 * 'password should be encrypted' 
	 */
	@Column(name = "password")
	private String password;

	/**
	 * 'age in years@!& we don''t want to store the user''s dob' 
	 */
	@Column(name = "age")
	private Integer age;

	/**
	 * 'when did the user last log in?' 
	 */
	@Column(name = "lst_logd_in")
	private Date lstLogdIn;

	/**
	 * 'user''s phone number&!@ required for message notifications' 
	 */
	@Column(name = "phone")
	private String phone;

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
	@Column(name = "user_not_locked")
	private boolean userNotLocked;

	/**
	 * 
	 */
	@Column(name = "join_date")
	private Date joinDate;

	/**
	 * 
	 */
	@Column(name = "last_login_date_display")
	private Date lastLoginDateDisplay;

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
	 * default constructor
	 */
	public Users() {
		super();
	}

	public Users(Integer userId, String username, String email, String password, Integer age, Date lstLogdIn, String phone, boolean actv, String[] authorizations, String firstName, String lastName, boolean userNotLocked, Date joinDate, Date lastLoginDateDisplay, String profileImage, String roles, String userIdentifier) {
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
		return "Users [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", age=" + age + ", lstLogdIn=" + lstLogdIn + ", phone=" + phone + ", actv=" + actv + ", authorizations=" + authorizations + ", firstName=" + firstName + ", lastName=" + lastName + ", userNotLocked=" + userNotLocked + ", joinDate=" + joinDate + ", lastLoginDateDisplay=" + lastLoginDateDisplay + ", profileImage=" + profileImage + ", roles=" + roles + ", userIdentifier=" + userIdentifier + "]";
	}

	public static Users fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Users.class );
	}
	public UsersDTO toDTO() {
		return new UsersDTO(this.getUserId(),this.getUsername(),this.getEmail(),this.getPassword(),this.getAge(),this.getLstLogdIn(),this.getPhone(),this.getActv(),this.getAuthorizations(),this.getFirstName(),this.getLastName(),this.getUserNotLocked(),this.getJoinDate(),this.getLastLoginDateDisplay(),this.getProfileImage(),this.getRoles(),this.getUserIdentifier());
	}
}
