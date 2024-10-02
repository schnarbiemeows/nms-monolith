package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.LocalRecipeIngredientsDTO;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "local_recipe_ingredients")
public class LocalRecipeIngredients implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "recipe_ingr_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer recipeIngrId;

	/**
	 * "fk to the recipes.recipe_id field" 
	 */
	@Column(name = "recipe_id")
	private Integer recipeId;

	/**
	 * "fk to either the ingredients.ingr_id field or the recipes.recipe_id field" 
	 */
	@Column(name = "rec_or_ingr_id")
	private Integer recOrIngrId;

	/**
	 * "is rec_or_ing_id another recipe(y or n)?" 
	 */
	@Column(name = "recipe_flg")
	private String recipeFlg;

	/**
	 * "is the referenced recipe or ingredient a local recipe or ingredient?" 
	 */
	@Column(name = "local_recp_ingr")
	private boolean localRecpIngr;

	/**
	 * "the size of an individual serving"
	 */
	@Column(name = "serv_sz")
	private BigDecimal servSz;

	/**
	 * "fk to the serving_types.serv_type_id field"
	 */
	@Column(name = "serv_type_id")
	private Integer servTypeId;
	/**
	 * "is this record active(y or n)?" 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * "fk to the user.user_id field") 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * default constructor
	 */
	public LocalRecipeIngredients() {
		super();
	}

	public LocalRecipeIngredients(Integer recipeIngrId, Integer recipeId, Integer recOrIngrId, String recipeFlg,
								  boolean localRecpIngr, BigDecimal servSz, Integer servTypeId, String actv, Integer userId) {
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
		return "LocalRecipeIngredients{" +
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

	public static LocalRecipeIngredients fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalRecipeIngredients.class );
	}
	public LocalRecipeIngredientsDTO toDTO() {
		return new LocalRecipeIngredientsDTO(this.getRecipeIngrId(),this.getRecipeId(),this.getRecOrIngrId(),
				this.getRecipeFlg(),this.getLocalRecpIngr(),this.getServSz(),this.getServTypeId(),this.getActv(),this.getUserId());
	}
}
