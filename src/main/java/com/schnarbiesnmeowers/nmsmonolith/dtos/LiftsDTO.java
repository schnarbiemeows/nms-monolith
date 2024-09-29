package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Lifts;
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
public class LiftsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer liftId;


	/**
	 * "lift description" 
	 */
	private String liftDesc;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?" 
	 */
	private String actv;

	private Integer muscleGroupId;
	/**
	 * default constructor
	 */
	public LiftsDTO() {
		super();
	}

	public LiftsDTO(Integer liftId, String liftDesc, Integer imageLoc, String actv, Integer muscleGroupId) {
		this.liftId = liftId;
		this.liftDesc = liftDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
		this.muscleGroupId = muscleGroupId;
	}

	public Integer getLiftId() {
		return liftId;
	}

	public void setLiftId(Integer liftId) {
		this.liftId=liftId;
	}

	public String getLiftDesc() {
		return liftDesc;
	}

	public void setLiftDesc(String liftDesc) {
		this.liftDesc=liftDesc;
	}

	public Integer getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(Integer imageLoc) {
		this.imageLoc=imageLoc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	public Integer getMuscleGroupId() {
		return muscleGroupId;
	}

	public void setMuscleGroupId(Integer muscleGroupId) {
		this.muscleGroupId = muscleGroupId;
	}

	@Override
	public String toString() {
		return "LiftsDTO{" +
				"liftId=" + liftId +
				", liftDesc='" + liftDesc + '\'' +
				", imageLoc=" + imageLoc +
				", actv='" + actv + '\'' +
				", muscleGroupId=" + muscleGroupId +
				'}';
	}

	public static LiftsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LiftsDTO.class );
	}
	public Lifts toEntity() {
		return new Lifts(this.getLiftId(),this.getLiftDesc(),this.getImageLoc(),this.getActv(),
				this.muscleGroupId);
	}
}
