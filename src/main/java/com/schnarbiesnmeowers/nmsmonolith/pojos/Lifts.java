package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftsDTO;
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
@Table(name = "lifts")
public class Lifts implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "lift_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer liftId;


	/**
	 * "lift description" 
	 */
	@Column(name = "lift_desc")
	private String liftDesc;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	@Column(name = "image_loc")
	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?" 
	 */
	@Column(name = "actv")
	private String actv;

	@Column(name = "muscle_group_id")
	private Integer muscleGroupId;
	/**
	 * default constructor
	 */
	public Lifts() {
		super();
	}

	public Lifts(Integer liftId, String liftDesc, Integer imageLoc, String actv, Integer muscleGroupId) {
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
		return "Lifts{" +
				"liftId=" + liftId +
				", liftDesc='" + liftDesc + '\'' +
				", imageLoc=" + imageLoc +
				", actv='" + actv + '\'' +
				", muscleGroupId=" + muscleGroupId +
				'}';
	}

	public static Lifts fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Lifts.class );
	}
	public LiftsDTO toDTO() {
		return new LiftsDTO(this.getLiftId(),this.getLiftDesc(),
				this.getImageLoc(),this.getActv(),this.getMuscleGroupId());
	}
}
