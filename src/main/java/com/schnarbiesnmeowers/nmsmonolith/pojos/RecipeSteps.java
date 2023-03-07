package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecipeStepsDTO;
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
@Table(name = "recipe_steps")
public class RecipeSteps implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "recipe_step_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer recipeStepId;

	/**
	 * "fk to the recipes.recipe_id field" 
	 */
	@Column(name = "recipe_id")
	private Integer recipeId;

	/**
	 * "the step order" 
	 */
	@Column(name = "step_num")
	private Integer stepNum;

	/**
	 * "step description" 
	 */
	@Column(name = "step_desc")
	private String stepDesc;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	@Column(name = "image_loc")
	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?"
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public RecipeSteps() {
		super();
	}

	public RecipeSteps(Integer recipeStepId, Integer recipeId, Integer stepNum, String stepDesc, Integer imageLoc, String actv) {
		this.recipeStepId = recipeStepId;
		this.recipeId = recipeId;
		this.stepNum = stepNum;
		this.stepDesc = stepDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getRecipeStepId() {
		return recipeStepId;
	}

	public void setRecipeStepId(Integer recipeStepId) {
		this.recipeStepId=recipeStepId;
	}

	public Integer getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Integer recipeId) {
		this.recipeId=recipeId;
	}

	public Integer getStepNum() {
		return stepNum;
	}

	public void setStepNum(Integer stepNum) {
		this.stepNum=stepNum;
	}

	public String getStepDesc() {
		return stepDesc;
	}

	public void setStepDesc(String stepDesc) {
		this.stepDesc=stepDesc;
	}

	public Integer getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(Integer imageLoc) {
		this.imageLoc=imageLoc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv = actv;
	}

	@Override
	public String toString() {
		return "RecipeSteps{" +
				"recipeStepId=" + recipeStepId +
				", recipeId=" + recipeId +
				", stepNum=" + stepNum +
				", stepDesc='" + stepDesc + '\'' +
				", imageLoc=" + imageLoc +
				", actv='" + actv + '\'' +
				'}';
	}

	public static RecipeSteps fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecipeSteps.class );
	}
	public RecipeStepsDTO toDTO() {
		return new RecipeStepsDTO(this.getRecipeStepId(),this.getRecipeId(),this.getStepNum(),this.getStepDesc(),
				this.getImageLoc(),this.getActv());
	}
}
