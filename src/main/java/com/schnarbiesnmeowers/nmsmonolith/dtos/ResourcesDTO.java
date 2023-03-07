package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Resources;
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
public class ResourcesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer rsrcId;

	/**
	 * "fk to the rsrc_type.rsrc_type_id field" 
	 */
	private Integer rsrcTypeId;

	/**
	 * "description of the resource" 
	 */
	private String rsrcDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public ResourcesDTO() {
		super();
	}

	public ResourcesDTO(Integer rsrcId, Integer rsrcTypeId, String rsrcDesc, String actv) {
		super();
		this.rsrcId = rsrcId;
		this.rsrcTypeId = rsrcTypeId;
		this.rsrcDesc = rsrcDesc;
		this.actv = actv;
	}

	public Integer getRsrcId() {
		return rsrcId;
	}

	public void setRsrcId(Integer rsrcId) {
		this.rsrcId=rsrcId;
	}

	public Integer getRsrcTypeId() {
		return rsrcTypeId;
	}

	public void setRsrcTypeId(Integer rsrcTypeId) {
		this.rsrcTypeId=rsrcTypeId;
	}

	public String getRsrcDesc() {
		return rsrcDesc;
	}

	public void setRsrcDesc(String rsrcDesc) {
		this.rsrcDesc=rsrcDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "ResourcesDTO [rsrcId=" + rsrcId + ", rsrcTypeId=" + rsrcTypeId + ", rsrcDesc=" + rsrcDesc + ", actv=" + actv + "]";
	}

	public static ResourcesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ResourcesDTO.class );
	}
	public Resources toEntity() {
		return new Resources(this.getRsrcId(),this.getRsrcTypeId(),this.getRsrcDesc(),this.getActv());
	}
}
