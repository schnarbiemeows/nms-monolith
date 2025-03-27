package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.PasswordResetDTO;
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
@Table(name = "password_reset")
public class PasswordReset implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "password_reset_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer passwordResetId;

	/**
	 * 
	 */
	@Column(name = "unique_id")
	private String uniqueId;

	/**
	 * 
	 */
	@Column(name = "email_addr")
	private String emailAddr;

	/**
	 * 
	 */
	@Column(name = "created_date")
	private Date createdDate;

	/**
	 * default constructor
	 */
	public PasswordReset() {
		super();
	}

	public PasswordReset(Integer passwordResetId, String uniqueId, String emailAddr, Date createdDate) {
		super();
		this.passwordResetId = passwordResetId;
		this.uniqueId = uniqueId;
		this.emailAddr = emailAddr;
		this.createdDate = createdDate;
	}

	public Integer getPasswordResetId() {
		return passwordResetId;
	}

	public void setPasswordResetId(Integer passwordResetId) {
		this.passwordResetId=passwordResetId;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId=uniqueId;
	}

	public String getEmailAddr() {
		return emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr=emailAddr;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate=createdDate;
	}

	@Override
	public String toString() {
		return "PasswordReset [passwordResetId=" + passwordResetId + ", uniqueId=" + uniqueId + ", emailAddr=" + emailAddr + ", createdDate=" + createdDate + "]";
	}

	public static PasswordReset fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PasswordReset.class );
	}
	public PasswordResetDTO toDTO() {
		return new PasswordResetDTO(this.getPasswordResetId(),this.getUniqueId(),this.getEmailAddr(),this.getCreatedDate());
	}
}
