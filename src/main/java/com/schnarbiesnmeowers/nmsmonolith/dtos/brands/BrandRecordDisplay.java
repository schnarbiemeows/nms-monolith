package com.schnarbiesnmeowers.nmsmonolith.dtos.brands;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * the purpose of this class is to send back the minimum data needed for each brand so that
 * these can be displayed in a list
 */
public class BrandRecordDisplay implements Serializable {
    // default serial version id, required for serializable classes
    private static final long serialVersionUID = 1L;

    //private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

    /**
     *
     */
    private Integer brandId;

    /**
     * "brand type(n = name&!@ g = generic&!@ s = store)"
     */
    private String brandType;

    /**
     * "name of the brand"
     */
    private String brandName;

    private boolean local;

    /**
     * default constructor
     */
    public BrandRecordDisplay() {
        super();
    }

    public BrandRecordDisplay(Integer brandId, String brandType, String brandName, boolean local) {
        this.brandId = brandId;
        this.brandType = brandType;
        this.brandName = brandName;
        this.local = local;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId=brandId;
    }

    public String getBrandType() {
        return brandType;
    }

    public void setBrandType(String brandType) {
        this.brandType=brandType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName=brandName;
    }

    public boolean isLocal() {
        return local;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "BrandRecordDisplay{" +
                "brandId=" + brandId +
                ", brandType='" + brandType + '\'' +
                ", brandName='" + brandName + '\'' +
                ", local=" + local +
                '}';
    }

    public static BrandsDTO fromJson(String input) {
        Gson gson = new Gson();
        return gson.fromJson(input, BrandsDTO.class );
    }

}
