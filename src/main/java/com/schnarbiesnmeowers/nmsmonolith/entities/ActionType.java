package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ActionTypeDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "action_type")
public class ActionType implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "action_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer actionTypeId;

	/**
	 * "action type code" 
	 */
	@Column(name = "action_type_cde")
	private String actionTypeCde;

	/**
	 * "action description" 
	 */
	@Column(name = "action_type_desc")
	private String actionTypeDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public ActionType() {
		super();
	}

	public ActionType(Integer actionTypeId, String actionTypeCde, String actionTypeDesc, String actv) {
		super();
		this.actionTypeId = actionTypeId;
		this.actionTypeCde = actionTypeCde;
		this.actionTypeDesc = actionTypeDesc;
		this.actv = actv;
	}

	public Integer getActionTypeId() {
		return actionTypeId;
	}

	public void setActionTypeId(Integer actionTypeId) {
		this.actionTypeId=actionTypeId;
	}

	public String getActionTypeCde() {
		return actionTypeCde;
	}

	public void setActionTypeCde(String actionTypeCde) {
		this.actionTypeCde=actionTypeCde;
	}

	public String getActionTypeDesc() {
		return actionTypeDesc;
	}

	public void setActionTypeDesc(String actionTypeDesc) {
		this.actionTypeDesc=actionTypeDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "ActionType [actionTypeId=" + actionTypeId + ", actionTypeCde=" + actionTypeCde + ", actionTypeDesc=" + actionTypeDesc + ", actv=" + actv + "]";
	}

	public static ActionType fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ActionType.class );
	}
	public ActionTypeDTO toDTO() {
		return new ActionTypeDTO(this.getActionTypeId(),this.getActionTypeCde(),this.getActionTypeDesc(),this.getActv());
	}
}
