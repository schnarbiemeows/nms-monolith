package com.schnarbiesnmeowers.nmsmonolith.pojos;

import com.schnarbiesnmeowers.nmsmonolith.dtos.BldstTableDTO;
import javax.persistence.*;
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
@Table(name = "bldst_table")
public class BldstTable implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "bldst_table_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bldstTableId;

	/**
	 * "b = breakfast&!@ l = lunch&!@ etc..." 
	 */
	@Column(name = "bldst_cde")
	private String bldstCde;

	/**
	 * "breakfast&!@lunch&!@ etc..." 
	 */
	@Column(name = "bldst_desc")
	private String bldstDesc;

	/**
	 * "is this record active(y or n)?") 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * default constructor
	 */
	public BldstTable() {
		super();
	}

	public BldstTable(Integer bldstTableId, String bldstCde, String bldstDesc, String actv) {
		super();
		this.bldstTableId = bldstTableId;
		this.bldstCde = bldstCde;
		this.bldstDesc = bldstDesc;
		this.actv = actv;
	}

	public Integer getBldstTableId() {
		return bldstTableId;
	}

	public void setBldstTableId(Integer bldstTableId) {
		this.bldstTableId=bldstTableId;
	}

	public String getBldstCde() {
		return bldstCde;
	}

	public void setBldstCde(String bldstCde) {
		this.bldstCde=bldstCde;
	}

	public String getBldstDesc() {
		return bldstDesc;
	}

	public void setBldstDesc(String bldstDesc) {
		this.bldstDesc=bldstDesc;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	@Override
	public String toString() {
		return "BldstTable [bldstTableId=" + bldstTableId + ", bldstCde=" + bldstCde + ", bldstDesc=" + bldstDesc + ", actv=" + actv + "]";
	}

	public static BldstTable fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, BldstTable.class );
	}
	public BldstTableDTO toDTO() {
		return new BldstTableDTO(this.getBldstTableId(),this.getBldstCde(),this.getBldstDesc(),this.getActv());
	}
}
