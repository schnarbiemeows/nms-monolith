package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.TemplateItems;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

public class TemplateItemsDTO implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    private Integer templateItemsId;

    private Integer templateId;

    /**
     * "fk to ingredients.ingr_id field"
     */
    private Integer ingrId;

    /**
     * "is this a recipe(y or n)?"
     */
    private boolean isRecipe;

    /**
     * "is this a local recipe or ingredient?"
     */
    private boolean isLocal;

    /**
     * "fk to the bldst_table.bldst_table_id field"
     */
    private Integer bldstId;

    /**
     * "the number of servings of this item eaten"
     */
    private BigDecimal numSrv;

    /**
     * "fk to the serving_types.serv_type_id field"
     */
    private Integer servTypeId;

    /**
     * "at what time of the day was this item eaten"
     */

    private String timeEaten;

    public TemplateItemsDTO() {
    }

    public TemplateItemsDTO(Integer templateItemsId, Integer templateId, Integer ingrId, boolean isRecipe, boolean isLocal, Integer bldstId, BigDecimal numSrv, Integer servTypeId, String timeEaten) {
        this.templateItemsId = templateItemsId;
        this.templateId = templateId;
        this.ingrId = ingrId;
        this.isRecipe = isRecipe;
        this.isLocal = isLocal;
        this.bldstId = bldstId;
        this.numSrv = numSrv;
        this.servTypeId = servTypeId;
        this.timeEaten = timeEaten;
    }

    public Integer getTemplateItemsId() {
        return templateItemsId;
    }

    public void setTemplateItemsId(Integer templateItemsId) {
        this.templateItemsId = templateItemsId;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public Integer getIngrId() {
        return ingrId;
    }

    public void setIngrId(Integer ingrId) {
        this.ingrId = ingrId;
    }

    public boolean isRecipe() {
        return isRecipe;
    }

    public void setRecipe(boolean recipe) {
        isRecipe = recipe;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public Integer getBldstId() {
        return bldstId;
    }

    public void setBldstId(Integer bldstId) {
        this.bldstId = bldstId;
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

    public String getTimeEaten() {
        return timeEaten;
    }

    public void setTimeEaten(String timeEaten) {
        this.timeEaten = timeEaten;
    }

    @Override
    public String toString() {
        return "TemplateItems{" +
                "templateItemsId=" + templateItemsId +
                ", templateId=" + templateId +
                ", ingrId=" + ingrId +
                ", isRecipe=" + isRecipe +
                ", isLocal=" + isLocal +
                ", bldstId=" + bldstId +
                ", numSrv=" + numSrv +
                ", servTypeId=" + servTypeId +
                ", timeEaten='" + timeEaten + '\'' +
                '}';
    }

    public TemplateItems toEntity() {
        return new TemplateItems(this.templateItemsId,this.templateId,this.ingrId,this.isRecipe,
                this.isLocal,this.bldstId,this.numSrv,this.servTypeId,this.timeEaten);
    }
}
