package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalRecipeSteps;
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
public class LocalRecipeStepsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer recipeStepId;

	/**
	 * "fk to the local_recipes.recipe_id field" 
	 */
	private Integer recipeId;

	/**
	 * "the step order" 
	 */
	private Integer stepNum;

	/**
	 * "step description" 
	 */
	private String stepDesc;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	private Integer imageLoc;

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
	public LocalRecipeStepsDTO() {
		super();
	}

	public LocalRecipeStepsDTO(Integer recipeStepId, Integer recipeId, Integer stepNum, String stepDesc, Integer imageLoc, String actv, Integer userId) {
		super();
		this.recipeStepId = recipeStepId;
		this.recipeId = recipeId;
		this.stepNum = stepNum;
		this.stepDesc = stepDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
		this.userId = userId;
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
		return "LocalRecipeStepsDTO [recipeStepId=" + recipeStepId + ", recipeId=" + recipeId + ", stepNum=" + stepNum + ", stepDesc=" + stepDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static LocalRecipeStepsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalRecipeStepsDTO.class );
	}
	public LocalRecipeSteps toEntity() {
		return new LocalRecipeSteps(this.getRecipeStepId(),this.getRecipeId(),this.getStepNum(),this.getStepDesc(),this.getImageLoc(),this.getActv(),this.getUserId());
	}
}
