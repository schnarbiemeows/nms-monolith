package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Muscles;
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
public class MusclesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer muscleId;

	/**
	 * "fk to the muscle_groups.muscle_group_id field" 
	 */
	private Integer muscleGroupId;

	/**
	 * "description of the ingredient type" 
	 */
	private String muscleName;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public MusclesDTO() {
		super();
	}

	public MusclesDTO(Integer muscleId, Integer muscleGroupId, String muscleName, Integer imageLoc, String actv) {
		super();
		this.muscleId = muscleId;
		this.muscleGroupId = muscleGroupId;
		this.muscleName = muscleName;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getMuscleId() {
		return muscleId;
	}

	public void setMuscleId(Integer muscleId) {
		this.muscleId=muscleId;
	}

	public Integer getMuscleGroupId() {
		return muscleGroupId;
	}

	public void setMuscleGroupId(Integer muscleGroupId) {
		this.muscleGroupId=muscleGroupId;
	}

	public String getMuscleName() {
		return muscleName;
	}

	public void setMuscleName(String muscleName) {
		this.muscleName=muscleName;
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

	@Override
	public String toString() {
		return "MusclesDTO [muscleId=" + muscleId + ", muscleGroupId=" + muscleGroupId + ", muscleName=" + muscleName + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static MusclesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, MusclesDTO.class );
	}
	public Muscles toEntity() {
		return new Muscles(this.getMuscleId(),this.getMuscleGroupId(),this.getMuscleName(),this.getImageLoc(),this.getActv());
	}
}
