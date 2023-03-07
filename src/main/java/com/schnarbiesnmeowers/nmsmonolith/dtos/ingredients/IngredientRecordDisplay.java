package com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients;

import java.io.Serializable;

/**
 * the purpose of this class is to send back the minimum data needed for each ingredient so that
 * these can be displayed in a list
 */
public class IngredientRecordDisplay implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    private Integer ingrId;

    /**
     * "description of the ingredient"
     */
    private String ingrDesc;

    /**
     * "fk to the ingredient_types.ingr_type_id field"
     */
    private Integer ingrTypeId;

    /**
     * "fk to the brands.brand_id field"
     */
    private Integer brandId;

    private boolean local;

    private boolean localBrand;

    public IngredientRecordDisplay() {
    }

    public IngredientRecordDisplay(Integer ingrId, String ingrDesc, Integer ingrTypeId, Integer brandId, boolean local, boolean localBrand) {
        this.ingrId = ingrId;
        this.ingrDesc = ingrDesc;
        this.ingrTypeId = ingrTypeId;
        this.brandId = brandId;
        this.local = local;
        this.localBrand = localBrand;
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

    public Integer getIngrTypeId() {
        return ingrTypeId;
    }

    public void setIngrTypeId(Integer ingrTypeId) {
        this.ingrTypeId = ingrTypeId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public boolean isLocalBrand() {
        return localBrand;
    }

    public void setLocalBrand(boolean localBrand) {
        this.localBrand = localBrand;
    }

    @Override
    public String toString() {
        return "IngredientRecordDisplay{" +
                "ingrId=" + ingrId +
                ", ingrDesc='" + ingrDesc + '\'' +
                ", ingrTypeId=" + ingrTypeId +
                ", brandId=" + brandId +
                ", local=" + local +
                ", localBrand=" + localBrand +
                '}';
    }
}
