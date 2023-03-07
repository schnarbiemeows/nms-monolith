package com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes;

import com.schnarbiesnmeowers.nmsmonolith.pojos.ServingTypes;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class ServingTypesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer servTypeId;

	/**
	 * "short code for the serving type" 
	 */
	private String servTypeCde;

	/**
	 * "longer description of the serving type" 
	 */
	private String servTypeDesc;

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
	public ServingTypesDTO() {
		super();
	}

	public ServingTypesDTO(Integer servTypeId, String servTypeCde, String servTypeDesc, Integer imageLoc, String actv) {
		super();
		this.servTypeId = servTypeId;
		this.servTypeCde = servTypeCde;
		this.servTypeDesc = servTypeDesc;
		this.imageLoc = imageLoc;
		this.actv = actv;
	}

	public Integer getServTypeId() {
		return servTypeId;
	}

	public void setServTypeId(Integer servTypeId) {
		this.servTypeId=servTypeId;
	}

	public String getServTypeCde() {
		return servTypeCde;
	}

	public void setServTypeCde(String servTypeCde) {
		this.servTypeCde=servTypeCde;
	}

	public String getServTypeDesc() {
		return servTypeDesc;
	}

	public void setServTypeDesc(String servTypeDesc) {
		this.servTypeDesc=servTypeDesc;
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
		return "ServingTypesDTO [servTypeId=" + servTypeId + ", servTypeCde=" + servTypeCde + ", servTypeDesc=" + servTypeDesc + ", imageLoc=" + imageLoc + ", actv=" + actv + "]";
	}

	public static ServingTypesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ServingTypesDTO.class );
	}
	public ServingTypes toEntity() {
		return new ServingTypes(this.getServTypeId(),this.getServTypeCde(),this.getServTypeDesc(),this.getImageLoc(),this.getActv());
	}
}
