package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.RolesHist;

import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class RolesHistDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer roleHistId;

	/**
	 * "fk to the roles.role_id field" 
	 */
	private Integer roleId;

	/**
	 * "fk to the groups.grp_id field" 
	 */
	private Integer grpId;

	/**
	 * "fk to the resources.rsrc_id field" 
	 */
	private Integer rsrcId;

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
	public RolesHistDTO() {
		super();
	}

	public RolesHistDTO(Integer roleHistId, Integer roleId, Integer grpId, Integer rsrcId, Integer actionTypeId, Date evntTmestmp, Integer evntOperId) {
		super();
		this.roleHistId = roleHistId;
		this.roleId = roleId;
		this.grpId = grpId;
		this.rsrcId = rsrcId;
		this.actionTypeId = actionTypeId;
		this.evntTmestmp = evntTmestmp;
		this.evntOperId = evntOperId;
	}

	public Integer getRoleHistId() {
		return roleHistId;
	}

	public void setRoleHistId(Integer roleHistId) {
		this.roleHistId=roleHistId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId=roleId;
	}

	public Integer getGrpId() {
		return grpId;
	}

	public void setGrpId(Integer grpId) {
		this.grpId=grpId;
	}

	public Integer getRsrcId() {
		return rsrcId;
	}

	public void setRsrcId(Integer rsrcId) {
		this.rsrcId=rsrcId;
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
		return "RolesHistDTO [roleHistId=" + roleHistId + ", roleId=" + roleId + ", grpId=" + grpId + ", rsrcId=" + rsrcId + ", actionTypeId=" + actionTypeId + ", evntTmestmp=" + evntTmestmp + ", evntOperId=" + evntOperId + "]";
	}

	public static RolesHistDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RolesHistDTO.class );
	}
	public RolesHist toEntity() {
		return new RolesHist(this.getRoleHistId(),this.getRoleId(),this.getGrpId(),this.getRsrcId(),this.getActionTypeId(),this.getEvntTmestmp(),this.getEvntOperId());
	}
}
