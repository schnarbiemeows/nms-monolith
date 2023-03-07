package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.StepsDTO;
import javax.persistence.*;
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
@Entity
@Table(name = "steps")
public class Steps implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "step_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer stepId;

	/**
	 * "fk to the workouts.workout_id field" 
	 */
	@Column(name = "workout_id")
	private Integer workoutId;

	/**
	 * "how many steps" 
	 */
	@Column(name = "steps")
	private Integer steps;

	/**
	 * "is this record active(y or n)?" 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public Steps() {
		super();
	}

	public Steps(Integer stepId, Integer workoutId, Integer steps, String actv) {
		super();
		this.stepId = stepId;
		this.workoutId = workoutId;
		this.steps = steps;
		this.actv = actv;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId=stepId;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId=workoutId;
	}

	public Integer getSteps() {
		return steps;
	}

	public void setSteps(Integer steps) {
		this.steps=steps;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "Steps [stepId=" + stepId + ", workoutId=" + workoutId + ", steps=" + steps + ", actv=" + actv + "]";
	}

	public static Steps fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Steps.class );
	}
	public StepsDTO toDTO() {
		return new StepsDTO(this.getStepId(),this.getWorkoutId(),this.getSteps(),this.getActv());
	}
}
