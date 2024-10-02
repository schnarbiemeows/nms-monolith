package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Periods;

import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class PeriodsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer periodId;

	/**
	 * "fk to the period_type.period_type_id field" 
	 */
	private Integer periodTypeId;

	/**
	 * "for the o(one-time) option&!@ calendar date and time of event" 
	 */
	private Date oneTimeDate;

	/**
	 * "day of the week&!@ m&!@tu&!@w&!@th&!@f&!@sa&!@su" 
	 */
	private String dayOfWeek;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public PeriodsDTO() {
		super();
	}

	public PeriodsDTO(Integer periodId, Integer periodTypeId, Date oneTimeDate, String dayOfWeek, String actv) {
		super();
		this.periodId = periodId;
		this.periodTypeId = periodTypeId;
		this.oneTimeDate = oneTimeDate;
		this.dayOfWeek = dayOfWeek;
		this.actv = actv;
	}

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId=periodId;
	}

	public Integer getPeriodTypeId() {
		return periodTypeId;
	}

	public void setPeriodTypeId(Integer periodTypeId) {
		this.periodTypeId=periodTypeId;
	}

	public Date getOneTimeDate() {
		return oneTimeDate;
	}

	public void setOneTimeDate(Date oneTimeDate) {
		this.oneTimeDate=oneTimeDate;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek=dayOfWeek;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "PeriodsDTO [periodId=" + periodId + ", periodTypeId=" + periodTypeId + ", oneTimeDate=" + oneTimeDate + ", dayOfWeek=" + dayOfWeek + ", actv=" + actv + "]";
	}

	public static PeriodsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PeriodsDTO.class );
	}
	public Periods toEntity() {
		return new Periods(this.getPeriodId(),this.getPeriodTypeId(),this.getOneTimeDate(),this.getDayOfWeek(),this.getActv());
	}
}
