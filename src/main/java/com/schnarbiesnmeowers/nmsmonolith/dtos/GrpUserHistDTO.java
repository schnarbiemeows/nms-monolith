package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.GrpUserHist;
import javax.validation.constraints.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
public class GrpUserHistDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer grpUserHistId;

	/**
	 * "fk to the grp_user.grp_user_id field" 
	 */
	private Integer grpUserId;

	/**
	 * "fk to the groups.grp_id field" 
	 */
	private Integer grpId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

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
	public GrpUserHistDTO() {
		super();
	}

	public GrpUserHistDTO(Integer grpUserHistId, Integer grpUserId, Integer grpId, Integer userId, Integer actionTypeId, Date evntTmestmp, Integer evntOperId) {
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
		return "GrpUserHistDTO [grpUserHistId=" + grpUserHistId + ", grpUserId=" + grpUserId + ", grpId=" + grpId + ", userId=" + userId + ", actionTypeId=" + actionTypeId + ", evntTmestmp=" + evntTmestmp + ", evntOperId=" + evntOperId + "]";
	}

	public static GrpUserHistDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GrpUserHistDTO.class );
	}
	public GrpUserHist toEntity() {
		return new GrpUserHist(this.getGrpUserHistId(),this.getGrpUserId(),this.getGrpId(),this.getUserId(),this.getActionTypeId(),this.getEvntTmestmp(),this.getEvntOperId());
	}
}
