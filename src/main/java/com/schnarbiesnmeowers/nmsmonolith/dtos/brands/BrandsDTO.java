package com.schnarbiesnmeowers.nmsmonolith.dtos.brands;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Brands;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class BrandsDTO implements Serializable {
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

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public BrandsDTO() {
		super();
	}

	public BrandsDTO(Integer brandId, String brandType, String brandName, Integer imageLoc, String actv) {
		super();
		this.brandId = brandId;
		this.brandType = brandType;
		this.brandName = brandName;
		this.imageLoc = imageLoc;
		this.actv = actv;
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

	public Integer getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(Integer imageLoc) {
		this.imageLoc=imageLoc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}


	@Override
	public String toString() {
		return "BrandsDTO{" +
				"brandId=" + brandId +
				", brandType='" + brandType + '\'' +
				", brandName='" + brandName + '\'' +
				", imageLoc=" + imageLoc +
				", actv='" + actv + '\'' +
				'}';
	}

	public static BrandsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, BrandsDTO.class );
	}
	public Brands toEntity() {
		return new Brands(this.getBrandId(),this.getBrandType(),this.getBrandName(),this.getImageLoc(),this.getActv());
	}

	public BrandRecordDisplay toDisplayObject() {
		return new BrandRecordDisplay(this.getBrandId(),this.getBrandType(),this.getBrandName(),false);
	}
}
