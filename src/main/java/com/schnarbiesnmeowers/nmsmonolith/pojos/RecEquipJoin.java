package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEquipJoinDTO;
import javax.persistence.*;
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
@Entity
@Table(name = "rec_equip_join")
public class RecEquipJoin implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "rec_equip_join_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer recEquipJoinId;

	/**
	 * "fk to the recipes.recipe_id field" 
	 */
	@Column(name = "recipe_id")
	private Integer recipeId;

	/**
	 * "fk to the recipe_equip.recipe_equip_id field" 
	 */
	@Column(name = "recipe_equip_id")
	private Integer recipeEquipId;

	/**
	 * default constructor
	 */
	public RecEquipJoin() {
		super();
	}

	public RecEquipJoin(Integer recEquipJoinId, Integer recipeId, Integer recipeEquipId) {
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
		return "RecEquipJoin [recEquipJoinId=" + recEquipJoinId + ", recipeId=" + recipeId + ", recipeEquipId=" + recipeEquipId + "]";
	}

	public static RecEquipJoin fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecEquipJoin.class );
	}
	public RecEquipJoinDTO toDTO() {
		return new RecEquipJoinDTO(this.getRecEquipJoinId(),this.getRecipeId(),this.getRecipeEquipId());
	}
}
