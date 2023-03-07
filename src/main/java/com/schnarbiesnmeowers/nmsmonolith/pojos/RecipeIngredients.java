package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.RecipeIngredientsDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredients implements Serializable {
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
	 * "is rec_or_ing_id another recipe(y or n)?") 
	 */
	@Column(name = "recipe_flg")
	private String recipeFlg;

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

	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public RecipeIngredients() {
		super();
	}

	public RecipeIngredients(Integer recipeIngrId, Integer recipeId, Integer recOrIngrId,
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
		return "RecipeIngredients{" +
				"recipeIngrId=" + recipeIngrId +
				", recipeId=" + recipeId +
				", recOrIngrId=" + recOrIngrId +
				", recipeFlg='" + recipeFlg + '\'' +
				", servSz=" + servSz +
				", servTypeId=" + servTypeId +
				", actv='" + actv + '\'' +
				'}';
	}

	public static RecipeIngredients fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecipeIngredients.class );
	}
	public RecipeIngredientsDTO toDTO() {
		return new RecipeIngredientsDTO(this.getRecipeIngrId(),this.getRecipeId(),this.getRecOrIngrId(),
				this.getRecipeFlg(),this.getServSz(),this.getServTypeId(),this.getActv());
	}
}
