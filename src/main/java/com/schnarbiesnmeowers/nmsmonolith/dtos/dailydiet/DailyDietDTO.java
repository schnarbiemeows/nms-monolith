package com.schnarbiesnmeowers.nmsmonolith.dtos.dailydiet;

import com.schnarbiesnmeowers.nmsmonolith.entities.DailyDiet;

import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class DailyDietDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer dailyTotalId;	// WTF is this PK named this????

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "the caledar date(date only&!@ no time)" 
	 */
	private Date calendarDate;

	/**
	 * "fk to ingredients.ingr_id field" 
	 */
	private Integer ingrId;

	/**
	 * "is this a recipe(y or n)?" 
	 */
	private boolean recipe;

	/**
	 * "is this a local recipe or ingredient?"
	 */
	private boolean local;

	/**
	 * "fk to the bldst_table.bldst_table_id field"
	 */
	private Integer bldstId;

	/**
	 * "the number of servings of this item eaten"
	 */
	private BigDecimal numSrv;

	/**
	 * "fk to the serving_types.serv_type_id field"
	 */
	private Integer servTypeId;

	/**
	 * "at what time of the day was this item eaten")
	 */
	private String timeEaten;

	/**
	 * default constructor
	 */
	public DailyDietDTO() {
		super();
	}

	public DailyDietDTO(Integer dailyTotalId, Integer userId, Date calendarDate, Integer ingrId,
		boolean recipe, boolean local, Integer bldstId, BigDecimal numSrv, Integer servTypeId, String timeEaten) {
		super();
		this.dailyTotalId = dailyTotalId;
		this.userId = userId;
		this.calendarDate = calendarDate;
		this.ingrId = ingrId;
		this.recipe = recipe;
		this.local = local;
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
		return recipe;
	}

	public void setIsRecipe(boolean isRecipe) {
		this.recipe =isRecipe;
	}

	public boolean getIsLocal() {
		return local;
	}

	public void setIsLocal(boolean isLocal) {
		this.local =isLocal;
	}

	public boolean isRecipe() {
		return recipe;
	}

	public void setRecipe(boolean recipe) {
		this.recipe = recipe;
	}

	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
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
		return "DailyDietDTO [dailyTotalId=" + dailyTotalId + ", userId=" + userId + ", calendarDate=" +
				calendarDate + ", ingrId=" + ingrId + ", isRecipe=" + recipe + ", isLocal=" + local +
				", bldstId=" + bldstId + ", numSrv=" + numSrv + ", servTypeId=" + servTypeId +
				", timeEaten=" + timeEaten + "]";
	}

	public static DailyDietDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, DailyDietDTO.class );
	}
	public DailyDiet toEntity() {
		return new DailyDiet(this.getDailyTotalId(),this.getUserId(),this.getCalendarDate(),
				this.getIngrId(),this.getIsRecipe(),this.getIsLocal(),this.getBldstId(),
				this.getNumSrv(),this.getServTypeId(),this.getTimeEaten());
	}
}
