package com.schnarbiesnmeowers.nmsmonolith.dtos;

import com.schnarbiesnmeowers.nmsmonolith.entities.PeriodType;

import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class PeriodTypeDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer periodTypeId;

	/**
	 * "o(one-time)&!@y(yearly)&!@q(quarterly)&!@s(semi-yearly)&!@m(monthly)&!@w(weekly)&!@d(daily)&!@2(twice a day)&!@4(4 times a day)&!@h(hourly)" 
	 */
	private String periodTypeCde;

	/**
	 * "description of the period_type_cde") 
	 */
	private String periodTypeDesc;

	/**
	 * default constructor
	 */
	public PeriodTypeDTO() {
		super();
	}

	public PeriodTypeDTO(Integer periodTypeId, String periodTypeCde, String periodTypeDesc) {
		super();
		this.periodTypeId = periodTypeId;
		this.periodTypeCde = periodTypeCde;
		this.periodTypeDesc = periodTypeDesc;
	}

	public Integer getPeriodTypeId() {
		return periodTypeId;
	}

	public void setPeriodTypeId(Integer periodTypeId) {
		this.periodTypeId=periodTypeId;
	}

	public String getPeriodTypeCde() {
		return periodTypeCde;
	}

	public void setPeriodTypeCde(String periodTypeCde) {
		this.periodTypeCde=periodTypeCde;
	}

	public String getPeriodTypeDesc() {
		return periodTypeDesc;
	}

	public void setPeriodTypeDesc(String periodTypeDesc) {
		this.periodTypeDesc=periodTypeDesc;
	}

	@Override
	public String toString() {
		return "PeriodTypeDTO [periodTypeId=" + periodTypeId + ", periodTypeCde=" + periodTypeCde + ", periodTypeDesc=" + periodTypeDesc + "]";
	}

	public static PeriodTypeDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PeriodTypeDTO.class );
	}
	public PeriodType toEntity() {
		return new PeriodType(this.getPeriodTypeId(),this.getPeriodTypeCde(),this.getPeriodTypeDesc());
	}
}
