package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.LiftEquipDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "lift_equip")
public class LiftEquip implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "lift_equip_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer liftEquipId;

	/**
	 * "short description of the equipment" 
	 */
	@Column(name = "equip_desc")
	private String equipDesc;

	/**
	 * "long description of the equipment" 
	 */
	@Column(name = "equip_long_desc")
	private String equipLongDesc;

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
	public LiftEquip() {
		super();
	}

	public LiftEquip(Integer liftEquipId, String equipDesc, String equipLongDesc, Integer imageLoc, String actv) {
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
		return "LiftEquip [liftEquipId=" + liftEquipId + ", equipDesc=" + equipDesc + ", equipLongDesc=" + equipLongDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static LiftEquip fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LiftEquip.class );
	}
	public LiftEquipDTO toDTO() {
		return new LiftEquipDTO(this.getLiftEquipId(),this.getEquipDesc(),this.getEquipLongDesc(),this.getImageLoc(),this.getActv());
	}
}
