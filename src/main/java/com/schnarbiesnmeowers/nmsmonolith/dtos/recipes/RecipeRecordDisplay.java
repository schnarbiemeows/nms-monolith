package com.schnarbiesnmeowers.nmsmonolith.dtos.recipes;

import java.io.Serializable;

public class RecipeRecordDisplay implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     *
     */
    private Integer recipeId;

    /**
     * "name of the recipe"
     */
    private String recipeName;

    private Integer recipeTypeId;

    private boolean local;

    public RecipeRecordDisplay() {
    }

    public RecipeRecordDisplay(Integer recipeId, String recipeName, Integer recipeTypeId, boolean local) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeTypeId = recipeTypeId;
        this.local = local;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getRecipeTypeId() {
        return recipeTypeId;
    }

    public void setRecipeTypeId(Integer recipeTypeId) {
        this.recipeTypeId = recipeTypeId;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "RecipeRecordDisplay{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeTypeId=" + recipeTypeId +
                ", local=" + local +
                '}';
    }
}
