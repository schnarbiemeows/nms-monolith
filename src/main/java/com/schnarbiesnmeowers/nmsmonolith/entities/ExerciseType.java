package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ExerciseTypeDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "exercise_type")
public class ExerciseType implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "exercise_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer exerciseTypeId;

	/**
	 * "fk to the exercise_type.exercise_type_id field of this types parent type" 
	 */
	@Column(name = "prnt_exercise_type")
	private Integer prntExerciseType;

	/**
	 * "description of the exercise type" 
	 */
	@Column(name = "exercise_type_desc")
	private String exerciseTypeDesc;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	@Column(name = "image_loc")
	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public ExerciseType() {
		super();
	}

	public ExerciseType(Integer exerciseTypeId, Integer prntExerciseType, String exerciseTypeDesc, Integer imageLoc, String actv) {
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
		return "ExerciseType [exerciseTypeId=" + exerciseTypeId + ", prntExerciseType=" + prntExerciseType + ", exerciseTypeDesc=" + exerciseTypeDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static ExerciseType fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ExerciseType.class );
	}
	public ExerciseTypeDTO toDTO() {
		return new ExerciseTypeDTO(this.getExerciseTypeId(),this.getPrntExerciseType(),this.getExerciseTypeDesc(),this.getImageLoc(),this.getActv());
	}
}
