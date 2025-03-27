package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

import com.schnarbiesnmeowers.nmsmonolith.entities.workout.WeightWorkoutType;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class WeightWorkoutTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer weightWorkoutTypeId;

	/**
	 * "fk to the workouts.workout_id field" 
	 */
	private Integer workoutId;

	/**
	 * "fk to the muscle_group table" 
	 */
	private Integer muscleGroupId;

	/**
	 * default constructor
	 */
	public WeightWorkoutTypeDTO() {
		super();
	}

	public WeightWorkoutTypeDTO(Integer weightWorkoutTypeId, Integer workoutId, Integer muscleGroupId) {
		super();
		this.weightWorkoutTypeId = weightWorkoutTypeId;
		this.workoutId = workoutId;
		this.muscleGroupId = muscleGroupId;
	}

	public Integer getWeightWorkoutTypeId() {
		return weightWorkoutTypeId;
	}

	public void setWeightWorkoutTypeId(Integer weightWorkoutTypeId) {
		this.weightWorkoutTypeId=weightWorkoutTypeId;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId=workoutId;
	}

	public Integer getMuscleGroupId() {
		return muscleGroupId;
	}

	public void setMuscleGroupId(Integer muscleGroupId) {
		this.muscleGroupId=muscleGroupId;
	}

	@Override
	public String toString() {
		return "WeightWorkoutTypeDTO [weightWorkoutTypeId=" + weightWorkoutTypeId + ", workoutId=" + workoutId + ", muscleGroupId=" + muscleGroupId + "]";
	}

	public static WeightWorkoutTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, WeightWorkoutTypeDTO.class );
	}
	public WeightWorkoutType toEntity() {
		return new WeightWorkoutType(this.getWeightWorkoutTypeId(),this.getWorkoutId(),this.getMuscleGroupId());
	}
}
