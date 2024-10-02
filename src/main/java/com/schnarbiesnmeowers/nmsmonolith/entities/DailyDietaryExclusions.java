package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.DailyDietaryExclusionsDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "daily_dietary_exclusions")
public class DailyDietaryExclusions implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "daily_dietary_exclusion_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dailyDietaryExclusionId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "the calendar date - date only&!@ no time") 
	 */
	@Column(name = "calendar_date")
	private Date calendarDate;

	/**
	 * default constructor
	 */
	public DailyDietaryExclusions() {
		super();
	}

	public DailyDietaryExclusions(Integer dailyDietaryExclusionId, Integer userId, Date calendarDate) {
		super();
		this.dailyDietaryExclusionId = dailyDietaryExclusionId;
		this.userId = userId;
		this.calendarDate = calendarDate;
	}

	public Integer getDailyDietaryExclusionId() {
		return dailyDietaryExclusionId;
	}

	public void setDailyDietaryExclusionId(Integer dailyDietaryExclusionId) {
		this.dailyDietaryExclusionId=dailyDietaryExclusionId;
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
		return "DailyDietaryExclusions [dailyDietaryExclusionId=" + dailyDietaryExclusionId + ", userId=" + userId + ", calendarDate=" + calendarDate + "]";
	}

	public static DailyDietaryExclusions fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyDietaryExclusions.class );
	}
	public DailyDietaryExclusionsDTO toDTO() {
		return new DailyDietaryExclusionsDTO(this.getDailyDietaryExclusionId(),this.getUserId(),this.getCalendarDate());
	}
}
