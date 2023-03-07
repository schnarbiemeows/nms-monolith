package com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.schnarbiesnmeowers.nmsmonolith.pojos.DailyWeight;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class DailyWeightDataPoint implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer dailyWeightId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "the calendar date(date only, no time)"
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate calendarDate;

	/**
	 * "person's weight on this given day") 
	 */
	private BigDecimal weight;

	/**
	 * default constructor
	 */
	public DailyWeightDataPoint() {
		super();
	}

	public DailyWeightDataPoint(Integer dailyWeightId, Integer userId, LocalDate calendarDate, BigDecimal weight) {
		super();
		this.dailyWeightId = dailyWeightId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.weight = weight;
	}

	public Integer getDailyWeightId() {
		return dailyWeightId;
	}

	public void setDailyWeightId(Integer dailyWeightId) {
		this.dailyWeightId=dailyWeightId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public LocalDate getCalendarDate() {
		return calendarDate;
	}
	public DailyWeightDataPoint calendarDate(LocalDate calendarDate) {
		this.calendarDate = calendarDate;
		return this;
	}
	public void setCalendarDate(LocalDate calendarDate) {
		this.calendarDate=calendarDate;
	}

	public BigDecimal getWeight() {
		return weight;
	}
	public DailyWeightDataPoint weight(BigDecimal weight) {
		this.weight = weight;
		return this;
	}
	public void setWeight(BigDecimal weight) {
		this.weight=weight;
	}

	@Override
	public String toString() {
		return "DailyWeightDTO [dailyWeightId=" + dailyWeightId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", weight=" + weight + "]";
	}

	public static DailyWeightDataPoint fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyWeightDataPoint.class );
	}
	public DailyWeight toEntity() {
		return new DailyWeight(this.getDailyWeightId(),this.getUserId(),
				this.getCalendarDate()
				,this.getWeight());
	}
}
