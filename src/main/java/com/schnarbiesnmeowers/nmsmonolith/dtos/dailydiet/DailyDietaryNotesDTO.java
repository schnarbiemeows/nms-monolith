package com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet;

import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDietaryNotes;

import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class DailyDietaryNotesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer ddnId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "the caledar date(date only&!@ no time)" 
	 */
	private Date calendarDate;

	/**
	 * "daily notes about your diet") 
	 */
	private String dailyNotes;

	/**
	 * default constructor
	 */
	public DailyDietaryNotesDTO() {
		super();
	}

	public DailyDietaryNotesDTO(Integer ddnId, Integer userId, Date calendarDate, String dailyNotes) {
		super();
		this.ddnId = ddnId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.dailyNotes = dailyNotes;
	}

	public Integer getDdnId() {
		return ddnId;
	}

	public void setDdnId(Integer ddnId) {
		this.ddnId=ddnId;
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

	public String getDailyNotes() {
		return dailyNotes;
	}

	public void setDailyNotes(String dailyNotes) {
		this.dailyNotes=dailyNotes;
	}

	@Override
	public String toString() {
		return "DailyDietaryNotesDTO [ddnId=" + ddnId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", dailyNotes=" + dailyNotes + "]";
	}

	public static DailyDietaryNotesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyDietaryNotesDTO.class );
	}
	public DailyDietaryNotes toEntity() {
		return new DailyDietaryNotes(this.getDdnId(),this.getUserId(),this.getCalendarDate(),this.getDailyNotes());
	}
}
