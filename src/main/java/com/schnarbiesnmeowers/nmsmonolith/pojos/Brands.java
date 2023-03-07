package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.brands.BrandsDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "brands")
public class Brands implements Serializable {
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
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public Brands() {
		super();
	}

	public Brands(Integer brandId, String brandType, String brandName, Integer imageLoc, String actv) {
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
		return "Brands [brandId=" + brandId + ", brandType=" + brandType + ", brandName=" + brandName + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static Brands fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Brands.class );
	}
	public BrandsDTO toDTO() {
		return new BrandsDTO(this.getBrandId(),this.getBrandType(),this.getBrandName(),this.getImageLoc(),this.getActv());
	}
}
