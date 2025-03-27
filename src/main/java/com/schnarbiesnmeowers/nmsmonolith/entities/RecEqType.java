package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.RecEqTypeDTO;
import jakarta.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "rec_eq_type")
public class RecEqType implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "rec_eq_type_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer recEqTypeId;

	/**
	 * "short code for equipment type (app = applicance&!@ etc...)" 
	 */
	@Column(name = "rec_eq_cde")
	private String recEqCde;

	/**
	 * "short description of the equipment type" 
	 */
	@Column(name = "rec_eq_desc")
	private String recEqDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public RecEqType() {
		super();
	}

	public RecEqType(Integer recEqTypeId, String recEqCde, String recEqDesc, String actv) {
		super();
		this.recEqTypeId = recEqTypeId;
		this.recEqCde = recEqCde;
		this.recEqDesc = recEqDesc;
		this.actv = actv;
	}

	public Integer getRecEqTypeId() {
		return recEqTypeId;
	}

	public void setRecEqTypeId(Integer recEqTypeId) {
		this.recEqTypeId=recEqTypeId;
	}

	public String getRecEqCde() {
		return recEqCde;
	}

	public void setRecEqCde(String recEqCde) {
		this.recEqCde=recEqCde;
	}

	public String getRecEqDesc() {
		return recEqDesc;
	}

	public void setRecEqDesc(String recEqDesc) {
		this.recEqDesc=recEqDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "RecEqType [recEqTypeId=" + recEqTypeId + ", recEqCde=" + recEqCde + ", recEqDesc=" + recEqDesc + ", actv=" + actv + "]";
	}

	public static RecEqType fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, RecEqType.class );
	}
	public RecEqTypeDTO toDTO() {
		return new RecEqTypeDTO(this.getRecEqTypeId(),this.getRecEqCde(),this.getRecEqDesc(),this.getActv());
	}
}
