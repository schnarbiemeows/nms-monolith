package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.RecEqType;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class RecEqTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer recEqTypeId;

	/**
	 * "short code for equipment type (app = applicance&!@ etc...)" 
	 */
	private String recEqCde;

	/**
	 * "short description of the equipment type" 
	 */
	private String recEqDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public RecEqTypeDTO() {
		super();
	}

	public RecEqTypeDTO(Integer recEqTypeId, String recEqCde, String recEqDesc, String actv) {
		super();
		this.recEqTypeId = recEqTypeId;
		this.recEqCde = recEqCde;
		this.recEqDesc = recEqDesc;
		this.actv = actv;
	}

	public Integer getRecEqTypeId() {
		return recEqTypeId;
	}

	public void setRecEqTypeId(Integer recEqTypeId) {
		this.recEqTypeId=recEqTypeId;
	}

	public String getRecEqCde() {
		return recEqCde;
	}

	public void setRecEqCde(String recEqCde) {
		this.recEqCde=recEqCde;
	}

	public String getRecEqDesc() {
		return recEqDesc;
	}

	public void setRecEqDesc(String recEqDesc) {
		this.recEqDesc=recEqDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "RecEqTypeDTO [recEqTypeId=" + recEqTypeId + ", recEqCde=" + recEqCde + ", recEqDesc=" + recEqDesc + ", actv=" + actv + "]";
	}

	public static RecEqTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecEqTypeDTO.class );
	}
	public RecEqType toEntity() {
		return new RecEqType(this.getRecEqTypeId(),this.getRecEqCde(),this.getRecEqDesc(),this.getActv());
	}
}
