package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.MuscleGroupsDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "muscle_groups")
public class MuscleGroups implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "muscle_group_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer muscleGroupId;

	/**
	 * "description of the muscle group" 
	 */
	@Column(name = "muscle_grp_name")
	private String muscleGrpName;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public MuscleGroups() {
		super();
	}

	public MuscleGroups(Integer muscleGroupId, String muscleGrpName, String actv) {
		super();
		this.muscleGroupId = muscleGroupId;
		this.muscleGrpName = muscleGrpName;
		this.actv = actv;
	}

	public Integer getMuscleGroupId() {
		return muscleGroupId;
	}

	public void setMuscleGroupId(Integer muscleGroupId) {
		this.muscleGroupId=muscleGroupId;
	}

	public String getMuscleGrpName() {
		return muscleGrpName;
	}

	public void setMuscleGrpName(String muscleGrpName) {
		this.muscleGrpName=muscleGrpName;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "MuscleGroups [muscleGroupId=" + muscleGroupId + ", muscleGrpName=" + muscleGrpName + ", actv=" + actv + "]";
	}

	public static MuscleGroups fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, MuscleGroups.class );
	}
	public MuscleGroupsDTO toDTO() {
		return new MuscleGroupsDTO(this.getMuscleGroupId(),this.getMuscleGrpName(),this.getActv());
	}
}
