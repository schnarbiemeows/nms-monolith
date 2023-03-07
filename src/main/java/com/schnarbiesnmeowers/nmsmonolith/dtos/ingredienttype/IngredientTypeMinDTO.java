package com.schnarbiesnmeowers.nmsmonolith.dtos.ingredienttype;

import java.io.Serializable;

public class IngredientTypeMinDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer ingrTypeId;

    private String ingrTypeDesc;

    public IngredientTypeMinDTO() {
    }

    public IngredientTypeMinDTO(Integer ingrTypeId, String ingrTypeDesc) {
        this.ingrTypeId = ingrTypeId;
        this.ingrTypeDesc = ingrTypeDesc;
    }

    public Integer getIngrTypeId() {
        return ingrTypeId;
    }

    public void setIngrTypeId(Integer ingrTypeId) {
        this.ingrTypeId = ingrTypeId;
    }

    public String getIngrTypeDesc() {
        return ingrTypeDesc;
    }

    public void setIngrTypeDesc(String ingrTypeDesc) {
        this.ingrTypeDesc = ingrTypeDesc;
    }

    @Override
    public String toString() {
        return "IngredientTypeMinDTO{" +
                "ingrTypeId=" + ingrTypeId +
                ", ingrTypeDesc='" + ingrTypeDesc + '\'' +
                '}';
    }
}
