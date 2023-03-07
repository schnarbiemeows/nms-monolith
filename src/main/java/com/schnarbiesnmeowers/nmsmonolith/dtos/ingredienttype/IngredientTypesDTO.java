package com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype;

import com.schnarbiesnmeowers.nmsmonolith.pojos.IngredientTypes;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class IngredientTypesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer ingrTypeId;

	/**
	 * "fk to the ingredient_types.ingr_type_id field of this type's parent type" 
	 */
	private Integer prntIngrType;

	/**
	 * "description of the ingredient type" 
	 */
	private String ingrTypeDesc;

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
	public IngredientTypesDTO() {
		super();
	}

	public IngredientTypesDTO(Integer ingrTypeId, Integer prntIngrType, String ingrTypeDesc, Integer imageLoc, String actv) {
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
		return "IngredientTypesDTO [ingrTypeId=" + ingrTypeId + ", prntIngrType=" + prntIngrType + ", ingrTypeDesc=" + ingrTypeDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static IngredientTypesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, IngredientTypesDTO.class );
	}
	public IngredientTypes toEntity() {
		return new IngredientTypes(this.getIngrTypeId(),this.getPrntIngrType(),this.getIngrTypeDesc(),this.getImageLoc(),this.getActv());
	}
}
