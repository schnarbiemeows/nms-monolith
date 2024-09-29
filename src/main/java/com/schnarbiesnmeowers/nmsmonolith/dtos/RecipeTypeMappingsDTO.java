package com.schnarbiesnmeowers.nmsmonolith.dtos;

import java.io.Serializable;

public class RecipeTypeMappingsDTO implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer parentId;

    /**
     *
     */
    private String recipeTypeDesc;

    /**
     * this is a list of integers
     */
    private int[] childIds;

    public RecipeTypeMappingsDTO() {
    }

    public RecipeTypeMappingsDTO(Integer parentId, String recipeTypeDesc, int[] childIds) {
        this.parentId = parentId;
        this.recipeTypeDesc = recipeTypeDesc;
        this.childIds = childIds;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRecipeTypeDesc() {
        return recipeTypeDesc;
    }

    public void setRecipeTypeDesc(String recipeTypeDesc) {
        this.recipeTypeDesc = recipeTypeDesc;
    }

    public int[] getChildIds() {
        return childIds;
    }

    public void setChildIds(int[] childIds) {
        this.childIds = childIds;
    }

    @Override
    public String toString() {
        return "RecipeMappingsDTO{" +
                "parentId=" + parentId +
                ", recipeTypeDesc='" + recipeTypeDesc + '\'' +
                ", childId='" + childIds + '\'' +
                '}';
    }

}
