package com.schnarbiesnmeowers.nmsmonolith.dtos.workout;

import com.schnarbiesnmeowers.nmsmonolith.pojos.workout.WorkoutLift;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class WorkoutLiftDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer workoutLiftId;

	/**
	 * "fk to the workouts.workout_id field" 
	 */
	private Integer workoutId;

	/**
	 * "fk to the lifts.lift_id field" 
	 */
	private Integer liftId;

	private List<LiftSetDTO> liftSetDTO = new ArrayList<>();
	/**
	 * default constructor
	 */
	public WorkoutLiftDTO() {
		super();
	}

	public WorkoutLiftDTO(Integer workoutLiftId, Integer workoutId, Integer liftId, List<LiftSetDTO> liftSetDTO) {
		this.workoutLiftId = workoutLiftId;
		this.workoutId = workoutId;
		this.liftId = liftId;
		this.liftSetDTO = liftSetDTO;
	}

	public Integer getWorkoutLiftId() {
		return workoutLiftId;
	}

	public void setWorkoutLiftId(Integer workoutLiftId) {
		this.workoutLiftId = workoutLiftId;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId = workoutId;
	}

	public Integer getLiftId() {
		return liftId;
	}

	public void setLiftId(Integer liftId) {
		this.liftId = liftId;
	}

	public List<LiftSetDTO> getLiftSetDTO() {
		return liftSetDTO;
	}

	public void setLiftSetDTO(List<LiftSetDTO> liftSetDTO) {
		this.liftSetDTO = liftSetDTO;
	}

	@Override
	public String toString() {
		return "WorkoutLiftDTO{" +
				"WorkoutLiftId=" + workoutLiftId +
				", workoutId=" + workoutId +
				", liftId=" + liftId +
				", liftSetDTOS=" + liftSetDTO +
				'}';
	}

	public static WorkoutLiftDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, WorkoutLiftDTO.class );
	}
	public WorkoutLift toEntity() {
		return new WorkoutLift(this.getWorkoutLiftId(),this.getWorkoutId(),this.getLiftId());
	}
}
