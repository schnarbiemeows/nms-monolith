package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.GrpUser;
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
public class GrpUserDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
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
	 * default constructor
	 */
	public GrpUserDTO() {
		super();
	}

	public GrpUserDTO(Integer grpUserId, Integer grpId, Integer userId) {
		super();
		this.grpUserId = grpUserId;
		this.grpId = grpId;
		this.userId = userId;
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

	@Override
	public String toString() {
		return "GrpUserDTO [grpUserId=" + grpUserId + ", grpId=" + grpId + ", userId=" + userId + "]";
	}

	public static GrpUserDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GrpUserDTO.class );
	}
	public GrpUser toEntity() {
		return new GrpUser(this.getGrpUserId(),this.getGrpId(),this.getUserId());
	}
}
