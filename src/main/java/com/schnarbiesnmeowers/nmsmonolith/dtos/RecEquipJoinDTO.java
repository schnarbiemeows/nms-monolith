package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.RecEquipJoin;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class RecEquipJoinDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer recEquipJoinId;

	/**
	 * "fk to the recipes.recipe_id field" 
	 */
	private Integer recipeId;

	/**
	 * "fk to the recipe_equip.recipe_equip_id field" 
	 */
	private Integer recipeEquipId;

	/**
	 * default constructor
	 */
	public RecEquipJoinDTO() {
		super();
	}

	public RecEquipJoinDTO(Integer recEquipJoinId, Integer recipeId, Integer recipeEquipId) {
		super();
		this.recEquipJoinId = recEquipJoinId;
		this.recipeId = recipeId;
		this.recipeEquipId = recipeEquipId;
	}

	public Integer getRecEquipJoinId() {
		return recEquipJoinId;
	}

	public void setRecEquipJoinId(Integer recEquipJoinId) {
		this.recEquipJoinId=recEquipJoinId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId=recipeId;
	}

	public Integer getRecipeEquipId() {
		return recipeEquipId;
	}

	public void setRecipeEquipId(Integer recipeEquipId) {
		this.recipeEquipId=recipeEquipId;
	}

	@Override
	public String toString() {
		return "RecEquipJoinDTO [recEquipJoinId=" + recEquipJoinId + ", recipeId=" + recipeId + ", recipeEquipId=" + recipeEquipId + "]";
	}

	public static RecEquipJoinDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecEquipJoinDTO.class );
	}
	public RecEquipJoin toEntity() {
		return new RecEquipJoin(this.getRecEquipJoinId(),this.getRecipeId(),this.getRecipeEquipId());
	}
}
