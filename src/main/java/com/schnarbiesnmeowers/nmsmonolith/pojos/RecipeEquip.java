package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeEquipDTO;
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
@Table(name = "recipe_equip")
public class RecipeEquip implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "recipe_equip_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer recipeEquipId;

	/**
	 * "fk to the rec_eq_type.rec_eq_type_id field" 
	 */
	@Column(name = "rec_eq_type_id")
	private Integer recEqTypeId;

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
	public RecipeEquip() {
		super();
	}

	public RecipeEquip(Integer recipeEquipId, Integer recEqTypeId, String equipDesc, String equipLongDesc, Integer imageLoc, String actv) {
		super();
		this.recipeEquipId = recipeEquipId;
		this.recEqTypeId = recEqTypeId;
		this.equipDesc = equipDesc;
		this.equipLongDesc = equipLongDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getRecipeEquipId() {
		return recipeEquipId;
	}

	public void setRecipeEquipId(Integer recipeEquipId) {
		this.recipeEquipId=recipeEquipId;
	}

	public Integer getRecEqTypeId() {
		return recEqTypeId;
	}

	public void setRecEqTypeId(Integer recEqTypeId) {
		this.recEqTypeId=recEqTypeId;
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
		return "RecipeEquip [recipeEquipId=" + recipeEquipId + ", recEqTypeId=" + recEqTypeId + ", equipDesc=" + equipDesc + ", equipLongDesc=" + equipLongDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static RecipeEquip fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecipeEquip.class );
	}
	public RecipeEquipDTO toDTO() {
		return new RecipeEquipDTO(this.getRecipeEquipId(),this.getRecEqTypeId(),this.getEquipDesc(),this.getEquipLongDesc(),this.getImageLoc(),this.getActv());
	}
}
