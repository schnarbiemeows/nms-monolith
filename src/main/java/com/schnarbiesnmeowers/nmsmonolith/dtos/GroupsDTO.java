package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.Groups;
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
public class GroupsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer grpId;

	/**
	 * "brief name of the group" 
	 */
	private String grpName;

	/**
	 * "group or membership type description") 
	 */
	private String grpDesc;

	/**
	 * default constructor
	 */
	public GroupsDTO() {
		super();
	}

	public GroupsDTO(Integer grpId, String grpName, String grpDesc) {
		super();
		this.grpId = grpId;
		this.grpName = grpName;
		this.grpDesc = grpDesc;
	}

	public Integer getGrpId() {
		return grpId;
	}

	public void setGrpId(Integer grpId) {
		this.grpId=grpId;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName=grpName;
	}

	public String getGrpDesc() {
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc=grpDesc;
	}

	@Override
	public String toString() {
		return "GroupsDTO [grpId=" + grpId + ", grpName=" + grpName + ", grpDesc=" + grpDesc + "]";
	}

	public static GroupsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GroupsDTO.class );
	}
	public Groups toEntity() {
		return new Groups(this.getGrpId(),this.getGrpName(),this.getGrpDesc());
	}
}
