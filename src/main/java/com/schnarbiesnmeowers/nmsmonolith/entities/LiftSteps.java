package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftStepsDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "lift_steps")
public class LiftSteps implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "lift_step_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer liftStepId;

	/**
	 * "fk to the lifts.lift_id field" 
	 */
	@Column(name = "lift_id")
	private Integer liftId;

	/**
	 * "the step order" 
	 */
	@Column(name = "step_num")
	private Integer stepNum;

	/**
	 * "step description" 
	 */
	@Column(name = "step_desc")
	private String stepDesc;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	@Column(name = "image_loc")
	private Integer imageLoc;

	/**
	 * default constructor
	 */
	public LiftSteps() {
		super();
	}

	public LiftSteps(Integer liftStepId, Integer liftId, Integer stepNum, String stepDesc, Integer imageLoc) {
		super();
		this.liftStepId = liftStepId;
		this.liftId = liftId;
		this.stepNum = stepNum;
		this.stepDesc = stepDesc;
		this.imageLoc = imageLoc;
	}

	public Integer getLiftStepId() {
		return liftStepId;
	}

	public void setLiftStepId(Integer liftStepId) {
		this.liftStepId=liftStepId;
	}

	public Integer getLiftId() {
		return liftId;
	}

	public void setLiftId(Integer liftId) {
		this.liftId=liftId;
	}

	public Integer getStepNum() {
		return stepNum;
	}

	public void setStepNum(Integer stepNum) {
		this.stepNum=stepNum;
	}

	public String getStepDesc() {
		return stepDesc;
	}

	public void setStepDesc(String stepDesc) {
		this.stepDesc=stepDesc;
	}

	public Integer getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(Integer imageLoc) {
		this.imageLoc=imageLoc;
	}

	@Override
	public String toString() {
		return "LiftSteps [liftStepId=" + liftStepId + ", liftId=" + liftId + ", stepNum=" + stepNum + ", stepDesc=" + stepDesc + ", imageLoc=" + imageLoc + "]";
	}

	public static LiftSteps fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LiftSteps.class );
	}
	public LiftStepsDTO toDTO() {
		return new LiftStepsDTO(this.getLiftStepId(),this.getLiftId(),this.getStepNum(),this.getStepDesc(),this.getImageLoc());
	}
}
