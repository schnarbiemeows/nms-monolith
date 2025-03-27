package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.ManualFoodItems;
import jakarta.validation.constraints.*;
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
public class ManualFoodItemsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer manualFoodItemId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "fk to ingredients.ingr_id or local_ingredients.ingr_id field" 
	 */
	private Integer ingrId;

	/**
	 * "is this a recipe(y or n)?" 
	 */
	private boolean isRecipe;

	/**
	 * "is this a local recipe or ingredient?" 
	 */
	private boolean isLocal;

	/**
	 * "fk to the bldst_table.bldst_table_id field" 
	 */
	private Integer bldstId;

	/**
	 * "the number of servings of this item eaten" 
	 */
	private BigDecimal numSrv;

	/**
	 * "fk to the serving_types.serv_type_id field" 
	 */
	private Integer servTypeId;

	/**
	 * default constructor
	 */
	public ManualFoodItemsDTO() {
		super();
	}

	public ManualFoodItemsDTO(Integer manualFoodItemId, Integer userId, Integer ingrId, boolean isRecipe, boolean isLocal, Integer bldstId, BigDecimal numSrv, Integer servTypeId) {
		super();
		this.manualFoodItemId = manualFoodItemId;
		this.userId = userId;
		this.ingrId = ingrId;
		this.isRecipe = isRecipe;
		this.isLocal = isLocal;
		this.bldstId = bldstId;
		this.numSrv = numSrv;
		this.servTypeId = servTypeId;
	}

	public Integer getManualFoodItemId() {
		return manualFoodItemId;
	}

	public void setManualFoodItemId(Integer manualFoodItemId) {
		this.manualFoodItemId=manualFoodItemId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public Integer getIngrId() {
		return ingrId;
	}

	public void setIngrId(Integer ingrId) {
		this.ingrId=ingrId;
	}

	public boolean getIsRecipe() {
		return isRecipe;
	}

	public void setIsRecipe(boolean isRecipe) {
		this.isRecipe=isRecipe;
	}

	public boolean getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(boolean isLocal) {
		this.isLocal=isLocal;
	}

	public Integer getBldstId() {
		return bldstId;
	}

	public void setBldstId(Integer bldstId) {
		this.bldstId=bldstId;
	}

	public BigDecimal getNumSrv() {
		return numSrv;
	}

	public void setNumSrv(BigDecimal numSrv) {
		this.numSrv=numSrv;
	}

	public Integer getServTypeId() {
		return servTypeId;
	}

	public void setServTypeId(Integer servTypeId) {
		this.servTypeId=servTypeId;
	}

	@Override
	public String toString() {
		return "ManualFoodItemsDTO [manualFoodItemId=" + manualFoodItemId + ", userId=" + userId + ", ingrId=" + ingrId + ", isRecipe=" + isRecipe + ", isLocal=" + isLocal + ", bldstId=" + bldstId + ", numSrv=" + numSrv + ", servTypeId=" + servTypeId + "]";
	}

	public static ManualFoodItemsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ManualFoodItemsDTO.class );
	}
	public ManualFoodItems toEntity() {
		return new ManualFoodItems(this.getManualFoodItemId(),this.getUserId(),this.getIngrId(),this.getIsRecipe(),this.getIsLocal(),this.getBldstId(),this.getNumSrv(),this.getServTypeId());
	}
}
