package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.pojos.ActionType;
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
public class ActionTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer actionTypeId;

	/**
	 * "action type code" 
	 */
	private String actionTypeCde;

	/**
	 * "action description" 
	 */
	private String actionTypeDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public ActionTypeDTO() {
		super();
	}

	public ActionTypeDTO(Integer actionTypeId, String actionTypeCde, String actionTypeDesc, String actv) {
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
		return "ActionTypeDTO [actionTypeId=" + actionTypeId + ", actionTypeCde=" + actionTypeCde + ", actionTypeDesc=" + actionTypeDesc + ", actv=" + actv + "]";
	}

	public static ActionTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ActionTypeDTO.class );
	}
	public ActionType toEntity() {
		return new ActionType(this.getActionTypeId(),this.getActionTypeCde(),this.getActionTypeDesc(),this.getActv());
	}
}
