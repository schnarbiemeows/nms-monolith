package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.RsrcType;
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
public class RsrcTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer rsrcTypeId;

	/**
	 * "resource type code" 
	 */
	private String rsrcType;

	/**
	 * "resource type description" 
	 */
	private String rsrcTypeDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public RsrcTypeDTO() {
		super();
	}

	public RsrcTypeDTO(Integer rsrcTypeId, String rsrcType, String rsrcTypeDesc, String actv) {
		super();
		this.rsrcTypeId = rsrcTypeId;
		this.rsrcType = rsrcType;
		this.rsrcTypeDesc = rsrcTypeDesc;
		this.actv = actv;
	}

	public Integer getRsrcTypeId() {
		return rsrcTypeId;
	}

	public void setRsrcTypeId(Integer rsrcTypeId) {
		this.rsrcTypeId=rsrcTypeId;
	}

	public String getRsrcType() {
		return rsrcType;
	}

	public void setRsrcType(String rsrcType) {
		this.rsrcType=rsrcType;
	}

	public String getRsrcTypeDesc() {
		return rsrcTypeDesc;
	}

	public void setRsrcTypeDesc(String rsrcTypeDesc) {
		this.rsrcTypeDesc=rsrcTypeDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "RsrcTypeDTO [rsrcTypeId=" + rsrcTypeId + ", rsrcType=" + rsrcType + ", rsrcTypeDesc=" + rsrcTypeDesc + ", actv=" + actv + "]";
	}

	public static RsrcTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RsrcTypeDTO.class );
	}
	public RsrcType toEntity() {
		return new RsrcType(this.getRsrcTypeId(),this.getRsrcType(),this.getRsrcTypeDesc(),this.getActv());
	}
}
