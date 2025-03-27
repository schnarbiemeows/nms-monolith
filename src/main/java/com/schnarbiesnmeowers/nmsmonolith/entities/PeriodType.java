package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.PeriodTypeDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "period_type")
public class PeriodType implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "period_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer periodTypeId;

	/**
	 * "o(one-time)&!@y(yearly)&!@q(quarterly)&!@s(semi-yearly)&!@m(monthly)&!@w(weekly)&!@d(daily)&!@2(twice a day)&!@4(4 times a day)&!@h(hourly)" 
	 */
	@Column(name = "period_type_cde")
	private String periodTypeCde;

	/**
	 * "description of the period_type_cde") 
	 */
	@Column(name = "period_type_desc")
	private String periodTypeDesc;

	/**
	 * default constructor
	 */
	public PeriodType() {
		super();
	}

	public PeriodType(Integer periodTypeId, String periodTypeCde, String periodTypeDesc) {
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
		return "PeriodType [periodTypeId=" + periodTypeId + ", periodTypeCde=" + periodTypeCde + ", periodTypeDesc=" + periodTypeDesc + "]";
	}

	public static PeriodType fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, PeriodType.class );
	}
	public PeriodTypeDTO toDTO() {
		return new PeriodTypeDTO(this.getPeriodTypeId(),this.getPeriodTypeCde(),this.getPeriodTypeDesc());
	}
}
