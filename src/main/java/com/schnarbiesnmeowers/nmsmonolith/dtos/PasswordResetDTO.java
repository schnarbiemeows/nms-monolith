package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.PasswordReset;
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
public class PasswordResetDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer passwordResetId;

	/**
	 * 
	 */
	private String uniqueId;

	/**
	 * 
	 */
	private String emailAddr;

	/**
	 * 
	 */
	private Date createdDate;

	/**
	 * default constructor
	 */
	public PasswordResetDTO() {
		super();
	}

	public PasswordResetDTO(Integer passwordResetId, String uniqueId, String emailAddr, Date createdDate) {
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
		return "PasswordResetDTO [passwordResetId=" + passwordResetId + ", uniqueId=" + uniqueId + ", emailAddr=" + emailAddr + ", createdDate=" + createdDate + "]";
	}

	public static PasswordResetDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PasswordResetDTO.class );
	}
	public PasswordReset toEntity() {
		return new PasswordReset(this.getPasswordResetId(),this.getUniqueId(),this.getEmailAddr(),this.getCreatedDate());
	}
}
