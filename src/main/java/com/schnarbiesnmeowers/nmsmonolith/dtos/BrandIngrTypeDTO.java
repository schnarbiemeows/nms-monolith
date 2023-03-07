package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.BrandIngrType;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class BrandIngrTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer brandIngrTypeId;

	/**
	 * 
	 */
	private Integer brandId;

	/**
	 * 
	 */
	private Integer ingrTypeId;

	/**
	 * 
	 */
	private Integer prntIngrType;

	/**
	 * default constructor
	 */
	public BrandIngrTypeDTO() {
		super();
	}

	public BrandIngrTypeDTO(Integer brandIngrTypeId, Integer brandId, Integer ingrTypeId, Integer prntIngrType) {
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
		return "BrandIngrTypeDTO [brandIngrTypeId=" + brandIngrTypeId + ", brandId=" + brandId + ", ingrTypeId=" + ingrTypeId + ", prntIngrType=" + prntIngrType + "]";
	}

	public static BrandIngrTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, BrandIngrTypeDTO.class );
	}
	public BrandIngrType toEntity() {
		return new BrandIngrType(this.getBrandIngrTypeId(),this.getBrandId(),this.getIngrTypeId(),this.getPrntIngrType());
	}
}
