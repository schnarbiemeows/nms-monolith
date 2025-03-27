package com.schnarbiesnmeowers.nmsmonolith.dtos.brands;

import com.schnarbiesnmeowers.nmsmonolith.entities.FavoriteBrands;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class FavoriteBrandsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer favoriteBrandId;

	/**
	 * "fk to the brands.brand_id field or the local_brands.brand_id field" 
	 */
	private Integer brandId;

	/**
	 * "is the brand_id fk a local brand_id?" 
	 */
	private boolean local;

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
	public FavoriteBrandsDTO() {
		super();
	}

	public FavoriteBrandsDTO(Integer favoriteBrandId, Integer brandId, boolean local, String actv, Integer userId) {
		super();
		this.favoriteBrandId = favoriteBrandId;
		this.brandId = brandId;
		this.local = local;
		this.actv = actv;
		this.userId = userId;
	}

	public Integer getFavoriteBrandId() {
		return favoriteBrandId;
	}

	public void setFavoriteBrandId(Integer favoriteBrandId) {
		this.favoriteBrandId=favoriteBrandId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId=brandId;
	}

	public boolean isLocal() {
		return local;
	}

	public void setLocal(boolean local) {
		this.local = local;
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
		return "FavoriteBrandsDTO [favoriteBrandId=" + favoriteBrandId + ", brandId=" + brandId + ", isLocal=" + local + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static FavoriteBrandsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, FavoriteBrandsDTO.class );
	}
	public FavoriteBrands toEntity() {
		return new FavoriteBrands(this.getFavoriteBrandId(),this.getBrandId(),this.isLocal(),this.getActv(),this.getUserId());
	}
}
