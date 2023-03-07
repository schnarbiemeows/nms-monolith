package com.schnarbiesnmeowers.nmsmonolith.dtos.recipes;

import java.math.BigDecimal;

public class RecipeSpiceDisplay {
    private Integer spiceId;
    private String description;
    private boolean local;
    private BigDecimal servSz;
    private Integer servUnitId;
    private String servUnitDesc;

    public RecipeSpiceDisplay() {
    }

    public RecipeSpiceDisplay(Integer spiceId, String description, boolean local,
                              BigDecimal servSz, Integer servUnitId, String servUnitDesc) {
        this.spiceId = spiceId;
        this.description = description;
        this.local = local;
        this.servSz = servSz;
        this.servUnitId = servUnitId;
        this.servUnitDesc = servUnitDesc;
    }

    public Integer getSpiceId() {
        return spiceId;
    }

    public void setSpiceId(Integer spiceId) {
        this.spiceId = spiceId;
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

    @Override
    public String toString() {
        return "RecipeSpiceDisplay{" +
                "spiceId=" + spiceId +
                ", description='" + description + '\'' +
                ", local=" + local +
                ", servSz=" + servSz +
                ", servUnitId=" + servUnitId +
                ", servUnitDesc='" + servUnitDesc + '\'' +
                '}';
    }
}
