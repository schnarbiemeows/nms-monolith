package com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecipeIngredients;

import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class RecipeIngredientsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer recipeIngrId;

	/**
	 * "fk to the recipes.recipe_id field" 
	 */
	private Integer recipeId;

	/**
	 * "fk to either the ingredients.ingr_id field or the recipes.recipe_id field" 
	 */
	private Integer recOrIngrId;

	/**
	 * "is rec_or_ing_id another recipe(y or n)?") 
	 */
	private String recipeFlg;

	/**
	 * "the size of an individual serving"
	 */
	private BigDecimal servSz;

	/**
	 * "fk to the serving_types.serv_type_id field"
	 */
	private Integer servTypeId;

	private String actv;
	/**
	 * default constructor
	 */
	public RecipeIngredientsDTO() {
		super();
	}

	public RecipeIngredientsDTO(Integer recipeIngrId, Integer recipeId, Integer recOrIngrId,
								String recipeFlg, BigDecimal servSz, Integer servTypeId, String actv) {
		this.recipeIngrId = recipeIngrId;
		this.recipeId = recipeId;
		this.recOrIngrId = recOrIngrId;
		this.recipeFlg = recipeFlg;
		this.servSz = servSz;
		this.servTypeId = servTypeId;
		this.actv = actv;
	}

	public Integer getRecipeIngrId() {
		return recipeIngrId;
	}

	public void setRecipeIngrId(Integer recipeIngrId) {
		this.recipeIngrId=recipeIngrId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId=recipeId;
	}

	public Integer getRecOrIngrId() {
		return recOrIngrId;
	}

	public void setRecOrIngrId(Integer recOrIngrId) {
		this.recOrIngrId=recOrIngrId;
	}

	public String getRecipeFlg() {
		return recipeFlg;
	}

	public void setRecipeFlg(String recipeFlg) {
		this.recipeFlg=recipeFlg;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv = actv;
	}

	public BigDecimal getServSz() {
		return servSz;
	}

	public void setServSz(BigDecimal servSz) {
		this.servSz = servSz;
	}

	public Integer getServTypeId() {
		return servTypeId;
	}

	public void setServTypeId(Integer servTypeId) {
		this.servTypeId = servTypeId;
	}

	@Override
	public String toString() {
		return "RecipeIngredientsDTO{" +
				"recipeIngrId=" + recipeIngrId +
				", recipeId=" + recipeId +
				", recOrIngrId=" + recOrIngrId +
				", recipeFlg='" + recipeFlg + '\'' +
				", servSz=" + servSz +
				", servTypeId=" + servTypeId +
				", actv='" + actv + '\'' +
				'}';
	}

	public static RecipeIngredientsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecipeIngredientsDTO.class );
	}
	public RecipeIngredients toEntity() {
		return new RecipeIngredients(this.getRecipeIngrId(),this.getRecipeId(),this.getRecOrIngrId(),
				this.getRecipeFlg(),this.getServSz(),this.getServTypeId(),this.getActv());
	}
}
