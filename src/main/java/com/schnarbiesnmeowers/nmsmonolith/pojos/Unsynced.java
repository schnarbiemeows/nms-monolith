package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.UnsyncedDTO;
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
@Table(name = "unsynced")
public class Unsynced implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "unsynced_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer unsyncedId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "the calendar date(date only&!@ no time)") 
	 */
	@Column(name = "calendar_date")
	private Date calendarDate;

	/**
	 * default constructor
	 */
	public Unsynced() {
		super();
	}

	public Unsynced(Integer unsyncedId, Integer userId, Date calendarDate) {
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
		return "Unsynced [unsyncedId=" + unsyncedId + ", userId=" + userId + ", calendarDate=" + calendarDate + "]";
	}

	public static Unsynced fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Unsynced.class );
	}
	public UnsyncedDTO toDTO() {
		return new UnsyncedDTO(this.getUnsyncedId(),this.getUserId(),this.getCalendarDate());
	}
}
