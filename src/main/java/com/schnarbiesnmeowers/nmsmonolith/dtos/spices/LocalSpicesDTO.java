package com.schnarbiesnmeowers.nmsmonolith.dtos.spices;

import com.schnarbiesnmeowers.nmsmonolith.entities.LocalSpices;

import java.io.Serializable;
import com.google.gson.Gson;
import com.schnarbiesnmeowers.nmsmonolith.entities.Spices;

/**
 *
 * @author Dylan I. Kessler
 *
 */
public class LocalSpicesDTO implements Serializable {
	// default serial version id, required for serializable classes
	private static final long serialVersionUID = 1L;

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * 
	 */
	private Integer spiceId;

	/**
	 * "name of the spice" 
	 */
	private String spiceName;

	/**
	 * "is this record active(y or n)?" 
	 */
	private String actv;

	/**
	 * "fk to the image_loc.image_loc_id field" 
	 */
	private Integer imageLoc;

	/**
	 * "fk to the user.user_id field") 
	 */
	private Integer userId;

	/**
	 * default constructor
	 */
	public LocalSpicesDTO() {
		super();
	}

	public LocalSpicesDTO(Integer spiceId, String spiceName, String actv, Integer imageLoc, Integer userId) {
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
		return "LocalSpicesDTO [spiceId=" + spiceId + ", spiceName=" + spiceName + ", actv=" + actv + ", imageLoc=" + imageLoc + ", userId=" + userId + "]";
	}

	public static LocalSpicesDTO fromJson(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, LocalSpicesDTO.class );
	}
	public LocalSpices toEntity() {
		return new LocalSpices(this.getSpiceId(),this.getSpiceName(),this.getActv(),this.getImageLoc(),this.getUserId());
	}

	public Spices returnGlobalDTO() {
		return new Spices(this.spiceId,this.spiceName,this.actv,this.imageLoc);
	}

	public SpiceRecordDisplay toDisplayObject() {
		return new SpiceRecordDisplay(this.spiceId,this.spiceName,true);
	}
}
