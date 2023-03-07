package com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes;

import com.schnarbiesnmeowers.nmsmonolith.pojos.RecipeType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class RecipeTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer recipeTypeId;

	/**
	 * "description of the recipe type" 
	 */
	private String recipeTypeDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * hierarchy for the recipe type navigation
	 */
	private List<RecipeTypeDTO> childRecipeTypes = new ArrayList<>();
	/**
	 * default constructor
	 */
	public RecipeTypeDTO() {
		super();
	}

	public RecipeTypeDTO(Integer recipeTypeId, String recipeTypeDesc, String actv) {
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
		return "RecipeTypeDTO [recipeTypeId=" + recipeTypeId + ", recipeTypeDesc=" + recipeTypeDesc + ", actv=" + actv + "]";
	}

	public static RecipeTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecipeTypeDTO.class );
	}
	public RecipeType toEntity() {
		return new RecipeType(this.getRecipeTypeId(),this.getRecipeTypeDesc(),this.getActv());
	}
}
