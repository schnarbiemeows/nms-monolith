package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.SpicesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "spices")
public class Spices implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	@Column(name = "spice_id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer spiceId;

	/**
	 * "name of the spice" 
	 */
	@Column(name = "spice_name")
	private String spiceName;

	/**
	 * "is this record active(y or n)?" 
	 */
	@Column(name = "actv")
	private String actv;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	@Column(name = "image_loc")
	private Integer imageLoc;

	/**
	 * default constructor
	 */
	public Spices() {
		super();
	}

	public Spices(Integer spiceId, String spiceName, String actv, Integer imageLoc) {
		super();
		this.spiceId = spiceId;
		this.spiceName = spiceName;
		this.actv = actv;
		this.imageLoc = imageLoc;
	}

	public Integer getSpiceId() {
		return spiceId;
	}

	public void setSpiceId(Integer spiceId) {
		this.spiceId=spiceId;
	}

	public String getSpiceName() {
		return spiceName;
	}

	public void setSpiceName(String spiceName) {
		this.spiceName=spiceName;
	}

	public String getActv() {
		return actv;
	}

	public void setActv(String actv) {
		this.actv=actv;
	}

	public Integer getImageLoc() {
		return imageLoc;
	}

	public void setImageLoc(Integer imageLoc) {
		this.imageLoc=imageLoc;
	}

	@Override
	public String toString() {
		return "Spices [spiceId=" + spiceId + ", spiceName=" + spiceName + ", actv=" + actv + ", imageLoc=" + imageLoc + "]";
	}

	public static Spices fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Spices.class );
	}
	public SpicesDTO toDTO() {
		return new SpicesDTO(this.getSpiceId(),this.getSpiceName(),this.getActv(),this.getImageLoc());
	}
}
