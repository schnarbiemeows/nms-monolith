package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.PeriodExt;
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
public class PeriodExtDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer periodExtId;

	/**
	 * "fk to the periods.period_id field" 
	 */
	private Integer periodId;

	/**
	 * "specific date" 
	 */
	private Date specificDate;

	/**
	 * "sepcific time") 
	 */
	private java.sql.Time specificTime;

	/**
	 * default constructor
	 */
	public PeriodExtDTO() {
		super();
	}

	public PeriodExtDTO(Integer periodExtId, Integer periodId, Date specificDate, Time specificTime) {
		super();
		this.periodExtId = periodExtId;
		this.periodId = periodId;
		this.specificDate = specificDate;
		this.specificTime = specificTime;
	}

	public Integer getPeriodExtId() {
		return periodExtId;
	}

	public void setPeriodExtId(Integer periodExtId) {
		this.periodExtId=periodExtId;
	}

	public Integer getPeriodId() {
		return periodId;
	}

	public void setPeriodId(Integer periodId) {
		this.periodId=periodId;
	}

	public Date getSpecificDate() {
		return specificDate;
	}

	public void setSpecificDate(Date specificDate) {
		this.specificDate=specificDate;
	}

	public Time getSpecificTime() {
		return specificTime;
	}

	public void setSpecificTime(Time specificTime) {
		this.specificTime=specificTime;
	}

	@Override
	public String toString() {
		return "PeriodExtDTO [periodExtId=" + periodExtId + ", periodId=" + periodId + ", specificDate=" + specificDate + ", specificTime=" + specificTime + "]";
	}

	public static PeriodExtDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PeriodExtDTO.class );
	}
	public PeriodExt toEntity() {
		return new PeriodExt(this.getPeriodExtId(),this.getPeriodId(),this.getSpecificDate(),this.getSpecificTime());
	}
}
