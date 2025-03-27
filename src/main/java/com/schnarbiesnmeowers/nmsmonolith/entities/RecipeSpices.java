package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.RecipeSpicesDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "recipe_spices")
public class RecipeSpices implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "recipe_spice_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer recipeSpiceId;

	/**
	 * "fk to the recipes.recipe_id field" 
	 */
	@Column(name = "recipe_id")
	private Integer recipeId;

	/**
	 * "fk to the spices.spice_id" 
	 */
	@Column(name = "spice_id")
	private Integer spiceId;

	/**
	 * "the size of an individual serving" 
	 */
	@Column(name = "serv_sz")
	private BigDecimal servSz;

	/**
	 * "fk to the serving_types.serv_type_id field" 
	 */
	@Column(name = "serv_type_id")
	private Integer servTypeId;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public RecipeSpices() {
		super();
	}

	public RecipeSpices(Integer recipeSpiceId, Integer recipeId, Integer spiceId,
		BigDecimal servSz, Integer servTypeId, String actv) {
		super();
		this.recipeSpiceId = recipeSpiceId;
		this.recipeId = recipeId;
		this.spiceId = spiceId;
		this.servSz = servSz;
		this.servTypeId = servTypeId;
		this.actv = actv;
	}

	public Integer getRecipeSpiceId() {
		return recipeSpiceId;
	}

	public void setRecipeSpiceId(Integer recipeSpiceId) {
		this.recipeSpiceId=recipeSpiceId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId=recipeId;
	}

	public Integer getSpiceId() {
		return spiceId;
	}

	public void setSpiceId(Integer spiceId) {
		this.spiceId=spiceId;
	}

	public BigDecimal getServSz() {
		return servSz;
	}

	public void setServSz(BigDecimal servSz) {
		this.servSz=servSz;
	}

	public Integer getServTypeId() {
		return servTypeId;
	}

	public void setServTypeId(Integer servTypeId) {
		this.servTypeId=servTypeId;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "RecipeSpices [recipeSpiceId=" + recipeSpiceId + ", recipeId=" + recipeId + ", spiceId=" + spiceId + ", servSz=" + servSz + ", servTypeId=" + servTypeId + ", actv=" + actv + "]";
	}

	public static RecipeSpices fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecipeSpices.class );
	}
	public RecipeSpicesDTO toDTO() {
		return new RecipeSpicesDTO(this.getRecipeSpiceId(),this.getRecipeId(),this.getSpiceId(),this.getServSz(),this.getServTypeId(),this.getActv());
	}
}
