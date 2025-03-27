package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietaryNotesDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "daily_dietary_notes")
public class DailyDietaryNotes implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "ddn_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ddnId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "the caledar date(date only&!@ no time)" 
	 */
	@Column(name = "calendar_date")
	private Date calendarDate;

	/**
	 * "daily notes about your diet") 
	 */
	@Column(name = "daily_notes")
	private String dailyNotes;

	/**
	 * default constructor
	 */
	public DailyDietaryNotes() {
		super();
	}

	public DailyDietaryNotes(Integer ddnId, Integer userId, Date calendarDate, String dailyNotes) {
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
		return "DailyDietaryNotes [ddnId=" + ddnId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", dailyNotes=" + dailyNotes + "]";
	}

	public static DailyDietaryNotes fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyDietaryNotes.class );
	}
	public DailyDietaryNotesDTO toDTO() {
		return new DailyDietaryNotesDTO(this.getDdnId(),this.getUserId(),this.getCalendarDate(),this.getDailyNotes());
	}
}
