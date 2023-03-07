package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.ExerciseType;
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
public class ExerciseTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer exerciseTypeId;

	/**
	 * "fk to the exercise_type.exercise_type_id field of this types parent type" 
	 */
	private Integer prntExerciseType;

	/**
	 * "description of the exercise type" 
	 */
	private String exerciseTypeDesc;

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
	public ExerciseTypeDTO() {
		super();
	}

	public ExerciseTypeDTO(Integer exerciseTypeId, Integer prntExerciseType, String exerciseTypeDesc, Integer imageLoc, String actv) {
		super();
		this.exerciseTypeId = exerciseTypeId;
		this.prntExerciseType = prntExerciseType;
		this.exerciseTypeDesc = exerciseTypeDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getExerciseTypeId() {
		return exerciseTypeId;
	}

	public void setExerciseTypeId(Integer exerciseTypeId) {
		this.exerciseTypeId=exerciseTypeId;
	}

	public Integer getPrntExerciseType() {
		return prntExerciseType;
	}

	public void setPrntExerciseType(Integer prntExerciseType) {
		this.prntExerciseType=prntExerciseType;
	}

	public String getExerciseTypeDesc() {
		return exerciseTypeDesc;
	}

	public void setExerciseTypeDesc(String exerciseTypeDesc) {
		this.exerciseTypeDesc=exerciseTypeDesc;
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
		return "ExerciseTypeDTO [exerciseTypeId=" + exerciseTypeId + ", prntExerciseType=" + prntExerciseType + ", exerciseTypeDesc=" + exerciseTypeDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static ExerciseTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ExerciseTypeDTO.class );
	}
	public ExerciseType toEntity() {
		return new ExerciseType(this.getExerciseTypeId(),this.getPrntExerciseType(),this.getExerciseTypeDesc(),this.getImageLoc(),this.getActv());
	}
}
