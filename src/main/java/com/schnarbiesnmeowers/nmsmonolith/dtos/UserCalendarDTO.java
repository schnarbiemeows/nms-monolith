package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.UserCalendar;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.sql.Time;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class UserCalendarDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer userCalendarId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "calendar date" 
	 */
	private Date calendarDate;

	/**
	 * "calendar time" 
	 */
	private java.sql.Time calendarTime;

	/**
	 * "fk to the events_table.event_id field" 
	 */
	private Integer eventId;

	/**
	 * default constructor
	 */
	public UserCalendarDTO() {
		super();
	}

	public UserCalendarDTO(Integer userCalendarId, Integer userId, Date calendarDate, Time calendarTime, Integer eventId) {
		super();
		this.userCalendarId = userCalendarId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.calendarTime = calendarTime;
		this.eventId = eventId;
	}

	public Integer getUserCalendarId() {
		return userCalendarId;
	}

	public void setUserCalendarId(Integer userCalendarId) {
		this.userCalendarId=userCalendarId;
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

	public Time getCalendarTime() {
		return calendarTime;
	}

	public void setCalendarTime(Time calendarTime) {
		this.calendarTime=calendarTime;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId=eventId;
	}

	@Override
	public String toString() {
		return "UserCalendarDTO [userCalendarId=" + userCalendarId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", calendarTime=" + calendarTime + ", eventId=" + eventId + "]";
	}

	public static UserCalendarDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UserCalendarDTO.class );
	}
	public UserCalendar toEntity() {
		return new UserCalendar(this.getUserCalendarId(),this.getUserId(),this.getCalendarDate(),this.getCalendarTime(),this.getEventId());
	}
}
