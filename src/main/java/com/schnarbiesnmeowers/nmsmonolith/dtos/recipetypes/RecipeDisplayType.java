package com.schnarbiesnmeowers.nmsmonolith.dtos.recipetypes;

public class RecipeDisplayType {

    private Integer recipeTypeId;

    private String displayValue;

    public RecipeDisplayType() {
    }

    public RecipeDisplayType(Integer recipeTypeId, String displayValue) {
        this.recipeTypeId = recipeTypeId;
        this.displayValue = displayValue;
    }

    public Integer getRecipeTypeId() {
        return recipeTypeId;
    }

    public void setRecipeTypeId(Integer recipeTypeId) {
        this.recipeTypeId = recipeTypeId;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }
}
