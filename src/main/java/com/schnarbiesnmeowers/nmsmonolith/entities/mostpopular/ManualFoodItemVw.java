package com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ManualFoodItemVwDTO;
import jakarta.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * I'm not going to use this class for querying because it is redundant; I should just use the MostPopularFoodItem class
 */
@Entity
@Table(name = "manual_food_items_vw")
public class ManualFoodItemVw implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "manual_food_item_id")
    @Id()
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer manualFoodItemId;

    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "BLDST_ID")
    private Integer bldstId;

    @Column(name = "INGR_ID")
    private Integer ingrId;

    @Column(name = "INGR_DESC")
    private String ingr_desc;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "NUM_SRV")
    private BigDecimal numSrv;

    @Column(name = "IS_RECIPE")
    private Boolean isRecipe;

    @Column(name = "IS_LOCAL")
    private Boolean isLocal;

    @Column(name = "SERV_TYPE_ID")
    private Integer servTypeId;

    @Column(name = "SERV_TYPE_CDE")
    private String servTypeCde;

    public ManualFoodItemVw() {
    }

    public ManualFoodItemVw(Integer manualFoodItemId, Integer userId, Integer bldstId, Integer ingrId, String ingr_desc,
                            BigDecimal total, BigDecimal numSrv, Boolean isRecipe, Boolean isLocal, Integer servTypeId,
                            String servTypeCde) {
        this.manualFoodItemId = manualFoodItemId;
        this.userId = userId;
        this.bldstId = bldstId;
        this.ingrId = ingrId;
        this.ingr_desc = ingr_desc;
        this.total = total;
        this.numSrv = numSrv;
        this.isRecipe = isRecipe;
        this.isLocal = isLocal;
        this.servTypeId = servTypeId;
        this.servTypeCde = servTypeCde;
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

    public String getIngr_desc() {
        return ingr_desc;
    }

    public void setIngr_desc(String ingr_desc) {
        this.ingr_desc = ingr_desc;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getServTypeCde() {
        return servTypeCde;
    }

    public void setServTypeCde(String servTypeCde) {
        this.servTypeCde = servTypeCde;
    }

    public ManualFoodItemVwDTO toDTO() {
        return new ManualFoodItemVwDTO(this.manualFoodItemId,this.userId,this.bldstId,this.ingrId,this.ingr_desc,
                this.total,this.isRecipe,
                this.isLocal,this.numSrv,this.servTypeId,this.servTypeCde);
    }
}
