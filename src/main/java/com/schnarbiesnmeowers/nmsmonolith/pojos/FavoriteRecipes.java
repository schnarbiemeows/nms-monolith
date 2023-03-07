package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.FavoriteRecipesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "favorite_recipes")
public class FavoriteRecipes implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "favorite_recipe_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer favoriteRecipeId;

	/**
	 * "fk to the recipes.recipe_id field or the local_recipes.recipe_id field" 
	 */
	@Column(name = "recipe_id")
	private Integer recipeId;

	/**
	 * "is the recipe_id fk a local recipe_id?" 
	 */
	@Column(name = "is_local")
	private boolean isLocal;

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
	public FavoriteRecipes() {
		super();
	}

	public FavoriteRecipes(Integer favoriteRecipeId, Integer recipeId, boolean isLocal, String actv, Integer userId) {
		super();
		this.favoriteRecipeId = favoriteRecipeId;
		this.recipeId = recipeId;
		this.isLocal = isLocal;
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
		return "FavoriteRecipes [favoriteRecipeId=" + favoriteRecipeId + ", recipeId=" + recipeId + ", isLocal=" + isLocal + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static FavoriteRecipes fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, FavoriteRecipes.class );
	}
	public FavoriteRecipesDTO toDTO() {
		return new FavoriteRecipesDTO(this.getFavoriteRecipeId(),this.getRecipeId(),this.getIsLocal(),this.getActv(),this.getUserId());
	}
}
