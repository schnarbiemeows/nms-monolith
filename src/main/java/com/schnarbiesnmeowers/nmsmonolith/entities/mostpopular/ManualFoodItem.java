package com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ManualFoodItemDTO;
import com.schnarbiesnmeowers.nmsmonolith.dtos.ManualFoodItemVwDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "manual_food_items")
public class ManualFoodItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "manual_food_item_id")
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manualFoodItemId;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "BLDST_ID")
    private Integer bldstId;

    @Column(name = "INGR_ID")
    private Integer ingrId;

    @Column(name = "NUM_SRV")
    private BigDecimal numSrv;

    @Column(name = "IS_RECIPE")
    private Boolean isRecipe;

    @Column(name = "IS_LOCAL")
    private Boolean isLocal;

    @Column(name = "SERV_TYPE_ID")
    private Integer servTypeId;


    public ManualFoodItem() {
    }

    public ManualFoodItem(Integer manualFoodItemId, Integer userId, Integer bldstId, Integer ingrId,
                          BigDecimal numSrv, Boolean isRecipe, Boolean isLocal, Integer servTypeId) {
        this.manualFoodItemId = manualFoodItemId;
        this.userId = userId;
        this.bldstId = bldstId;
        this.ingrId = ingrId;
        this.numSrv = numSrv;
        this.isRecipe = isRecipe;
        this.isLocal = isLocal;
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
        return isRecipe;
    }

    public void setRecipe(Boolean recipe) {
        isRecipe = recipe;
    }

    public Boolean getLocal() {
        return isLocal;
    }

    public void setLocal(Boolean local) {
        isLocal = local;
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


    public ManualFoodItemDTO toDTO() {
        return new ManualFoodItemDTO(this.manualFoodItemId, this.userId, this.bldstId, this.ingrId, this.isRecipe,
                this.isLocal, this.numSrv, this.servTypeId);
    }
}
