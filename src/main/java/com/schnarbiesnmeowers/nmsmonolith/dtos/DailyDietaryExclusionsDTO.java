package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyDietaryExclusions;
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
public class DailyDietaryExclusionsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer dailyDietaryExclusionId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "the calendar date - date only&!@ no time") 
	 */
	private Date calendarDate;

	/**
	 * default constructor
	 */
	public DailyDietaryExclusionsDTO() {
		super();
	}

	public DailyDietaryExclusionsDTO(Integer dailyDietaryExclusionId, Integer userId, Date calendarDate) {
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
		return "DailyDietaryExclusionsDTO [dailyDietaryExclusionId=" + dailyDietaryExclusionId + ", userId=" + userId + ", calendarDate=" + calendarDate + "]";
	}

	public static DailyDietaryExclusionsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyDietaryExclusionsDTO.class );
	}
	public DailyDietaryExclusions toEntity() {
		return new DailyDietaryExclusions(this.getDailyDietaryExclusionId(),this.getUserId(),this.getCalendarDate());
	}
}
