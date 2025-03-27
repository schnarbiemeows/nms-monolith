package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Roles;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class RolesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
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
	 * "fk to the action_type.action_type_id field" 
	 */
	private Integer actionTypeId;

	/**
	 * default constructor
	 */
	public RolesDTO() {
		super();
	}

	public RolesDTO(Integer roleId, Integer grpId, Integer rsrcId, Integer actionTypeId) {
		super();
		this.roleId = roleId;
		this.grpId = grpId;
		this.rsrcId = rsrcId;
		this.actionTypeId = actionTypeId;
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

	@Override
	public String toString() {
		return "RolesDTO [roleId=" + roleId + ", grpId=" + grpId + ", rsrcId=" + rsrcId + ", actionTypeId=" + actionTypeId + "]";
	}

	public static RolesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RolesDTO.class );
	}
	public Roles toEntity() {
		return new Roles(this.getRoleId(),this.getGrpId(),this.getRsrcId(),this.getActionTypeId());
	}
}
