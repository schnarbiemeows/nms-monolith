package com.schnarbiesnmeowers.nmsmonolith.dtos.recipes;

import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteRecipes;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class FavoriteRecipesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer favoriteRecipeId;

	/**
	 * "fk to the recipes.recipe_id field or the local_recipes.recipe_id field" 
	 */
	private Integer recipeId;

	/**
	 * "is the recipe_id fk a local recipe_id?" 
	 */
	private boolean local;

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
	public FavoriteRecipesDTO() {
		super();
	}

	public FavoriteRecipesDTO(Integer favoriteRecipeId, Integer recipeId, boolean isLocal, String actv, Integer userId) {
		super();
		this.favoriteRecipeId = favoriteRecipeId;
		this.recipeId = recipeId;
		this.local = isLocal;
		this.actv = actv;
		this.userId = userId;
	}

	public Integer getFavoriteRecipeId() {
		return favoriteRecipeId;
	}

	public void setFavoriteRecipeId(Integer favoriteRecipeId) {
		this.favoriteRecipeId=favoriteRecipeId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId=recipeId;
	}

	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
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
		return "FavoriteRecipesDTO [favoriteRecipeId=" + favoriteRecipeId + ", recipeId=" + recipeId + ", isLocal=" + local + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static FavoriteRecipesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, FavoriteRecipesDTO.class );
	}
	public FavoriteRecipes toEntity() {
		return new FavoriteRecipes(this.getFavoriteRecipeId(),this.getRecipeId(),this.isLocal(),this.getActv(),this.getUserId());
	}
}
