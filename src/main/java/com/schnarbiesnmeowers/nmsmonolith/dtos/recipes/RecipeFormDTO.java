package com.schnarbiesnmeowers.nmsmonolith.dtos.recipes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class RecipeFormDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private RecipesDTO recipeMetaData;
    private boolean local;

    private BigDecimal servingSize;

    private Integer servingTypeId;
    private Integer userId;
    private List<RecipeIngredientDisplay> recipeIngredients;

    private List<RecipeSpiceDisplay> recipeSpices;

    private List<RecipeStepsDisplay> recipeSteps;

    public RecipeFormDTO() {
    }

    public RecipeFormDTO(RecipesDTO recipeMetaData, boolean local, BigDecimal servingSize, Integer servingTypeId,
        Integer userId, List<RecipeIngredientDisplay> recipeIngredients, List<RecipeSpiceDisplay> recipeSpices,
                         List<RecipeStepsDisplay> recipeSteps) {
        this.recipeMetaData = recipeMetaData;
        this.local = local;
        this.servingSize = servingSize;
        this.servingTypeId = servingTypeId;
        this.userId = userId;
        this.recipeIngredients = recipeIngredients;
        this.recipeSpices = recipeSpices;
        this.recipeSteps = recipeSteps;
    }

    public RecipesDTO getRecipeMetaData() {
        return recipeMetaData;
    }

    public void setRecipeMetaData(RecipesDTO recipeMetaData) {
        this.recipeMetaData = recipeMetaData;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public List<RecipeIngredientDisplay> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredientDisplay> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getServingSize() {
        return servingSize;
    }

    public void setServingSize(BigDecimal servingSize) {
        this.servingSize = servingSize;
    }

    public Integer getServingTypeId() {
        return servingTypeId;
    }

    public void setServingTypeId(Integer servingTypeId) {
        this.servingTypeId = servingTypeId;
    }

    public List<RecipeSpiceDisplay> getRecipeSpices() {
        return recipeSpices;
    }

    public void setRecipeSpices(List<RecipeSpiceDisplay> recipeSpices) {
        this.recipeSpices = recipeSpices;
    }

    public List<RecipeStepsDisplay> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStepsDisplay> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    @Override
    public String toString() {
        return "RecipeFormDTO{" +
                "recipeMetaData=" + recipeMetaData +
                ", local=" + local +
                ", servingSize=" + servingSize +
                ", servingTypeId=" + servingTypeId +
                ", userId=" + userId +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeSpices=" + recipeSpices +
                ", recipeSteps=" + recipeSteps +
                '}';
    }
}
