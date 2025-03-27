package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalGroupsDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "goal_groups")
public class GoalGroups implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "goal_group_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer goalGroupId;

	/**
	 * "fk to the goals.goal_id field" 
	 */
	@Column(name = "goal_id_1")
	private Integer goalId1;

	/**
	 * "fk to the goals.goal_id field" 
	 */
	@Column(name = "goal_id_2")
	private Integer goalId2;

	/**
	 * "and or or&!@ how are these 2 goals related?") 
	 */
	@Column(name = "relation")
	private String relation;

	/**
	 * default constructor
	 */
	public GoalGroups() {
		super();
	}

	public GoalGroups(Integer goalGroupId, Integer goalId1, Integer goalId2, String relation) {
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
		return "GoalGroups [goalGroupId=" + goalGroupId + ", goalId1=" + goalId1 + ", goalId2=" + goalId2 + ", relation=" + relation + "]";
	}

	public static GoalGroups fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalGroups.class );
	}
	public GoalGroupsDTO toDTO() {
		return new GoalGroupsDTO(this.getGoalGroupId(),this.getGoalId1(),this.getGoalId2(),this.getRelation());
	}
}
