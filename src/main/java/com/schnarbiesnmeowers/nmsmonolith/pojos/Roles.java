package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RolesDTO;
import javax.persistence.*;
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
@Entity
@Table(name = "roles")
public class Roles implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "role_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer roleId;

	/**
	 * "fk to the groups.grp_id field" 
	 */
	@Column(name = "grp_id")
	private Integer grpId;

	/**
	 * "fk to the resources.rsrc_id field" 
	 */
	@Column(name = "rsrc_id")
	private Integer rsrcId;

	/**
	 * "fk to the action_type.action_type_id field" 
	 */
	@Column(name = "action_type_id")
	private Integer actionTypeId;

	/**
	 * default constructor
	 */
	public Roles() {
		super();
	}

	public Roles(Integer roleId, Integer grpId, Integer rsrcId, Integer actionTypeId) {
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
		return "Roles [roleId=" + roleId + ", grpId=" + grpId + ", rsrcId=" + rsrcId + ", actionTypeId=" + actionTypeId + "]";
	}

	public static Roles fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Roles.class );
	}
	public RolesDTO toDTO() {
		return new RolesDTO(this.getRoleId(),this.getGrpId(),this.getRsrcId(),this.getActionTypeId());
	}
}
