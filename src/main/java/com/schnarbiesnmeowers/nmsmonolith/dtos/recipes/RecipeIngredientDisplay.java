package com.schnarbiesnmeowers.nmsmonolith.dtos.recipes;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ingredients.IngredientsDTO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * it is important to note here that this does not directly correlate to a recipe-ingredient record
 */
public class RecipeIngredientDisplay implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer ingrId;
    private String description;
    private boolean local;
    private boolean recipe;
    private BigDecimal servSz;
    private Integer servUnitId;
    private String servUnitDesc;

    private BigDecimal multiplier;
    private IngredientsDTO nutritionalData ;

    public RecipeIngredientDisplay() {

    }

    public RecipeIngredientDisplay(Integer ingrId, String description, boolean local, boolean recipe, BigDecimal servSz,
        Integer servUnitId, String servUnitDesc, BigDecimal multiplier, IngredientsDTO nutritionalData) {
        this.ingrId = ingrId;
        this.description = description;
        this.local = local;
        this.recipe = recipe;
        this.servSz = servSz;
        this.servUnitId = servUnitId;
        this.servUnitDesc = servUnitDesc;
        this.multiplier = multiplier;
        this.nutritionalData = nutritionalData;
    }

    public Integer getIngrId() {
        return ingrId;
    }

    public void setIngrId(Integer ingrId) {
        this.ingrId = ingrId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    public boolean isRecipe() {
        return recipe;
    }

    public void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }

    public BigDecimal getServSz() {
        return servSz;
    }

    public void setServSz(BigDecimal servSz) {
        this.servSz = servSz;
    }

    public Integer getServUnitId() {
        return servUnitId;
    }

    public void setServUnitId(Integer servUnitId) {
        this.servUnitId = servUnitId;
    }

    public String getServUnitDesc() {
        return servUnitDesc;
    }

    public void setServUnitDesc(String servUnitDesc) {
        this.servUnitDesc = servUnitDesc;
    }

    public IngredientsDTO getNutritionalData() {
        return nutritionalData;
    }

    public void setNutritionalData(IngredientsDTO nutritionalData) {
        this.nutritionalData = nutritionalData;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
        return "RecipeIngredientDisplay{" +
                "ingrId=" + ingrId +
                ", description='" + description + '\'' +
                ", local=" + local +
                ", recipe=" + recipe +
                ", servSz=" + servSz +
                ", servUnitId=" + servUnitId +
                ", servUnitDesc='" + servUnitDesc + '\'' +
                ", multiplier=" + multiplier +
                ", nutritionalData=" + nutritionalData +
                '}';
    }
}
