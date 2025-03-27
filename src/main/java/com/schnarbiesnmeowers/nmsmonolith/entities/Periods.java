package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodsDTO;
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
@Table(name = "periods")
public class Periods implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "period_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer periodId;

	/**
	 * "fk to the period_type.period_type_id field" 
	 */
	@Column(name = "period_type_id")
	private Integer periodTypeId;

	/**
	 * "for the o(one-time) option&!@ calendar date and time of event" 
	 */
	@Column(name = "one_time_date")
	private Date oneTimeDate;

	/**
	 * "day of the week&!@ m&!@tu&!@w&!@th&!@f&!@sa&!@su" 
	 */
	@Column(name = "day_of_week")
	private String dayOfWeek;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public Periods() {
		super();
	}

	public Periods(Integer periodId, Integer periodTypeId, Date oneTimeDate, String dayOfWeek, String actv) {
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
		return "Periods [periodId=" + periodId + ", periodTypeId=" + periodTypeId + ", oneTimeDate=" + oneTimeDate + ", dayOfWeek=" + dayOfWeek + ", actv=" + actv + "]";
	}

	public static Periods fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Periods.class );
	}
	public PeriodsDTO toDTO() {
		return new PeriodsDTO(this.getPeriodId(),this.getPeriodTypeId(),this.getOneTimeDate(),this.getDayOfWeek(),this.getActv());
	}
}
