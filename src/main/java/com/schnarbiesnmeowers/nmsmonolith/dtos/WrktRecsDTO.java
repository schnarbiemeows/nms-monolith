package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.WrktRecs;
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
public class WrktRecsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer wrktRecId;

	/**
	 * "fk to the workouts.workout_id field" 
	 */
	private Integer workoutId;

	/**
	 * "fk to the lifts.lift_id field" 
	 */
	private Integer liftId;

	/**
	 * "how much wieght was used?" 
	 */
	private BigDecimal weight;

	/**
	 * "how many reps") 
	 */
	private Integer reps;

	/**
	 * default constructor
	 */
	public WrktRecsDTO() {
		super();
	}

	public WrktRecsDTO(Integer wrktRecId, Integer workoutId, Integer liftId, BigDecimal weight, Integer reps) {
		super();
		this.wrktRecId = wrktRecId;
		this.workoutId = workoutId;
		this.liftId = liftId;
		this.weight = weight;
		this.reps = reps;
	}

	public Integer getWrktRecId() {
		return wrktRecId;
	}

	public void setWrktRecId(Integer wrktRecId) {
		this.wrktRecId=wrktRecId;
	}

	public Integer getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Integer workoutId) {
		this.workoutId=workoutId;
	}

	public Integer getLiftId() {
		return liftId;
	}

	public void setLiftId(Integer liftId) {
		this.liftId=liftId;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight=weight;
	}

	public Integer getReps() {
		return reps;
	}

	public void setReps(Integer reps) {
		this.reps=reps;
	}

	@Override
	public String toString() {
		return "WrktRecsDTO [wrktRecId=" + wrktRecId + ", workoutId=" + workoutId + ", liftId=" + liftId + ", weight=" + weight + ", reps=" + reps + "]";
	}

	public static WrktRecsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, WrktRecsDTO.class );
	}
	public WrktRecs toEntity() {
		return new WrktRecs(this.getWrktRecId(),this.getWorkoutId(),this.getLiftId(),this.getWeight(),this.getReps());
	}
}
