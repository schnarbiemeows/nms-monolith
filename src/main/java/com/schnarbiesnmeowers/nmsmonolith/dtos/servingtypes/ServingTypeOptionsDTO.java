package com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes;

import com.schnarbiesnmeowers.nmsmonolith.entities.ServingTypeOptions;
import jakarta.validation.constraints.*;
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
public class ServingTypeOptionsDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer servTypeOptId;

	/**
	 * 
	 */
	private Integer servTypeId;

	/**
	 * 
	 */
	private Integer menuOption;

	/**
	 * default constructor
	 */
	public ServingTypeOptionsDTO() {
		super();
	}

	public ServingTypeOptionsDTO(Integer servTypeOptId, Integer servTypeId, Integer menuOption) {
		super();
		this.servTypeOptId = servTypeOptId;
		this.servTypeId = servTypeId;
		this.menuOption = menuOption;
	}

	public Integer getServTypeOptId() {
		return servTypeOptId;
	}

	public void setServTypeOptId(Integer servTypeOptId) {
		this.servTypeOptId=servTypeOptId;
	}

	public Integer getServTypeId() {
		return servTypeId;
	}

	public void setServTypeId(Integer servTypeId) {
		this.servTypeId=servTypeId;
	}

	public Integer getMenuOption() {
		return menuOption;
	}

	public void setMenuOption(Integer menuOption) {
		this.menuOption=menuOption;
	}

	@Override
	public String toString() {
		return "ServingTypeOptionsDTO [servTypeOptId=" + servTypeOptId + ", servTypeId=" + servTypeId + ", menuOption=" + menuOption + "]";
	}

	public static ServingTypeOptionsDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ServingTypeOptionsDTO.class );
	}
	public ServingTypeOptions toEntity() {
		return new ServingTypeOptions(this.getServTypeOptId(),this.getServTypeId(),this.getMenuOption());
	}
}
