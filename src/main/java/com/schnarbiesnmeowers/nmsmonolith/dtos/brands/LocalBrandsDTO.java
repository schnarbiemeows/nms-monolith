package com.schnarbiesnmeowers.nmsmonolith.dtos.brands;

import com.schnarbiesnmeowers.nmsmonolith.pojos.LocalBrands;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class LocalBrandsDTO implements Serializable {
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

	private Integer imageLoc;

	/**
	 * "is this record active(y or n)?" 
	 */
	private String actv;

	/**
	 * "fk to the user.user_id field") 
	 */
	private Integer userId;

	/**
	 * default constructor
	 */
	public LocalBrandsDTO() {
		super();
	}

	public LocalBrandsDTO(Integer brandId, String brandType, String brandName, Integer imageLoc, String actv, Integer userId) {
		this.brandId = brandId;
		this.brandType = brandType;
		this.brandName = brandName;
		this.imageLoc = imageLoc;
		this.actv = actv;
		this.userId = userId;
	}

	public Integer getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(Integer imageLoc) {
		this.imageLoc = imageLoc;
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
		this.brandType = brandType;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName=brandName;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	@Override
	public String toString() {
		return "LocalBrandsDTO [brandId=" + brandId + ", brandName=" + brandName + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static LocalBrandsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalBrandsDTO.class );
	}

	public BrandRecordDisplay toDisplayObject() {
		return new BrandRecordDisplay(this.getBrandId(),this.getBrandType(),this.getBrandName(),true);
	}

	public LocalBrands toEntity() {
		return new LocalBrands(this.getBrandId(),this.getBrandType(),this.getBrandName(),
				this.getImageLoc(),this.getActv(),this.getUserId());
	}

	public BrandsDTO getGlobalDTO() {
		return new BrandsDTO(this.brandId,
				this.brandType,
				this.brandName,
				this.imageLoc,
				this.actv) ;
	}
}
