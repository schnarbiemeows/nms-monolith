package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.servingtypes.ServingTypeRatiosDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;
import java.math.*;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "serving_type_ratios")
public class ServingTypeRatios implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "serv_type_ratio_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer servTypeRatioId;

	/**
	 * 
	 */
	@Column(name = "serv_type_id_1")
	private Integer servTypeId1;

	/**
	 * 
	 */
	@Column(name = "serv_type_id_2")
	private Integer servTypeId2;

	/**
	 * "conversion factor from serv_type_id_1 to serv_type_id_2") 
	 */
	@Column(name = "ratio")
	private BigDecimal ratio;

	/**
	 * default constructor
	 */
	public ServingTypeRatios() {
		super();
	}

	public ServingTypeRatios(Integer servTypeRatioId, Integer servTypeId1, Integer servTypeId2, BigDecimal ratio) {
		super();
		this.servTypeRatioId = servTypeRatioId;
		this.servTypeId1 = servTypeId1;
		this.servTypeId2 = servTypeId2;
		this.ratio = ratio;
	}

	public Integer getServTypeRatioId() {
		return servTypeRatioId;
	}

	public void setServTypeRatioId(Integer servTypeRatioId) {
		this.servTypeRatioId=servTypeRatioId;
	}

	public Integer getServTypeId1() {
		return servTypeId1;
	}

	public void setServTypeId1(Integer servTypeId1) {
		this.servTypeId1=servTypeId1;
	}

	public Integer getServTypeId2() {
		return servTypeId2;
	}

	public void setServTypeId2(Integer servTypeId2) {
		this.servTypeId2=servTypeId2;
	}

	public BigDecimal getRatio() {
		return ratio;
	}

	public void setRatio(BigDecimal ratio) {
		this.ratio=ratio;
	}

	@Override
	public String toString() {
		return "ServingTypeRatios [servTypeRatioId=" + servTypeRatioId + ", servTypeId1=" + servTypeId1 + ", servTypeId2=" + servTypeId2 + ", ratio=" + ratio + "]";
	}

	public static ServingTypeRatios fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, ServingTypeRatios.class );
	}
	public ServingTypeRatiosDTO toDTO() {
		return new ServingTypeRatiosDTO(this.getServTypeRatioId(),this.getServTypeId1(),this.getServTypeId2(),this.getRatio());
	}
}
