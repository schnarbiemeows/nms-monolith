package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.GroupsDTO;
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
@Table(name = "groups")
public class Groups implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "grp_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer grpId;

	/**
	 * "brief name of the group" 
	 */
	@Column(name = "grp_name")
	private String grpName;

	/**
	 * "group or membership type description") 
	 */
	@Column(name = "grp_desc")
	private String grpDesc;

	/**
	 * default constructor
	 */
	public Groups() {
		super();
	}

	public Groups(Integer grpId, String grpName, String grpDesc) {
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
		return "Groups [grpId=" + grpId + ", grpName=" + grpName + ", grpDesc=" + grpDesc + "]";
	}

	public static Groups fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Groups.class );
	}
	public GroupsDTO toDTO() {
		return new GroupsDTO(this.getGrpId(),this.getGrpName(),this.getGrpDesc());
	}
}
