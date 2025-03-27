package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailyweight.DailyWeightDataPoint;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.time.LocalDate;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "daily_weight")
public class DailyWeight implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "daily_weight_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer dailyWeightId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "the caledar date(date only&!@ no time)" 
	 */
	@Column(name = "calendar_date")
	private LocalDate calendarDate;

	/**
	 * "person's weight on this given day") 
	 */
	@Column(name = "weight")
	private BigDecimal weight;

	/**
	 * default constructor
	 */
	public DailyWeight() {
		super();
	}

	public DailyWeight(Integer dailyWeightId, Integer userId, LocalDate calendarDate, BigDecimal weight) {
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

	public void setCalendarDate(LocalDate calendarDate) {
		this.calendarDate=calendarDate;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight=weight;
	}

	@Override
	public String toString() {
		return "DailyWeight [dailyWeightId=" + dailyWeightId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", weight=" + weight + "]";
	}

	public static DailyWeight fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyWeight.class );
	}
	public DailyWeightDataPoint toDTO() {
		return new DailyWeightDataPoint(this.getDailyWeightId(),this.getUserId(),
				this.getCalendarDate(),this.getWeight());
	}
}
