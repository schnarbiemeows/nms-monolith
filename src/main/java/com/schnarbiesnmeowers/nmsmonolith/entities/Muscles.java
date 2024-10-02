package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.MusclesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "muscles")
public class Muscles implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "muscle_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer muscleId;

	/**
	 * "fk to the muscle_groups.muscle_group_id field" 
	 */
	@Column(name = "muscle_group_id")
	private Integer muscleGroupId;

	/**
	 * "description of the ingredient type" 
	 */
	@Column(name = "muscle_name")
	private String muscleName;

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
	public Muscles() {
		super();
	}

	public Muscles(Integer muscleId, Integer muscleGroupId, String muscleName, Integer imageLoc, String actv) {
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
		return "Muscles [muscleId=" + muscleId + ", muscleGroupId=" + muscleGroupId + ", muscleName=" + muscleName + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static Muscles fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Muscles.class );
	}
	public MusclesDTO toDTO() {
		return new MusclesDTO(this.getMuscleId(),this.getMuscleGroupId(),this.getMuscleName(),this.getImageLoc(),this.getActv());
	}
}
