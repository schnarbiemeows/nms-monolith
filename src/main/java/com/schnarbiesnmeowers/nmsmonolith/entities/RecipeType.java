package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes.RecipeTypeDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "recipe_type")
public class RecipeType implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "recipe_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer recipeTypeId;

	/**
	 * "description of the recipe type" 
	 */
	@Column(name = "recipe_type_desc")
	private String recipeTypeDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public RecipeType() {
		super();
	}

	public RecipeType(Integer recipeTypeId, String recipeTypeDesc, String actv) {
		super();
		this.recipeTypeId = recipeTypeId;
		this.recipeTypeDesc = recipeTypeDesc;
		this.actv = actv;
	}

	public Integer getRecipeTypeId() {
		return recipeTypeId;
	}

	public void setRecipeTypeId(Integer recipeTypeId) {
		this.recipeTypeId=recipeTypeId;
	}

	public String getRecipeTypeDesc() {
		return recipeTypeDesc;
	}

	public void setRecipeTypeDesc(String recipeTypeDesc) {
		this.recipeTypeDesc=recipeTypeDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "RecipeType [recipeTypeId=" + recipeTypeId + ", recipeTypeDesc=" + recipeTypeDesc + ", actv=" + actv + "]";
	}

	public static RecipeType fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecipeType.class );
	}
	public RecipeTypeDTO toDTO() {
		return new RecipeTypeDTO(this.getRecipeTypeId(),this.getRecipeTypeDesc(),this.getActv());
	}
}
