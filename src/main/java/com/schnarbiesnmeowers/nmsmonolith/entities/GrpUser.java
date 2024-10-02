package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GrpUserDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "grp_user")
public class GrpUser implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "grp_user_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	 * default constructor
	 */
	public GrpUser() {
		super();
	}

	public GrpUser(Integer grpUserId, Integer grpId, Integer userId) {
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
		return "GrpUser [grpUserId=" + grpUserId + ", grpId=" + grpId + ", userId=" + userId + "]";
	}

	public static GrpUser fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, GrpUser.class );
	}
	public GrpUserDTO toDTO() {
		return new GrpUserDTO(this.getGrpUserId(),this.getGrpId(),this.getUserId());
	}
}
