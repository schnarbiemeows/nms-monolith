package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.GoalGroups;
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
public class GoalGroupsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer goalGroupId;

	/**
	 * "fk to the goals.goal_id field" 
	 */
	private Integer goalId1;

	/**
	 * "fk to the goals.goal_id field" 
	 */
	private Integer goalId2;

	/**
	 * "and or or&!@ how are these 2 goals related?") 
	 */
	private String relation;

	/**
	 * default constructor
	 */
	public GoalGroupsDTO() {
		super();
	}

	public GoalGroupsDTO(Integer goalGroupId, Integer goalId1, Integer goalId2, String relation) {
		super();
		this.goalGroupId = goalGroupId;
		this.goalId1 = goalId1;
		this.goalId2 = goalId2;
		this.relation = relation;
	}

	public Integer getGoalGroupId() {
		return goalGroupId;
	}

	public void setGoalGroupId(Integer goalGroupId) {
		this.goalGroupId=goalGroupId;
	}

	public Integer getGoalId1() {
		return goalId1;
	}

	public void setGoalId1(Integer goalId1) {
		this.goalId1=goalId1;
	}

	public Integer getGoalId2() {
		return goalId2;
	}

	public void setGoalId2(Integer goalId2) {
		this.goalId2=goalId2;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation=relation;
	}

	@Override
	public String toString() {
		return "GoalGroupsDTO [goalGroupId=" + goalGroupId + ", goalId1=" + goalId1 + ", goalId2=" + goalId2 + ", relation=" + relation + "]";
	}

	public static GoalGroupsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalGroupsDTO.class );
	}
	public GoalGroups toEntity() {
		return new GoalGroups(this.getGoalGroupId(),this.getGoalId1(),this.getGoalId2(),this.getRelation());
	}
}
