package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodExtDTO;
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
@Table(name = "period_ext")
public class PeriodExt implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "period_ext_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer periodExtId;

	/**
	 * "fk to the periods.period_id field" 
	 */
	@Column(name = "period_id")
	private Integer periodId;

	/**
	 * "specific date" 
	 */
	@Column(name = "specific_date")
	private Date specificDate;

	/**
	 * "sepcific time") 
	 */
	@Column(name = "specific_time")
	private java.sql.Time specificTime;

	/**
	 * default constructor
	 */
	public PeriodExt() {
		super();
	}

	public PeriodExt(Integer periodExtId, Integer periodId, Date specificDate, Time specificTime) {
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
		return "PeriodExt [periodExtId=" + periodExtId + ", periodId=" + periodId + ", specificDate=" + specificDate + ", specificTime=" + specificTime + "]";
	}

	public static PeriodExt fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PeriodExt.class );
	}
	public PeriodExtDTO toDTO() {
		return new PeriodExtDTO(this.getPeriodExtId(),this.getPeriodId(),this.getSpecificDate(),this.getSpecificTime());
	}
}
