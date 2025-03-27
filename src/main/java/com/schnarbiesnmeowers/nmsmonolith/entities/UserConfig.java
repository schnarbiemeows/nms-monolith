package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.UserConfigDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "user_config")
public class UserConfig implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "users_config_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer usersConfigId;

	/**
	 * "fk to the users.user_id field" 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * "name of the property" 
	 */
	@Column(name = "property_key")
	private String propertyKey;

	/**
	 * "value of the property") 
	 */
	@Column(name = "property_value")
	private String propertyValue;

	/**
	 * default constructor
	 */
	public UserConfig() {
		super();
	}

	public UserConfig(Integer usersConfigId, Integer userId, String propertyKey, String propertyValue) {
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
		return "UserConfig [usersConfigId=" + usersConfigId + ", userId=" + userId + ", propertyKey=" + propertyKey + ", propertyValue=" + propertyValue + "]";
	}

	public static UserConfig fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, UserConfig.class );
	}
	public UserConfigDTO toDTO() {
		return new UserConfigDTO(this.getUsersConfigId(),this.getUserId(),this.getPropertyKey(),this.getPropertyValue());
	}
}
