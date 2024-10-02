package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.ResourcesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "resources")
public class Resources implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "rsrc_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rsrcId;

	/**
	 * "fk to the rsrc_type.rsrc_type_id field" 
	 */
	@Column(name = "rsrc_type_id")
	private Integer rsrcTypeId;

	/**
	 * "description of the resource" 
	 */
	@Column(name = "rsrc_desc")
	private String rsrcDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public Resources() {
		super();
	}

	public Resources(Integer rsrcId, Integer rsrcTypeId, String rsrcDesc, String actv) {
		super();
		this.rsrcId = rsrcId;
		this.rsrcTypeId = rsrcTypeId;
		this.rsrcDesc = rsrcDesc;
		this.actv = actv;
	}

	public Integer getRsrcId() {
		return rsrcId;
	}

	public void setRsrcId(Integer rsrcId) {
		this.rsrcId=rsrcId;
	}

	public Integer getRsrcTypeId() {
		return rsrcTypeId;
	}

	public void setRsrcTypeId(Integer rsrcTypeId) {
		this.rsrcTypeId=rsrcTypeId;
	}

	public String getRsrcDesc() {
		return rsrcDesc;
	}

	public void setRsrcDesc(String rsrcDesc) {
		this.rsrcDesc=rsrcDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "Resources [rsrcId=" + rsrcId + ", rsrcTypeId=" + rsrcTypeId + ", rsrcDesc=" + rsrcDesc + ", actv=" + actv + "]";
	}

	public static Resources fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Resources.class );
	}
	public ResourcesDTO toDTO() {
		return new ResourcesDTO(this.getRsrcId(),this.getRsrcTypeId(),this.getRsrcDesc(),this.getActv());
	}
}
