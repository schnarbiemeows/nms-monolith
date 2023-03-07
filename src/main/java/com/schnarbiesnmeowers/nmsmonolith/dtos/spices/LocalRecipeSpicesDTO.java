package com.schnarbiesnmeowers.nmsmonolith.dtos.spices;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalRecipeSpices;

import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class LocalRecipeSpicesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer recipeSpiceId;

	/**
	 * "fk to the recipes.recipe_id field" 
	 */
	private Integer recipeId;

	/**
	 * "fk to the spices.spice_id or local_spices.spice_id field" 
	 */
	private Integer spiceId;

	/**
	 * "the size of an individual serving" 
	 */
	private BigDecimal servSz;

	/**
	 * "fk to the serving_types.serv_type_id field" 
	 */
	private Integer servTypeId;

	/**
	 * "is the referenced spice a local spice?" 
	 */
	private boolean isLocal;

	/**
	 * "is this record active(y or n)?" 
	 */
	private String actv;

	/**
	 * "fk to the user.user_id field") 
	 */
	private Integer userId;

	/**
	 * default constructor
	 */
	public LocalRecipeSpicesDTO() {
		super();
	}

	public LocalRecipeSpicesDTO(Integer recipeSpiceId, Integer recipeId, Integer spiceId, BigDecimal servSz, Integer servTypeId, boolean isLocal, String actv, Integer userId) {
		super();
		this.recipeSpiceId = recipeSpiceId;
		this.recipeId = recipeId;
		this.spiceId = spiceId;
		this.servSz = servSz;
		this.servTypeId = servTypeId;
		this.isLocal = isLocal;
		this.actv = actv;
		this.userId = userId;
	}

	public Integer getRecipeSpiceId() {
		return recipeSpiceId;
	}

	public void setRecipeSpiceId(Integer recipeSpiceId) {
		this.recipeSpiceId=recipeSpiceId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId=recipeId;
	}

	public Integer getSpiceId() {
		return spiceId;
	}

	public void setSpiceId(Integer spiceId) {
		this.spiceId=spiceId;
	}

	public BigDecimal getServSz() {
		return servSz;
	}

	public void setServSz(BigDecimal servSz) {
		this.servSz=servSz;
	}

	public Integer getServTypeId() {
		return servTypeId;
	}

	public void setServTypeId(Integer servTypeId) {
		this.servTypeId=servTypeId;
	}

	public boolean getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(boolean isLocal) {
		this.isLocal=isLocal;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	@Override
	public String toString() {
		return "LocalRecipeSpicesDTO [recipeSpiceId=" + recipeSpiceId + ", recipeId=" + recipeId + ", spiceId=" + spiceId + ", servSz=" + servSz + ", servTypeId=" + servTypeId + ", isLocal=" + isLocal + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static LocalRecipeSpicesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalRecipeSpicesDTO.class );
	}
	public LocalRecipeSpices toEntity() {
		return new LocalRecipeSpices(this.getRecipeSpiceId(),this.getRecipeId(),this.getSpiceId(),this.getServSz(),this.getServTypeId(),this.getIsLocal(),this.getActv(),this.getUserId());
	}
}
