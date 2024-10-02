package com.schnarbiesnmeowers.nmsmonolith.dtos.recipes;

import com.schnarbiesnmeowers.nmsmonolith.entities.LocalRecipes;

import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class LocalRecipesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer recipeId;

	/**
	 * "name of the recipe" 
	 */
	private String recipeName;

	/**
	 * "fk to the recipe_type.recipe_type_id field" 
	 */
	private Integer recipeTypeId;

	/**
	 * "fk to the ingredients.ingr_id field of this recipe's listing" 
	 */
	private Integer ingrId;

	/**
	 * "description of the recipe" 
	 */
	private String recipeDesc;

	/**
	 * "hyperlink to the recipe" 
	 */
	private String recipeLink;

	/**
	 * "number of servings this recipe makes" 
	 */
	private BigDecimal numSrv;

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
	public LocalRecipesDTO() {
		super();
	}

	public LocalRecipesDTO(Integer recipeId, String recipeName, Integer recipeTypeId, Integer ingrId, String recipeDesc, String recipeLink, BigDecimal numSrv, String actv, Integer userId) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.recipeTypeId = recipeTypeId;
		this.ingrId = ingrId;
		this.recipeDesc = recipeDesc;
		this.recipeLink = recipeLink;
		this.numSrv = numSrv;
		this.actv = actv;
		this.userId = userId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId=recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName=recipeName;
	}

	public Integer getRecipeTypeId() {
		return recipeTypeId;
	}

	public void setRecipeTypeId(Integer recipeTypeId) {
		this.recipeTypeId=recipeTypeId;
	}

	public Integer getIngrId() {
		return ingrId;
	}

	public void setIngrId(Integer ingrId) {
		this.ingrId=ingrId;
	}

	public String getRecipeDesc() {
		return recipeDesc;
	}

	public void setRecipeDesc(String recipeDesc) {
		this.recipeDesc=recipeDesc;
	}

	public String getRecipeLink() {
		return recipeLink;
	}

	public void setRecipeLink(String recipeLink) {
		this.recipeLink=recipeLink;
	}

	public BigDecimal getNumSrv() {
		return numSrv;
	}

	public void setNumSrv(BigDecimal numSrv) {
		this.numSrv=numSrv;
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
		return "LocalRecipesDTO [recipeId=" + recipeId + ", recipeName=" + recipeName + ", recipeTypeId=" + recipeTypeId + ", ingrId=" + ingrId + ", recipeDesc=" + recipeDesc + ", recipeLink=" + recipeLink + ", numSrv=" + numSrv + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static LocalRecipesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalRecipesDTO.class );
	}
	public RecipeRecordDisplay toDisplayObject() {
		return new RecipeRecordDisplay(this.recipeId,this.recipeName,this.recipeTypeId,true);
	}

	public LocalRecipes toEntity() {
		return new LocalRecipes(this.getRecipeId(),this.getRecipeName(),this.getRecipeTypeId(),this.getIngrId(),this.getRecipeDesc(),this.getRecipeLink(),this.getNumSrv(),this.getActv(),this.getUserId());
	}

	public RecipesDTO toGlobalDTO() {
		return new RecipesDTO(this.recipeId,
				this.recipeName,
				this.recipeTypeId,
				this.ingrId, this.recipeDesc,
				this.recipeLink, this.numSrv, this.actv);
	}
}
