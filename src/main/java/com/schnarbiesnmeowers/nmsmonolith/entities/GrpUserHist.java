package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserHistDTO;
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
@Table(name = "grp_user_hist")
public class GrpUserHist implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "grp_user_hist_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer grpUserHistId;

	/**
	 * "fk to the grp_user.grp_user_id field" 
	 */
	@Column(name = "grp_user_id")
	private Integer grpUserId;

	/**
	 * "fk to the groups.grp_id field" 
	 */
	@Column(name = "grp_id")
	private Integer grpId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

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
	public GrpUserHist() {
		super();
	}

	public GrpUserHist(Integer grpUserHistId, Integer grpUserId, Integer grpId, Integer userId, Integer actionTypeId, Date evntTmestmp, Integer evntOperId) {
		super();
		this.grpUserHistId = grpUserHistId;
		this.grpUserId = grpUserId;
		this.grpId = grpId;
		this.userId = userId;
		this.actionTypeId = actionTypeId;
		this.evntTmestmp = evntTmestmp;
		this.evntOperId = evntOperId;
	}

	public Integer getGrpUserHistId() {
		return grpUserHistId;
	}

	public void setGrpUserHistId(Integer grpUserHistId) {
		this.grpUserHistId=grpUserHistId;
	}

	public Integer getGrpUserId() {
		return grpUserId;
	}

	public void setGrpUserId(Integer grpUserId) {
		this.grpUserId=grpUserId;
	}

	public Integer getGrpId() {
		return grpId;
	}

	public void setGrpId(Integer grpId) {
		this.grpId=grpId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
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
		return "GrpUserHist [grpUserHistId=" + grpUserHistId + ", grpUserId=" + grpUserId + ", grpId=" + grpId + ", userId=" + userId + ", actionTypeId=" + actionTypeId + ", evntTmestmp=" + evntTmestmp + ", evntOperId=" + evntOperId + "]";
	}

	public static GrpUserHist fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GrpUserHist.class );
	}
	public GrpUserHistDTO toDTO() {
		return new GrpUserHistDTO(this.getGrpUserHistId(),this.getGrpUserId(),this.getGrpId(),this.getUserId(),this.getActionTypeId(),this.getEvntTmestmp(),this.getEvntOperId());
	}
}
