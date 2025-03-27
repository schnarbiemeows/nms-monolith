package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.GroupsHist;

import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class GroupsHistDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer grpHistId;

	/**
	 * "fk to groups.grp_id field" 
	 */
	private Integer grpId;

	/**
	 * "brief name of the group" 
	 */
	private String grpName;

	/**
	 * "group or membership type description" 
	 */
	private String grpDesc;

	/**
	 * "what action was performed on this record?" 
	 */
	private Integer actionTypeId;

	/**
	 * "when did this action happen?" 
	 */
	private Date evntTmestmp;

	/**
	 * "who did this action?&!@ fk to the users.user_id field" 
	 */
	private Integer evntOperId;

	/**
	 * default constructor
	 */
	public GroupsHistDTO() {
		super();
	}

	public GroupsHistDTO(Integer grpHistId, Integer grpId, String grpName, String grpDesc, Integer actionTypeId, Date evntTmestmp, Integer evntOperId) {
		super();
		this.grpHistId = grpHistId;
		this.grpId = grpId;
		this.grpName = grpName;
		this.grpDesc = grpDesc;
		this.actionTypeId = actionTypeId;
		this.evntTmestmp = evntTmestmp;
		this.evntOperId = evntOperId;
	}

	public Integer getGrpHistId() {
		return grpHistId;
	}

	public void setGrpHistId(Integer grpHistId) {
		this.grpHistId=grpHistId;
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

	public Integer getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(Integer actionTypeId) {
		this.actionTypeId=actionTypeId;
	}

	public Date getEvntTmestmp() {
		return evntTmestmp;
	}

	public void setEvntTmestmp(Date evntTmestmp) {
		this.evntTmestmp=evntTmestmp;
	}

	public Integer getEvntOperId() {
		return evntOperId;
	}

	public void setEvntOperId(Integer evntOperId) {
		this.evntOperId=evntOperId;
	}

	@Override
	public String toString() {
		return "GroupsHistDTO [grpHistId=" + grpHistId + ", grpId=" + grpId + ", grpName=" + grpName + ", grpDesc=" + grpDesc + ", actionTypeId=" + actionTypeId + ", evntTmestmp=" + evntTmestmp + ", evntOperId=" + evntOperId + "]";
	}

	public static GroupsHistDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GroupsHistDTO.class );
	}
	public GroupsHist toEntity() {
		return new GroupsHist(this.getGrpHistId(),this.getGrpId(),this.getGrpName(),this.getGrpDesc(),this.getActionTypeId(),this.getEvntTmestmp(),this.getEvntOperId());
	}
}
