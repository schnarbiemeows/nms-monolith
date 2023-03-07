package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.GoalCategories;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class GoalCategoriesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer gcId;

	/**
	 * "fk to the goal_types.goal_type_id field" 
	 */
	private Integer goalTypeId;

	/**
	 * "description of the goal category" 
	 */
	private String gcDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public GoalCategoriesDTO() {
		super();
	}

	public GoalCategoriesDTO(Integer gcId, Integer goalTypeId, String gcDesc, String actv) {
		super();
		this.gcId = gcId;
		this.goalTypeId = goalTypeId;
		this.gcDesc = gcDesc;
		this.actv = actv;
	}

	public Integer getGcId() {
		return gcId;
	}

	public void setGcId(Integer gcId) {
		this.gcId=gcId;
	}

	public Integer getGoalTypeId() {
		return goalTypeId;
	}

	public void setGoalTypeId(Integer goalTypeId) {
		this.goalTypeId=goalTypeId;
	}

	public String getGcDesc() {
		return gcDesc;
	}

	public void setGcDesc(String gcDesc) {
		this.gcDesc=gcDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "GoalCategoriesDTO [gcId=" + gcId + ", goalTypeId=" + goalTypeId + ", gcDesc=" + gcDesc + ", actv=" + actv + "]";
	}

	public static GoalCategoriesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalCategoriesDTO.class );
	}
	public GoalCategories toEntity() {
		return new GoalCategories(this.getGcId(),this.getGoalTypeId(),this.getGcDesc(),this.getActv());
	}
}
