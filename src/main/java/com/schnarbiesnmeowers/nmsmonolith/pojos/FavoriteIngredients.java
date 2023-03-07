package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.FavoriteIngredientsDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "favorite_ingredients")
public class FavoriteIngredients implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "favorite_ingredient_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer favoriteIngredientId;

	/**
	 * "fk to the ingredients.ingr_id field or the local_ingredients.ingr_id field" 
	 */
	@Column(name = "ingr_id")
	private Integer ingrId;

	/**
	 * "is the ingr_id fk a local ingr_id?" 
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
	public FavoriteIngredients() {
		super();
	}

	public FavoriteIngredients(Integer favoriteIngredientId, Integer ingrId, boolean isLocal, String actv, Integer userId) {
		super();
		this.favoriteIngredientId = favoriteIngredientId;
		this.ingrId = ingrId;
		this.isLocal = isLocal;
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
		return "FavoriteIngredients [favoriteIngredientId=" + favoriteIngredientId + ", ingrId=" + ingrId + ", isLocal=" + isLocal + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static FavoriteIngredients fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, FavoriteIngredients.class );
	}
	public FavoriteIngredientsDTO toDTO() {
		return new FavoriteIngredientsDTO(this.getFavoriteIngredientId(),this.getIngrId(),this.getIsLocal(),this.getActv(),this.getUserId());
	}
}
