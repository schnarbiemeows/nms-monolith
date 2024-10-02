package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype.IngredientTypesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "ingredient_types")
public class IngredientTypes implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "ingr_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ingrTypeId;

	/**
	 * "fk to the ingredient_types.ingr_type_id field of this type's parent type" 
	 */
	@Column(name = "prnt_ingr_type")
	private Integer prntIngrType;

	/**
	 * "description of the ingredient type" 
	 */
	@Column(name = "ingr_type_desc")
	private String ingrTypeDesc;

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
	public IngredientTypes() {
		super();
	}

	public IngredientTypes(Integer ingrTypeId, Integer prntIngrType, String ingrTypeDesc, Integer imageLoc, String actv) {
		super();
		this.ingrTypeId = ingrTypeId;
		this.prntIngrType = prntIngrType;
		this.ingrTypeDesc = ingrTypeDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getIngrTypeId() {
		return ingrTypeId;
	}

	public void setIngrTypeId(Integer ingrTypeId) {
		this.ingrTypeId=ingrTypeId;
	}

	public Integer getPrntIngrType() {
		return prntIngrType;
	}

	public void setPrntIngrType(Integer prntIngrType) {
		this.prntIngrType=prntIngrType;
	}

	public String getIngrTypeDesc() {
		return ingrTypeDesc;
	}

	public void setIngrTypeDesc(String ingrTypeDesc) {
		this.ingrTypeDesc=ingrTypeDesc;
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
		return "IngredientTypes [ingrTypeId=" + ingrTypeId + ", prntIngrType=" + prntIngrType + ", ingrTypeDesc=" + ingrTypeDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static IngredientTypes fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, IngredientTypes.class );
	}
	public IngredientTypesDTO toDTO() {
		return new IngredientTypesDTO(this.getIngrTypeId(),this.getPrntIngrType(),this.getIngrTypeDesc(),this.getImageLoc(),this.getActv());
	}
}
