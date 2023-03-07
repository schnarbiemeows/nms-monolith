package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LiftEquip;
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
public class LiftEquipDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer liftEquipId;

	/**
	 * "short description of the equipment" 
	 */
	private String equipDesc;

	/**
	 * "long description of the equipment" 
	 */
	private String equipLongDesc;

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
	public LiftEquipDTO() {
		super();
	}

	public LiftEquipDTO(Integer liftEquipId, String equipDesc, String equipLongDesc, Integer imageLoc, String actv) {
		super();
		this.liftEquipId = liftEquipId;
		this.equipDesc = equipDesc;
		this.equipLongDesc = equipLongDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getLiftEquipId() {
		return liftEquipId;
	}

	public void setLiftEquipId(Integer liftEquipId) {
		this.liftEquipId=liftEquipId;
	}

	public String getEquipDesc() {
		return equipDesc;
	}

	public void setEquipDesc(String equipDesc) {
		this.equipDesc=equipDesc;
	}

	public String getEquipLongDesc() {
		return equipLongDesc;
	}

	public void setEquipLongDesc(String equipLongDesc) {
		this.equipLongDesc=equipLongDesc;
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
		return "LiftEquipDTO [liftEquipId=" + liftEquipId + ", equipDesc=" + equipDesc + ", equipLongDesc=" + equipLongDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static LiftEquipDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LiftEquipDTO.class );
	}
	public LiftEquip toEntity() {
		return new LiftEquip(this.getLiftEquipId(),this.getEquipDesc(),this.getEquipLongDesc(),this.getImageLoc(),this.getActv());
	}
}
