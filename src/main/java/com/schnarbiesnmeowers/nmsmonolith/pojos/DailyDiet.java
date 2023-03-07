package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet.DailyDietDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.sql.Time;
import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "daily_diet")
public class DailyDiet implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "daily_total_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer dailyTotalId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "the caledar date(date only&!@ no time)" 
	 */
	@Column(name = "calendar_date")
	private Date calendarDate;

	/**
	 * "fk to ingredients.ingr_id field" 
	 */
	@Column(name = "ingr_id")
	private Integer ingrId;

	/**
	 * "is this a recipe(y or n)?" 
	 */
	@Column(name = "is_recipe")
	private boolean isRecipe;

	/**
	 * "is this a local recipe or ingredient?"
	 */
	@Column(name = "is_local")
	private boolean isLocal;

	/**
	 * "fk to the bldst_table.bldst_table_id field"
	 */
	@Column(name = "bldst_id")
	private Integer bldstId;

	/**
	 * "the number of servings of this item eaten"
	 */
	@Column(name = "num_srv")
	private BigDecimal numSrv;

	/**
	 * "fk to the serving_types.serv_type_id field"
	 */
	@Column(name = "serv_type_id")
	private Integer servTypeId;

	/**
	 * "at what time of the day was this item eaten")
	 */
	@Column(name = "time_eaten")
	private String timeEaten;

	/**
	 * default constructor
	 */
	public DailyDiet() {
		super();
	}

	public DailyDiet(Integer dailyTotalId, Integer userId, Date calendarDate, Integer ingrId,
					 boolean isRecipe, boolean isLocal, Integer bldstId, BigDecimal numSrv,
					 Integer servTypeId, String timeEaten) {
		super();
		this.dailyTotalId = dailyTotalId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.ingrId = ingrId;
		this.isRecipe = isRecipe;
		this.isLocal = isLocal;
		this.bldstId = bldstId;
		this.numSrv = numSrv;
		this.servTypeId = servTypeId;
		this.timeEaten = timeEaten;
	}

	public Integer getDailyTotalId() {
		return dailyTotalId;
	}

	public void setDailyTotalId(Integer dailyTotalId) {
		this.dailyTotalId=dailyTotalId;
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

	public Integer getIngrId() {
		return ingrId;
	}

	public void setIngrId(Integer ingrId) {
		this.ingrId=ingrId;
	}

	public boolean getIsRecipe() {
		return isRecipe;
	}

	public void setIsRecipe(boolean isRecipe) {
		this.isRecipe=isRecipe;
	}

	public boolean getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(boolean isLocal) {
		this.isLocal=isLocal;
	}

	public Integer getBldstId() {
		return bldstId;
	}

	public void setBldstId(Integer bldstId) {
		this.bldstId=bldstId;
	}

	public BigDecimal getNumSrv() {
		return numSrv;
	}

	public void setNumSrv(BigDecimal numSrv) {
		this.numSrv=numSrv;
	}

	public Integer getServTypeId() {
		return servTypeId;
	}

	public void setServTypeId(Integer servTypeId) {
		this.servTypeId=servTypeId;
	}

	public String getTimeEaten() {
		return timeEaten;
	}

	public void setTimeEaten(String timeEaten) {
		this.timeEaten=timeEaten;
	}

	@Override
	public String toString() {
		return "DailyDiet [dailyTotalId=" + dailyTotalId + ", userId=" + userId + ", calendarDate=" + calendarDate + ", ingrId=" + ingrId + ", isRecipe=" + isRecipe + ", isLocal=" + isLocal + ", bldstId=" + bldstId + ", numSrv=" + numSrv + ", servTypeId=" + servTypeId + ", timeEaten=" + timeEaten + "]";
	}

	public static DailyDiet fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyDiet.class );
	}
	public DailyDietDTO toDTO() {
		return new DailyDietDTO(this.getDailyTotalId(),this.getUserId(),
				this.getCalendarDate(),this.getIngrId(),this.getIsRecipe(),
				this.getIsLocal(),this.getBldstId(),this.getNumSrv(),this.getServTypeId(),this.getTimeEaten());
	}
}
