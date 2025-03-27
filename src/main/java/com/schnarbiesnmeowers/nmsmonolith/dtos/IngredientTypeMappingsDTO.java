package com.schnarbiesnmeowers.nmsmonolith.dtos;

import java.io.Serializable;
import java.util.Arrays;

public class IngredientTypeMappingsDTO implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer parentId;

    /**
     *
     */
    private String ingredientTypeDesc;

    /**
     * this is a list of integers
     */
    private int[] childIds;

    public IngredientTypeMappingsDTO() {
    }

    public IngredientTypeMappingsDTO(Integer parentId, String ingredientTypeDesc, int[] childIds) {
        this.parentId = parentId;
        this.ingredientTypeDesc = ingredientTypeDesc;
        this.childIds = childIds;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getIngredientTypeDesc() {
        return ingredientTypeDesc;
    }

    public void setIngredientTypeDesc(String ingredientTypeDesc) {
        this.ingredientTypeDesc = ingredientTypeDesc;
    }

    public int[] getChildIds() {
        return childIds;
    }

    public void setChildIds(int[] childIds) {
        this.childIds = childIds;
    }

    @Override
    public String toString() {
        return "IngredientTypeMappingsDTO{" +
                "parentId=" + parentId +
                ", ingredientTypeDesc='" + ingredientTypeDesc + '\'' +
                ", childIds=" + Arrays.toString(childIds) +
                '}';
    }
}
