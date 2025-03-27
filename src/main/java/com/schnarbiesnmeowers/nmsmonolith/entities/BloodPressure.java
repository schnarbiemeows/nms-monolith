package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.BloodPressureDTO;
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
@Table(name = "blood_pressure")
public class BloodPressure implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "blood_pressure_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bloodPressureId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "the calendar date(date only&!@ no time)" 
	 */
	@Column(name = "calendar_date")
	private Date calendarDate;

	/**
	 * "systolic pressure(mm hg)" 
	 */
	@Column(name = "systolic")
	private Integer systolic;

	/**
	 * "diastolic pressure(mm hg)" 
	 */
	@Column(name = "diastolic")
	private Integer diastolic;

	/**
	 * "pulse" 
	 */
	@Column(name = "pulse")
	private Integer pulse;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public BloodPressure() {
		super();
	}

	public BloodPressure(Integer bloodPressureId, Integer userId, Date calendarDate, Integer systolic, Integer diastolic, Integer pulse, String actv) {
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
		return "BloodPressure [bloodPressureId=" + bloodPressureId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", systolic=" + systolic + ", diastolic=" + diastolic + ", pulse=" + pulse + ", actv=" + actv + "]";
	}

	public static BloodPressure fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, BloodPressure.class );
	}
	public BloodPressureDTO toDTO() {
		return new BloodPressureDTO(this.getBloodPressureId(),this.getUserId(),this.getCalendarDate(),this.getSystolic(),this.getDiastolic(),this.getPulse(),this.getActv());
	}
}
