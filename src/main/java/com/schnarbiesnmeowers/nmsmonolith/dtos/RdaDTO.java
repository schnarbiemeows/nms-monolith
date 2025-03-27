package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.Rda;

import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class RdaDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer rdaId;

	/**
	 * "name of the recommended daily allowance" 
	 */
	private String rdaName;

	/**
	 * "the amount of grams or milligrams per day" 
	 */
	private BigDecimal rdaValue;

	/**
	 * "fk to the user.user_id field" 
	 */
	private Integer userId;

	/**
	 * "is this record active(y or n)?") 
	 */
	private String actv;

	/**
	 * default constructor
	 */
	public RdaDTO() {
		super();
	}

	public RdaDTO(Integer rdaId, String rdaName, BigDecimal rdaValue, Integer userId, String actv) {
		super();
		this.rdaId = rdaId;
		this.rdaName = rdaName;
		this.rdaValue = rdaValue;
		this.userId = userId;
		this.actv = actv;
	}

	public Integer getRdaId() {
		return rdaId;
	}

	public void setRdaId(Integer rdaId) {
		this.rdaId=rdaId;
	}

	public String getRdaName() {
		return rdaName;
	}

	public void setRdaName(String rdaName) {
		this.rdaName=rdaName;
	}

	public BigDecimal getRdaValue() {
		return rdaValue;
	}

	public void setRdaValue(BigDecimal rdaValue) {
		this.rdaValue=rdaValue;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "RdaDTO [rdaId=" + rdaId + ", rdaName=" + rdaName + ", rdaValue=" + rdaValue + ", userId=" + userId + ", actv=" + actv + "]";
	}

	public static RdaDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RdaDTO.class );
	}
	public Rda toEntity() {
		return new Rda(this.getRdaId(),this.getRdaName(),this.getRdaValue(),this.getUserId(),this.getActv());
	}
}
