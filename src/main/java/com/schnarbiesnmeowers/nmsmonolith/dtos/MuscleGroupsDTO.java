package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.MuscleGroups;
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
public class MuscleGroupsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer muscleGroupId;

	/**
	 * "description of the muscle group" 
	 */
	private String muscleGrpName;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public MuscleGroupsDTO() {
		super();
	}

	public MuscleGroupsDTO(Integer muscleGroupId, String muscleGrpName, String actv) {
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
		return "MuscleGroupsDTO [muscleGroupId=" + muscleGroupId + ", muscleGrpName=" + muscleGrpName + ", actv=" + actv + "]";
	}

	public static MuscleGroupsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, MuscleGroupsDTO.class );
	}
	public MuscleGroups toEntity() {
		return new MuscleGroups(this.getMuscleGroupId(),this.getMuscleGrpName(),this.getActv());
	}
}
