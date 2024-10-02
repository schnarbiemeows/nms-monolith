package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.UserCalendarDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

import java.sql.Time;
import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "user_calendar")
public class UserCalendar implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "user_calendar_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userCalendarId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "calendar date" 
	 */
	@Column(name = "calendar_date")
	private Date calendarDate;

	/**
	 * "calendar time" 
	 */
	@Column(name = "calendar_time")
	private java.sql.Time calendarTime;

	/**
	 * "fk to the events_table.event_id field" 
	 */
	@Column(name = "event_id")
	private Integer eventId;

	/**
	 * default constructor
	 */
	public UserCalendar() {
		super();
	}

	public UserCalendar(Integer userCalendarId, Integer userId, Date calendarDate, Time calendarTime, Integer eventId) {
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
		return "UserCalendar [userCalendarId=" + userCalendarId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", calendarTime=" + calendarTime + ", eventId=" + eventId + "]";
	}

	public static UserCalendar fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UserCalendar.class );
	}
	public UserCalendarDTO toDTO() {
		return new UserCalendarDTO(this.getUserCalendarId(),this.getUserId(),this.getCalendarDate(),this.getCalendarTime(),this.getEventId());
	}
}
