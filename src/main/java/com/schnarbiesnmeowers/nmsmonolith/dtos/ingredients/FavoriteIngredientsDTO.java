package com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients;

import com.schnarbiesnmeowers.nmsmonolith.pojos.FavoriteIngredients;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class FavoriteIngredientsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer favoriteIngredientId;

	/**
	 * "fk to the ingredients.ingr_id field or the local_ingredients.ingr_id field" 
	 */
	private Integer ingrId;

	/**
	 * "is the ingr_id fk a local ingr_id?" 
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
	public FavoriteIngredientsDTO() {
		super();
	}

	public FavoriteIngredientsDTO(Integer favoriteIngredientId, Integer ingrId, boolean isLocal, String actv, Integer userId) {
		super();
		this.favoriteIngredientId = favoriteIngredientId;
		this.ingrId = ingrId;
		this.local = isLocal;
		this.actv = actv;
		this.userId = userId;
	}

	public Integer getFavoriteIngredientId() {
		return favoriteIngredientId;
	}

	public void setFavoriteIngredientId(Integer favoriteIngredientId) {
		this.favoriteIngredientId=favoriteIngredientId;
	}

	public Integer getIngrId() {
		return ingrId;
	}

	public void setIngrId(Integer ingrId) {
		this.ingrId=ingrId;
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
		return "FavoriteIngredientsDTO [favoriteIngredientId=" + favoriteIngredientId + ", ingrId=" + ingrId + ", isLocal=" + local + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static FavoriteIngredientsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, FavoriteIngredientsDTO.class );
	}
	public FavoriteIngredients toEntity() {
		return new FavoriteIngredients(this.getFavoriteIngredientId(),this.getIngrId(),this.isLocal(),this.getActv(),this.getUserId());
	}
}
