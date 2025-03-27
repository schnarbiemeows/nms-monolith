package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.BrandIngrTypeDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "brand_ingr_type")
public class BrandIngrType implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "brand_ingr_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer brandIngrTypeId;

	/**
	 * 
	 */
	@Column(name = "brand_id")
	private Integer brandId;

	/**
	 * 
	 */
	@Column(name = "ingr_type_id")
	private Integer ingrTypeId;

	/**
	 * 
	 */
	@Column(name = "prnt_ingr_type")
	private Integer prntIngrType;

	/**
	 * default constructor
	 */
	public BrandIngrType() {
		super();
	}

	public BrandIngrType(Integer brandIngrTypeId, Integer brandId, Integer ingrTypeId, Integer prntIngrType) {
		super();
		this.brandIngrTypeId = brandIngrTypeId;
		this.brandId = brandId;
		this.ingrTypeId = ingrTypeId;
		this.prntIngrType = prntIngrType;
	}

	public Integer getBrandIngrTypeId() {
		return brandIngrTypeId;
	}

	public void setBrandIngrTypeId(Integer brandIngrTypeId) {
		this.brandIngrTypeId=brandIngrTypeId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId=brandId;
	}

	public Integer getIngrTypeId() {
		return ingrTypeId;
	}

	public void setIngrTypeId(Integer ingrTypeId) {
		this.ingrTypeId=ingrTypeId;
	}

	public Integer getPrntIngrType() {
		return prntIngrType;
	}

	public void setPrntIngrType(Integer prntIngrType) {
		this.prntIngrType=prntIngrType;
	}

	@Override
	public String toString() {
		return "BrandIngrType [brandIngrTypeId=" + brandIngrTypeId + ", brandId=" + brandId + ", ingrTypeId=" + ingrTypeId + ", prntIngrType=" + prntIngrType + "]";
	}

	public static BrandIngrType fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, BrandIngrType.class );
	}
	public BrandIngrTypeDTO toDTO() {
		return new BrandIngrTypeDTO(this.getBrandIngrTypeId(),this.getBrandId(),this.getIngrTypeId(),this.getPrntIngrType());
	}
}
