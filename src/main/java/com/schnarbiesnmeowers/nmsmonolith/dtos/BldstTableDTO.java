package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.BldstTable;
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
public class BldstTableDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer bldstTableId;

	/**
	 * "b = breakfast&!@ l = lunch&!@ etc..." 
	 */
	private String bldstCde;

	/**
	 * "breakfast&!@lunch&!@ etc..." 
	 */
	private String bldstDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public BldstTableDTO() {
		super();
	}

	public BldstTableDTO(Integer bldstTableId, String bldstCde, String bldstDesc, String actv) {
		super();
		this.bldstTableId = bldstTableId;
		this.bldstCde = bldstCde;
		this.bldstDesc = bldstDesc;
		this.actv = actv;
	}

	public Integer getBldstTableId() {
		return bldstTableId;
	}

	public void setBldstTableId(Integer bldstTableId) {
		this.bldstTableId=bldstTableId;
	}

	public String getBldstCde() {
		return bldstCde;
	}

	public void setBldstCde(String bldstCde) {
		this.bldstCde=bldstCde;
	}

	public String getBldstDesc() {
		return bldstDesc;
	}

	public void setBldstDesc(String bldstDesc) {
		this.bldstDesc=bldstDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "BldstTableDTO [bldstTableId=" + bldstTableId + ", bldstCde=" + bldstCde + ", bldstDesc=" + bldstDesc + ", actv=" + actv + "]";
	}

	public static BldstTableDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, BldstTableDTO.class );
	}
	public BldstTable toEntity() {
		return new BldstTable(this.getBldstTableId(),this.getBldstCde(),this.getBldstDesc(),this.getActv());
	}
}
