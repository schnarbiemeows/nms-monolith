package com.schnarbiesnmeowers.nmsmonolith.dtos.brands;

import java.io.Serializable;

public class BrandMinDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer brandId;

    private String brandName;

    public BrandMinDTO() {
    }

    public BrandMinDTO(Integer brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "BrandMinDTO{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
