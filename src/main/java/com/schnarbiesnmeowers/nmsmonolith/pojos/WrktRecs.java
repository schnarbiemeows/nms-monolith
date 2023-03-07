package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.WrktRecsDTO;
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
@Table(name = "wrkt_recs")
public class WrktRecs implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "wrkt_rec_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer wrktRecId;

	/**
	 * "fk to the workouts.workout_id field" 
	 */
	@Column(name = "workout_id")
	private Integer workoutId;

	/**
	 * "fk to the lifts.lift_id field" 
	 */
	@Column(name = "lift_id")
	private Integer liftId;

	/**
	 * "how much wieght was used?" 
	 */
	@Column(name = "weight")
	private BigDecimal weight;

	/**
	 * "how many reps") 
	 */
	@Column(name = "reps")
	private Integer reps;

	/**
	 * default constructor
	 */
	public WrktRecs() {
		super();
	}

	public WrktRecs(Integer wrktRecId, Integer workoutId, Integer liftId, BigDecimal weight, Integer reps) {
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
		return "WrktRecs [wrktRecId=" + wrktRecId + ", workoutId=" + workoutId + ", liftId=" + liftId + ", weight=" + weight + ", reps=" + reps + "]";
	}

	public static WrktRecs fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, WrktRecs.class );
	}
	public WrktRecsDTO toDTO() {
		return new WrktRecsDTO(this.getWrktRecId(),this.getWorkoutId(),this.getLiftId(),this.getWeight(),this.getReps());
	}
}
