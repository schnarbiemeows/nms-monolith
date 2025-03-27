package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsHistDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

import java.util.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "groups_hist")
public class GroupsHist implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "grp_hist_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer grpHistId;

	/**
	 * "fk to groups.grp_id field" 
	 */
	@Column(name = "grp_id")
	private Integer grpId;

	/**
	 * "brief name of the group" 
	 */
	@Column(name = "grp_name")
	private String grpName;

	/**
	 * "group or membership type description" 
	 */
	@Column(name = "grp_desc")
	private String grpDesc;

	/**
	 * "what action was performed on this record?" 
	 */
	@Column(name = "action_type_id")
	private Integer actionTypeId;

	/**
	 * "when did this action happen?" 
	 */
	@Column(name = "evnt_tmestmp")
	private Date evntTmestmp;

	/**
	 * "who did this action?&!@ fk to the users.user_id field" 
	 */
	@Column(name = "evnt_oper_id")
	private Integer evntOperId;

	/**
	 * default constructor
	 */
	public GroupsHist() {
		super();
	}

	public GroupsHist(Integer grpHistId, Integer grpId, String grpName, String grpDesc, Integer actionTypeId, Date evntTmestmp, Integer evntOperId) {
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
		return "GroupsHist [grpHistId=" + grpHistId + ", grpId=" + grpId + ", grpName=" + grpName + ", grpDesc=" + grpDesc + ", actionTypeId=" + actionTypeId + ", evntTmestmp=" + evntTmestmp + ", evntOperId=" + evntOperId + "]";
	}

	public static GroupsHist fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GroupsHist.class );
	}
	public GroupsHistDTO toDTO() {
		return new GroupsHistDTO(this.getGrpHistId(),this.getGrpId(),this.getGrpName(),this.getGrpDesc(),this.getActionTypeId(),this.getEvntTmestmp(),this.getEvntOperId());
	}
}
