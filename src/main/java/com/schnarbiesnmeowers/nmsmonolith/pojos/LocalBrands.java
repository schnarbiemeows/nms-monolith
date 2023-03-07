package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.LocalBrandsDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "local_brands")
public class LocalBrands implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "brand_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer brandId;

	/**
	 * "brand type(n = name&!@ g = generic&!@ s = store)"
	 */
	@Column(name = "brand_type")
	private String brandType;

	/**
	 * "name of the brand" 
	 */
	@Column(name = "brand_name")
	private String brandName;

	/**
	 * "fk to the image_loc.image_loc_id field"
	 */
	@Column(name = "image_loc")
	private Integer imageLoc;

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
	public LocalBrands() {
		super();
	}

	public LocalBrands(Integer brandId, String brandType, String brandName,
					   Integer imageLoc, String actv, Integer userId) {
		this.brandId = brandId;
		this.brandType = brandType;
		this.brandName = brandName;
		this.imageLoc = imageLoc;
		this.actv = actv;
		this.userId = userId;
	}

	public String getBrandType() {
		return brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId=brandId;
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
		this.imageLoc = imageLoc;
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
		return "LocalBrands{" +
				"brandId=" + brandId +
				", brandType='" + brandType + '\'' +
				", brandName='" + brandName + '\'' +
				", imageLoc=" + imageLoc +
				", actv='" + actv + '\'' +
				", userId=" + userId +
				'}';
	}

	public static LocalBrands fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalBrands.class );
	}
	public LocalBrandsDTO toDTO() {
		return new LocalBrandsDTO(this.getBrandId(),this.getBrandType(),this.getBrandName(),this.getImageLoc(),this.getActv(),this.getUserId());
	}
}
