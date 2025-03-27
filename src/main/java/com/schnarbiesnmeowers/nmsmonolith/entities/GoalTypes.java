package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalTypesDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "goal_types")
public class GoalTypes implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "goal_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer goalTypeId;

	/**
	 * "wei(weight)&!@ exr(exercise)&!@die(diet)&!@ fin(financial)" 
	 */
	@Column(name = "goal_type_cde")
	private String goalTypeCde;

	/**
	 * "description of the goal_type_cde") 
	 */
	@Column(name = "goal_type_desc")
	private String goalTypeDesc;

	/**
	 * default constructor
	 */
	public GoalTypes() {
		super();
	}

	public GoalTypes(Integer goalTypeId, String goalTypeCde, String goalTypeDesc) {
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
		return "GoalTypes [goalTypeId=" + goalTypeId + ", goalTypeCde=" + goalTypeCde + ", goalTypeDesc=" + goalTypeDesc + "]";
	}

	public static GoalTypes fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalTypes.class );
	}
	public GoalTypesDTO toDTO() {
		return new GoalTypesDTO(this.getGoalTypeId(),this.getGoalTypeCde(),this.getGoalTypeDesc());
	}
}
