package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.UserConfig;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class UserConfigDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer usersConfigId;

	/**
	 * "fk to the users.user_id field" 
	 */
	private Integer userId;

	/**
	 * "name of the property" 
	 */
	private String propertyKey;

	/**
	 * "value of the property") 
	 */
	private String propertyValue;

	/**
	 * default constructor
	 */
	public UserConfigDTO() {
		super();
	}

	public UserConfigDTO(Integer usersConfigId, Integer userId, String propertyKey, String propertyValue) {
		super();
		this.usersConfigId = usersConfigId;
		this.userId = userId;
		this.propertyKey = propertyKey;
		this.propertyValue = propertyValue;
	}

	public Integer getUsersConfigId() {
		return usersConfigId;
	}

	public void setUsersConfigId(Integer usersConfigId) {
		this.usersConfigId=usersConfigId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public String getPropertyKey() {
		return propertyKey;
	}

	public void setPropertyKey(String propertyKey) {
		this.propertyKey=propertyKey;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue=propertyValue;
	}

	@Override
	public String toString() {
		return "UserConfigDTO [usersConfigId=" + usersConfigId + ", userId=" + userId + ", propertyKey=" + propertyKey + ", propertyValue=" + propertyValue + "]";
	}

	public static UserConfigDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UserConfigDTO.class );
	}
	public UserConfig toEntity() {
		return new UserConfig(this.getUsersConfigId(),this.getUserId(),this.getPropertyKey(),this.getPropertyValue());
	}
}
