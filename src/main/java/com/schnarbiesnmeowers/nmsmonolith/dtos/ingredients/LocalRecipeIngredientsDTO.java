package com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients;

import com.schnarbiesnmeowers.nmsmonolith.entities.LocalRecipeIngredients;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class LocalRecipeIngredientsDTO implements Serializable {
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
	 * "is rec_or_ing_id another recipe(y or n)?" 
	 */
	private String recipeFlg;

	/**
	 * "is the referenced recipe or ingredient a local recipe or ingredient?" 
	 */
	private boolean localRecpIngr;

	/**
	 * "the size of an individual serving"
	 */
	private BigDecimal servSz;

	/**
	 * "fk to the serving_types.serv_type_id field"
	 */
	private Integer servTypeId;

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
	public LocalRecipeIngredientsDTO() {
		super();
	}

	public LocalRecipeIngredientsDTO(Integer recipeIngrId, Integer recipeId, Integer recOrIngrId, String recipeFlg, boolean localRecpIngr, BigDecimal servSz, Integer servTypeId, String actv, Integer userId) {
		this.recipeIngrId = recipeIngrId;
		this.recipeId = recipeId;
		this.recOrIngrId = recOrIngrId;
		this.recipeFlg = recipeFlg;
		this.localRecpIngr = localRecpIngr;
		this.servSz = servSz;
		this.servTypeId = servTypeId;
		this.actv = actv;
		this.userId = userId;
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

	public boolean getLocalRecpIngr() {
		return localRecpIngr;
	}

	public void setLocalRecpIngr(boolean localRecpIngr) {
		this.localRecpIngr=localRecpIngr;
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

	public boolean isLocalRecpIngr() {
		return localRecpIngr;
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
		return "LocalRecipeIngredientsDTO{" +
				"recipeIngrId=" + recipeIngrId +
				", recipeId=" + recipeId +
				", recOrIngrId=" + recOrIngrId +
				", recipeFlg='" + recipeFlg + '\'' +
				", localRecpIngr=" + localRecpIngr +
				", servSz=" + servSz +
				", servTypeId=" + servTypeId +
				", actv='" + actv + '\'' +
				", userId=" + userId +
				'}';
	}

	public static LocalRecipeIngredientsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalRecipeIngredientsDTO.class );
	}
	public LocalRecipeIngredients toEntity() {
		return new LocalRecipeIngredients(this.getRecipeIngrId(),this.getRecipeId(),this.getRecOrIngrId(),this.getRecipeFlg(),
				this.getLocalRecpIngr(),this.getServSz(),this.getServTypeId(),this.getActv(),this.getUserId());
	}
}
