package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Unsynced;
import javax.validation.constraints.*;
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
public class UnsyncedDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer unsyncedId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "the calendar date(date only&!@ no time)") 
	 */
	private Date calendarDate;

	/**
	 * default constructor
	 */
	public UnsyncedDTO() {
		super();
	}

	public UnsyncedDTO(Integer unsyncedId, Integer userId, Date calendarDate) {
		super();
		this.unsyncedId = unsyncedId;
		this.userId = userId;
		this.calendarDate = calendarDate;
	}

	public Integer getUnsyncedId() {
		return unsyncedId;
	}

	public void setUnsyncedId(Integer unsyncedId) {
		this.unsyncedId=unsyncedId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Date getCalendarDate() {
		return calendarDate;
	}

	public void setCalendarDate(Date calendarDate) {
		this.calendarDate=calendarDate;
	}

	@Override
	public String toString() {
		return "UnsyncedDTO [unsyncedId=" + unsyncedId + ", userId=" + userId + ", calendarDate=" + calendarDate + "]";
	}

	public static UnsyncedDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UnsyncedDTO.class );
	}
	public Unsynced toEntity() {
		return new Unsynced(this.getUnsyncedId(),this.getUserId(),this.getCalendarDate());
	}
}
