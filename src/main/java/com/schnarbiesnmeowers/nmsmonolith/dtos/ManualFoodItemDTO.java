package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular.ManualFoodItem;

import java.io.Serializable;
import java.math.BigDecimal;

public class ManualFoodItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer manualFoodItemId;

    private Integer userId;

    private Integer bldstId;

    private Integer ingrId;

    private Boolean recipe;

    private Boolean local;

    private BigDecimal numSrv;

    private Integer servTypeId;

    public ManualFoodItemDTO() {
    }

    public ManualFoodItemDTO(Integer manualFoodItemId, Integer userId, Integer bldstId, Integer ingrId,
                               Boolean recipe, Boolean local, BigDecimal numSrv,
                               Integer servTypeId) {
        this.manualFoodItemId = manualFoodItemId;
        this.userId = userId;
        this.bldstId = bldstId;
        this.ingrId = ingrId;
        this.recipe = recipe;
        this.local = local;
        this.numSrv = numSrv;
        this.servTypeId = servTypeId;
    }

    public Integer getManualFoodItemId() {
        return manualFoodItemId;
    }

    public void setManualFoodItemId(Integer manualFoodItemId) {
        this.manualFoodItemId = manualFoodItemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBldstId() {
        return bldstId;
    }

    public void setBldstId(Integer bldstId) {
        this.bldstId = bldstId;
    }

    public Integer getIngrId() {
        return ingrId;
    }

    public void setIngrId(Integer ingrId) {
        this.ingrId = ingrId;
    }

    public Boolean getRecipe() {
        return recipe;
    }

    public void setRecipe(Boolean recipe) {
        this.recipe = recipe;
    }

    public Boolean getLocal() {
        return local;
    }

    public void setLocal(Boolean local) {
        this.local = local;
    }

    public BigDecimal getNumSrv() {
        return numSrv;
    }

    public void setNumSrv(BigDecimal numSrv) {
        this.numSrv = numSrv;
    }

    public Integer getServTypeId() {
        return servTypeId;
    }

    public void setServTypeId(Integer servTypeId) {
        this.servTypeId = servTypeId;
    }


    public ManualFoodItem toEntity() {
        return new ManualFoodItem(this.manualFoodItemId, this.userId, this.bldstId, this.ingrId,
                this.numSrv, this.recipe,
                this.local, this.servTypeId);
    }
}
