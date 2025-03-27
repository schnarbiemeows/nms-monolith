package com.schnarbiesnmeowers.nmsmonolith.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class MostPopularFoodItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer bldstId;

    private Integer ingrId;

    private String ingrDesc;

    private Integer total;

    private Boolean recipe;

    private Boolean local;

    private BigDecimal numSrv;

    private Integer servTypeId;

    private String servTypeCde;

    public MostPopularFoodItemDTO() {
    }

    public MostPopularFoodItemDTO(Integer userId, Integer bldstId, Integer ingrId, String ingrDesc, Integer total,
                                  Boolean recipe, Boolean local, BigDecimal numSrv, Integer servTypeId, String servTypeCde) {
        this.userId = userId;
        this.bldstId = bldstId;
        this.ingrId = ingrId;
        this.ingrDesc = ingrDesc;
        this.total = total;
        this.recipe = recipe;
        this.local = local;
        this.numSrv = numSrv;
        this.servTypeId = servTypeId;
        this.servTypeCde = servTypeCde;
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

    public String getIngrDesc() {
        return ingrDesc;
    }

    public void setIngrDesc(String ingrDesc) {
        this.ingrDesc = ingrDesc;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public String getServTypeCde() {
        return servTypeCde;
    }

    public void setServTypeCde(String servTypeCde) {
        this.servTypeCde = servTypeCde;
    }

    @Override
    public String toString() {
        return "MostPopularFoodItemDTO{" +
                "userId=" + userId +
                ", bldstId=" + bldstId +
                ", ingrId=" + ingrId +
                ", ingrDesc='" + ingrDesc + '\'' +
                ", total=" + total +
                ", isRecipe=" + recipe +
                ", isLocal=" + local +
                ", numSrv=" + numSrv +
                ", servTypeId=" + servTypeId +
                ", servTypeCde='" + servTypeCde + '\'' +
                '}';
    }

}
