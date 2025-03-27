package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GoalCategoriesDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "goal_categories")
public class GoalCategories implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "gc_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer gcId;

	/**
	 * "fk to the goal_types.goal_type_id field" 
	 */
	@Column(name = "goal_type_id")
	private Integer goalTypeId;

	/**
	 * "description of the goal category" 
	 */
	@Column(name = "gc_desc")
	private String gcDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public GoalCategories() {
		super();
	}

	public GoalCategories(Integer gcId, Integer goalTypeId, String gcDesc, String actv) {
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
		return "GoalCategories [gcId=" + gcId + ", goalTypeId=" + goalTypeId + ", gcDesc=" + gcDesc + ", actv=" + actv + "]";
	}

	public static GoalCategories fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GoalCategories.class );
	}
	public GoalCategoriesDTO toDTO() {
		return new GoalCategoriesDTO(this.getGcId(),this.getGoalTypeId(),this.getGcDesc(),this.getActv());
	}
}
