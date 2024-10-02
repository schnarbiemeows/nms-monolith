package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.BloodPressure;

import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class BloodPressureDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer bloodPressureId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "the calendar date(date only&!@ no time)" 
	 */
	private Date calendarDate;

	/**
	 * "systolic pressure(mm hg)" 
	 */
	private Integer systolic;

	/**
	 * "diastolic pressure(mm hg)" 
	 */
	private Integer diastolic;

	/**
	 * "pulse" 
	 */
	private Integer pulse;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public BloodPressureDTO() {
		super();
	}

	public BloodPressureDTO(Integer bloodPressureId, Integer userId, Date calendarDate, Integer systolic, Integer diastolic, Integer pulse, String actv) {
		super();
		this.bloodPressureId = bloodPressureId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.pulse = pulse;
		this.actv = actv;
	}

	public Integer getBloodPressureId() {
		return bloodPressureId;
	}

	public void setBloodPressureId(Integer bloodPressureId) {
		this.bloodPressureId=bloodPressureId;
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

	public Integer getSystolic() {
		return systolic;
	}

	public void setSystolic(Integer systolic) {
		this.systolic=systolic;
	}

	public Integer getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(Integer diastolic) {
		this.diastolic=diastolic;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse=pulse;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "BloodPressureDTO [bloodPressureId=" + bloodPressureId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", systolic=" + systolic + ", diastolic=" + diastolic + ", pulse=" + pulse + ", actv=" + actv + "]";
	}

	public static BloodPressureDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, BloodPressureDTO.class );
	}
	public BloodPressure toEntity() {
		return new BloodPressure(this.getBloodPressureId(),this.getUserId(),this.getCalendarDate(),this.getSystolic(),this.getDiastolic(),this.getPulse(),this.getActv());
	}
}
