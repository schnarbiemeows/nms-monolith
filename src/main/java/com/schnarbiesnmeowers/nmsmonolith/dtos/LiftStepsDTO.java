package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LiftSteps;
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
public class LiftStepsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer liftStepId;

	/**
	 * "fk to the lifts.lift_id field" 
	 */
	private Integer liftId;

	/**
	 * "the step order" 
	 */
	private Integer stepNum;

	/**
	 * "step description" 
	 */
	private String stepDesc;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	private Integer imageLoc;

	/**
	 * default constructor
	 */
	public LiftStepsDTO() {
		super();
	}

	public LiftStepsDTO(Integer liftStepId, Integer liftId, Integer stepNum, String stepDesc, Integer imageLoc) {
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
		return "LiftStepsDTO [liftStepId=" + liftStepId + ", liftId=" + liftId + ", stepNum=" + stepNum + ", stepDesc=" + stepDesc + ", imageLoc=" + imageLoc + "]";
	}

	public static LiftStepsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LiftStepsDTO.class );
	}
	public LiftSteps toEntity() {
		return new LiftSteps(this.getLiftStepId(),this.getLiftId(),this.getStepNum(),this.getStepDesc(),this.getImageLoc());
	}
}
