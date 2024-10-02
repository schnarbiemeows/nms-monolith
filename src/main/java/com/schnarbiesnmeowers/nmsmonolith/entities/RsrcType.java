package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RsrcTypeDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "rsrc_type")
public class RsrcType implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "rsrc_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rsrcTypeId;

	/**
	 * "resource type code" 
	 */
	@Column(name = "rsrc_type")
	private String rsrcType;

	/**
	 * "resource type description" 
	 */
	@Column(name = "rsrc_type_desc")
	private String rsrcTypeDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public RsrcType() {
		super();
	}

	public RsrcType(Integer rsrcTypeId, String rsrcType, String rsrcTypeDesc, String actv) {
		super();
		this.rsrcTypeId = rsrcTypeId;
		this.rsrcType = rsrcType;
		this.rsrcTypeDesc = rsrcTypeDesc;
		this.actv = actv;
	}

	public Integer getRsrcTypeId() {
		return rsrcTypeId;
	}

	public void setRsrcTypeId(Integer rsrcTypeId) {
		this.rsrcTypeId=rsrcTypeId;
	}

	public String getRsrcType() {
		return rsrcType;
	}

	public void setRsrcType(String rsrcType) {
		this.rsrcType=rsrcType;
	}

	public String getRsrcTypeDesc() {
		return rsrcTypeDesc;
	}

	public void setRsrcTypeDesc(String rsrcTypeDesc) {
		this.rsrcTypeDesc=rsrcTypeDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "RsrcType [rsrcTypeId=" + rsrcTypeId + ", rsrcType=" + rsrcType + ", rsrcTypeDesc=" + rsrcTypeDesc + ", actv=" + actv + "]";
	}

	public static RsrcType fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RsrcType.class );
	}
	public RsrcTypeDTO toDTO() {
		return new RsrcTypeDTO(this.getRsrcTypeId(),this.getRsrcType(),this.getRsrcTypeDesc(),this.getActv());
	}
}
