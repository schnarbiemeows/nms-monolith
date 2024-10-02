package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.FavoriteBrandsDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "favorite_brands")
public class FavoriteBrands implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "favorite_brand_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer favoriteBrandId;

	/**
	 * "fk to the brands.brand_id field or the local_brands.brand_id field" 
	 */
	@Column(name = "brand_id")
	private Integer brandId;

	/**
	 * "is the brand_id fk a local brand_id?" 
	 */
	@Column(name = "is_local")
	private boolean isLocal;

	/**
	 * "is this record active(y or n)?" 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * "fk to the user.user_id field") 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * default constructor
	 */
	public FavoriteBrands() {
		super();
	}

	public FavoriteBrands(Integer favoriteBrandId, Integer brandId, boolean isLocal, String actv, Integer userId) {
		super();
		this.favoriteBrandId = favoriteBrandId;
		this.brandId = brandId;
		this.isLocal = isLocal;
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

	public boolean getIsLocal() {
		return isLocal;
	}

	public void setIsLocal(boolean isLocal) {
		this.isLocal=isLocal;
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
		return "FavoriteBrands [favoriteBrandId=" + favoriteBrandId + ", brandId=" + brandId + ", isLocal=" + isLocal + ", actv=" + actv + ", userId=" + userId + "]";
	}

	public static FavoriteBrands fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, FavoriteBrands.class );
	}
	public FavoriteBrandsDTO toDTO() {
		return new FavoriteBrandsDTO(this.getFavoriteBrandId(),this.getBrandId(),this.getIsLocal(),this.getActv(),this.getUserId());
	}
}
