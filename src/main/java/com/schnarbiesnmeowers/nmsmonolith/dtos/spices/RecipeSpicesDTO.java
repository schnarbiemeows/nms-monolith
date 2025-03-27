package com.schnarbiesnmeowers.nmsmonolith.dtos.spices;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeSpices;

import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class RecipeSpicesDTO implements Serializable {
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
	 * "fk to the spices.spice_id" 
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
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public RecipeSpicesDTO() {
		super();
	}

	public RecipeSpicesDTO(Integer recipeSpiceId, Integer recipeId, Integer spiceId, BigDecimal servSz, Integer servTypeId, String actv) {
		super();
		this.recipeSpiceId = recipeSpiceId;
		this.recipeId = recipeId;
		this.spiceId = spiceId;
		this.servSz = servSz;
		this.servTypeId = servTypeId;
		this.actv = actv;
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

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "RecipeSpicesDTO [recipeSpiceId=" + recipeSpiceId + ", recipeId=" + recipeId + ", spiceId=" +
				spiceId + ", servSz=" + servSz + ", servTypeId=" + servTypeId + ", actv=" + actv + "]";
	}

	public static RecipeSpicesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecipeSpicesDTO.class );
	}
	public RecipeSpices toEntity() {
		return new RecipeSpices(this.getRecipeSpiceId(),this.getRecipeId(),this.getSpiceId(),
				this.getServSz(),this.getServTypeId(),this.getActv());
	}
}
