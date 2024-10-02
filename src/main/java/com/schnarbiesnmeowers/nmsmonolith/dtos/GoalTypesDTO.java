package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GoalTypes;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class GoalTypesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer goalTypeId;

	/**
	 * "wei(weight)&!@ exr(exercise)&!@die(diet)&!@ fin(financial)" 
	 */
	private String goalTypeCde;

	/**
	 * "description of the goal_type_cde") 
	 */
	private String goalTypeDesc;

	/**
	 * default constructor
	 */
	public GoalTypesDTO() {
		super();
	}

	public GoalTypesDTO(Integer goalTypeId, String goalTypeCde, String goalTypeDesc) {
		super();
		this.goalTypeId = goalTypeId;
		this.goalTypeCde = goalTypeCde;
		this.goalTypeDesc = goalTypeDesc;
	}

	public Integer getGoalTypeId() {
		return goalTypeId;
	}

	public void setGoalTypeId(Integer goalTypeId) {
		this.goalTypeId=goalTypeId;
	}

	public String getGoalTypeCde() {
		return goalTypeCde;
	}

	public void setGoalTypeCde(String goalTypeCde) {
		this.goalTypeCde=goalTypeCde;
	}

	public String getGoalTypeDesc() {
		return goalTypeDesc;
	}

	public void setGoalTypeDesc(String goalTypeDesc) {
		this.goalTypeDesc=goalTypeDesc;
	}

	@Override
	public String toString() {
		return "GoalTypesDTO [goalTypeId=" + goalTypeId + ", goalTypeCde=" + goalTypeCde + ", goalTypeDesc=" + goalTypeDesc + "]";
	}

	public static GoalTypesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalTypesDTO.class );
	}
	public GoalTypes toEntity() {
		return new GoalTypes(this.getGoalTypeId(),this.getGoalTypeCde(),this.getGoalTypeDesc());
	}
}
