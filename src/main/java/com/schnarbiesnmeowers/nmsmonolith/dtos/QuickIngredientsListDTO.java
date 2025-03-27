package com.schnarbiesnmeowers.nmsmonolith.dtos;

import jakarta.persistence.Column;
import java.math.BigDecimal;

public class QuickIngredientsListDTO {

    private Integer id;

    private Integer userId;

    private Integer mealTypeId;
    private String mealTypeDesc;
    private Integer ingredientId;
    private String ingredientDesc;
    private boolean local;
    private Integer servTypeId;
    private String servTypeCde;
    private BigDecimal quantity;

    public QuickIngredientsListDTO() {
    }

    public QuickIngredientsListDTO(Integer id, Integer userId, Integer mealTypeId, String mealTypeDesc, Integer ingredientId,
                                   String ingredientDesc, boolean local, Integer servTypeId, String servTypeCde, BigDecimal quantity) {
        this.id = id;
        this.userId = userId;
        this.mealTypeId = mealTypeId;
        this.mealTypeDesc = mealTypeDesc;
        this.ingredientId = ingredientId;
        this.ingredientDesc = ingredientDesc;
        this.local = local;
        this.servTypeId = servTypeId;
        this.servTypeCde = servTypeCde;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMealTypeId() {
        return mealTypeId;
    }

    public void setMealTypeId(Integer mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    public String getMealTypeDesc() {
        return mealTypeDesc;
    }

    public void setMealTypeDesc(String mealTypeDesc) {
        this.mealTypeDesc = mealTypeDesc;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientDesc() {
        return ingredientDesc;
    }

    public void setIngredientDesc(String ingredientDesc) {
        this.ingredientDesc = ingredientDesc;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public Integer getServTypeId() {
        return servTypeId;
    }

    public void setServTypeId(Integer servTypeId) {
        this.servTypeId = servTypeId;
    }

    public String getServTypeCde() {
        return servTypeCde;
    }

    public void setServTypeCde(String servTypeCde) {
        this.servTypeCde = servTypeCde;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "QuickIngredientsListDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", mealTypeId=" + mealTypeId +
                ", mealTypeDesc='" + mealTypeDesc + '\'' +
                ", ingredientId=" + ingredientId +
                ", ingredientDesc='" + ingredientDesc + '\'' +
                ", local=" + local +
                ", servTypeId=" + servTypeId +
                ", servTypeCde='" + servTypeCde + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
