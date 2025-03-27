package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeOptionsDTO;
import jakarta.persistence.*;
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
@Table(name = "serving_type_options")
public class ServingTypeOptions implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "serv_type_opt_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer servTypeOptId;

	/**
	 * 
	 */
	@Column(name = "serv_type_id")
	private Integer servTypeId;

	/**
	 * 
	 */
	@Column(name = "menu_option")
	private Integer menuOption;

	/**
	 * default constructor
	 */
	public ServingTypeOptions() {
		super();
	}

	public ServingTypeOptions(Integer servTypeOptId, Integer servTypeId, Integer menuOption) {
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
		return "ServingTypeOptions [servTypeOptId=" + servTypeOptId + ", servTypeId=" + servTypeId + ", menuOption=" + menuOption + "]";
	}

	public static ServingTypeOptions fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ServingTypeOptions.class );
	}
	public ServingTypeOptionsDTO toDTO() {
		return new ServingTypeOptionsDTO(this.getServTypeOptId(),this.getServTypeId(),this.getMenuOption());
	}
}
