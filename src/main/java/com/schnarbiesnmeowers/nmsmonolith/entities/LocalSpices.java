package com.schnarbiesnmeowers.nmsmonolith.entities;

import com.schnarbiesnmeowers.nmsmonolith.dtos.spices.LocalSpicesDTO;
import javax.persistence.*;
import java.io.Serializable;
import com.google.gson.Gson;

/**
 *
 * @author Dylan I. Kessler
 *
 */
@Entity
@Table(name = "local_spices")
public class LocalSpices implements Serializable {
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
	 * "fk to the user.user_id field") 
	 */
	@Column(name = "user_id")
	private Integer userId;

	/**
	 * default constructor
	 */
	public LocalSpices() {
		super();
	}

	public LocalSpices(Integer spiceId, String spiceName, String actv, Integer imageLoc, Integer userId) {
		super();
		this.spiceId = spiceId;
		this.spiceName = spiceName;
		this.actv = actv;
		this.imageLoc = imageLoc;
		this.userId = userId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId=userId;
	}

	@Override
	public String toString() {
		return "LocalSpices [spiceId=" + spiceId + ", spiceName=" + spiceName + ", actv=" + actv + ", imageLoc=" + imageLoc + ", userId=" + userId + "]";
	}

	public static LocalSpices fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalSpices.class );
	}
	public LocalSpicesDTO toDTO() {
		return new LocalSpicesDTO(this.getSpiceId(),this.getSpiceName(),this.getActv(),this.getImageLoc(),this.getUserId());
	}
}
