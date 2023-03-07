package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Steps;
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
public class StepsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer stepId;

	/**
	 * "fk to the workouts.workout_id field" 
	 */
	private Integer workoutId;

	/**
	 * "how many steps" 
	 */
	private Integer steps;

	/**
	 * "is this record active(y or n)?" 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public StepsDTO() {
		super();
	}

	public StepsDTO(Integer stepId, Integer workoutId, Integer steps, String actv) {
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
		return "StepsDTO [stepId=" + stepId + ", workoutId=" + workoutId + ", steps=" + steps + ", actv=" + actv + "]";
	}

	public static StepsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, StepsDTO.class );
	}
	public Steps toEntity() {
		return new Steps(this.getStepId(),this.getWorkoutId(),this.getSteps(),this.getActv());
	}
}
