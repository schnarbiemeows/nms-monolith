package com.schnarbiesnmeowers.nmsmonolith.entities.mostpopular;

import com.schnarbiesnmeowers.nmsmonolith.dtos.MostPopularFoodItemDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Immutable
@Table(name = "daily_diet")
@IdClass(MostPopularFoodItemPK.class)
public class MostPopularFoodItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "USER_ID")
    @Id
    private Integer userId;

    @Column(name = "BLDST_ID")
    @Id
    private Integer bldstId;

    @Column(name = "INGR_ID")
    @Id
    private Integer ingrId;

    @Column(name = "ingr_desc")
    private String ingrDesc;

    @Column(name = "total")
    private Integer total;

    @Column(name = "IS_RECIPE")
    @Id
    private Boolean isRecipe;

    @Column(name = "IS_LOCAL")
    @Id
    private Boolean isLocal;

    @Column(name = "NUM_SRV")
    @Id
    private BigDecimal numSrv;

    @Column(name = "SERV_TYPE_ID")
    @Id
    private Integer servTypeId;

    @Column(name = "serv_type_cde")
    private String servTypeCde;

    public MostPopularFoodItem() {
    }

    public MostPopularFoodItem(Integer userId, Integer bldstId, Integer ingrId, String ingrDesc, Integer total,
                               Boolean isRecipe, Boolean isLocal, BigDecimal numSrv, Integer servTypeId, String servTypeCde) {
        this.userId = userId;
        this.bldstId = bldstId;
        this.ingrId = ingrId;
        this.ingrDesc = ingrDesc;
        this.total = total;
        this.isRecipe = isRecipe;
        this.isLocal = isLocal;
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

    public String getServTypeCde() {
        return servTypeCde;
    }

    public void setServTypeCde(String servTypeCde) {
        this.servTypeCde = servTypeCde;
    }

    @Override
    public String toString() {
        return "MostPopularFoodItem{" +
                "userId=" + userId +
                ", bldstId=" + bldstId +
                ", ingrId=" + ingrId +
                ", ingrDesc='" + ingrDesc + '\'' +
                ", total=" + total +
                ", isRecipe=" + isRecipe +
                ", isLocal=" + isLocal +
                ", numSrv=" + numSrv +
                ", servTypeId=" + servTypeId +
                ", servTypeCde='" + servTypeCde + '\'' +
                '}';
    }

    public MostPopularFoodItemDTO toDTO() {
        return new MostPopularFoodItemDTO(this.userId,this.bldstId,this.ingrId,this.ingrDesc,
                this.total,this.isRecipe,this.isLocal,this.numSrv,this.servTypeId,this.servTypeCde);
    }
}
