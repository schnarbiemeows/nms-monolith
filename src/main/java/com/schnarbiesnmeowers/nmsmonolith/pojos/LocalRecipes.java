package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipes.LocalRecipesDTO;
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
@Table(name = "local_recipes")
public class LocalRecipes implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "recipe_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer recipeId;

	/**
	 * "name of the recipe" 
	 */
	@Column(name = "recipe_name")
	private String recipeName;

	/**
	 * "fk to the recipe_type.recipe_type_id field" 
	 */
	@Column(name = "recipe_type_id")
	private Integer recipeTypeId;

	/**
	 * "fk to the ingredients.ingr_id field of this recipe's listing" 
	 */
	@Column(name = "ingr_id")
	private Integer ingrId;

	/**
	 * "description of the recipe" 
	 */
	@Column(name = "recipe_desc")
	private String recipeDesc;

	/**
	 * "hyperlink to the recipe" 
	 */
	@Column(name = "recipe_link")
	private String recipeLink;

	/**
	 * "number of servings this recipe makes" 
	 */
	@Column(name = "num_srv")
	private BigDecimal numSrv;

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
	public LocalRecipes() {
		super();
	}

	public LocalRecipes(Integer recipeId, String recipeName, Integer recipeTypeId, Integer ingrId, String recipeDesc,
						String recipeLink, BigDecimal numSrv, String actv, Integer userId) {
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
		return "LocalRecipes [recipeId=" + recipeId + ", recipeName=" + recipeName + ", recipeTypeId=" + recipeTypeId + ", ingrId=" + ingrId + ", recipeDesc=" + recipeDesc + ", recipeLink=" + recipeLink + ", numSrv=" + numSrv + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static LocalRecipes fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalRecipes.class );
	}
	public LocalRecipesDTO toDTO() {
		return new LocalRecipesDTO(this.getRecipeId(),this.getRecipeName(),this.getRecipeTypeId(),this.getIngrId(),this.getRecipeDesc(),this.getRecipeLink(),this.getNumSrv(),this.getActv(),this.getUserId());
	}
}
